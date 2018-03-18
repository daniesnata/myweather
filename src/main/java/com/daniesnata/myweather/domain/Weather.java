package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.ZonedDateTime;

/**
 * The Top class representing as the weather collections in DB
 * @author danielsaldinata
 * @version 1.0
 */
@Document(collection = "weathers")
@XmlRootElement(name = "response")
public class Weather {

    @Id
    private String id;
    @Indexed
    private String countryLocation;
    private String country;
    private String cLocation;
    private FeatureList features;
    private Location location;
    private ForecastHourlyList forecastHourlyList;
    private ZonedDateTime createdAt;

    public Weather() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlTransient
    @JsonIgnore
    public String getCountryLocation() {
        return countryLocation;
    }

    public void setCountryLocation(String countryLocation) {
        this.countryLocation = countryLocation;
    }

    public FeatureList getFeatures() {
        return features;
    }

    public void setFeatures(FeatureList features) {
        this.features = features;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @XmlElement(name = "hourly_forecast")
    @JsonProperty("hourly_forecast")
    public ForecastHourlyList getForecastHourlyList() {
        return forecastHourlyList;
    }

    public void setForecastHourlyList(ForecastHourlyList forecastHourlyList) {
        this.forecastHourlyList = forecastHourlyList;
    }

    @XmlTransient
    @JsonIgnore
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    @JsonIgnore
    public String getcLocation() {
        return cLocation;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation;
    }
}

