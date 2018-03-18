package com.daniesnata.myweather.service;

import com.daniesnata.myweather.data.WeatherRepository;
import com.daniesnata.myweather.domain.Weather;
import com.daniesnata.myweather.domain.view.HourlyView;
import com.daniesnata.myweather.util.ApiLinkBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is the service layer of Weather retrieval
 * Retrieves predefined values from application.properties
 *    the Wunderground API key, 
 *    the features for accessing the API, 
 *    and the locations where the weather data are going to be retrieved, in country/location pair
 *    
 * @author danielsaldinata
 * @version 1.0
 */
@Service
@Transactional
@PropertySource("classpath:application.properties")
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Value("${wunderground.api.key}")
    private String key;

    @Value("#{'${wunderground.api.features}'.split(',')}")
    private List<String> features;

    @Value("#{'${com.daniesnata.myweather.locations.default}'.split(',')}")
    private List<String> defaultLocations;

    public WeatherService(final WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    /**
     * This method is going to retrieve all the weather information requested from Controller layer
     * @return a list of weather data for each Hour
     */
    public List<HourlyView> getWeatherInformation() {
        List<HourlyView> hourlyViews = new ArrayList<>();
        for (String location : this.defaultLocations) {
            Weather weather = this.findByCountryLocation(location, this.features);
            hourlyViews.addAll(
                    weather.getForecastHourlyList().getForecastHourlyList()
                            .stream()
                            .map(forecast -> new HourlyView(forecast, weather.getLocation()))
                            .collect(Collectors.toList())
            );
        }
        return hourlyViews;
    }

    /**
     * This method retrieves the weather information from one country/location
     * @param countryLocation the locations
     * @param features all features to used for the API
     * @return a single Weather domain class
     */
    public Weather findByCountryLocation(String countryLocation, List<String> features) {

        Weather weather = this.findTodayAndLater(countryLocation);

        if (weather == null) {

            String link = new ApiLinkBuilder(this.key, countryLocation).feature(features).content("xml").build();

            weather = new RestTemplate().getForObject(link, Weather.class);

            weather.setCountryLocation(countryLocation);
            weather.setCountry(weather.getLocation().getCountryName());
            weather.setcLocation(weather.getLocation().getCity());
            weather.setCreatedAt(this.getZonedDateTimeNowInUtc());

            this.weatherRepository.insert(weather);
        }

        return weather;
    }


    /**
     * This method find the document which the information is for today and later (tomorror, or the day after) according the country/location
     * @param countryAndLocation the locations
     * @return a single Weather domain class
     */
    private Weather findTodayAndLater(String countryAndLocation) {
        ZonedDateTime today = ZonedDateTime.of(this.getZonedDateTimeNowInUtc().toLocalDate(), LocalTime.MIDNIGHT, ZoneId.of("UTC"));
        return this.weatherRepository.findByCreatedAtGreaterThan(countryAndLocation, today);
    }

    private ZonedDateTime getZonedDateTimeNowInUtc() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }


}
