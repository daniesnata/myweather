package com.daniesnata.myweather.domain.view;

import com.daniesnata.myweather.domain.ForecastHourly;
import com.daniesnata.myweather.domain.ForecastTime;
import com.daniesnata.myweather.domain.Location;

import java.util.Arrays;
import java.util.List;

/**
 * The view model of weather information.
 * Being used to populate the List
 * @author danielsaldinata
 * @version 1.0
 */
public class HourlyView {

    public static final List<String> FIELDS = Arrays.asList("location", "time", "condition", "feelsLike", "precipitation", "amount", "dewPoint", "humidity", "wind", "pressure", "precip", "temp", "temp.", "feels like", "dew point");

    private Integer index;
    private Integer hour;
    private String amPm;
    private String location;
    private String time;
    private String condition;
    private Integer tempImperial;
    private Integer tempMetric;
    private Integer feelsLikeImperial;
    private Integer feelsLikeMetric;
    private Integer precipitation;
    private Double amountImperial;
    private Integer amountMetric;
    private Integer dewPointImperial;
    private Integer dewPointMetric;
    private Integer humidityImperial;
    private Integer humidityMetric;
    private Integer windSpeedImperial;
    private Integer windSpeedMetric;
    private String windImperial;
    private String windMetric;
    private Double pressureImperial;
    private Integer pressureMetric;
    private boolean metric;

    public HourlyView() {
    }

    public HourlyView(ForecastHourly forecast, Location location) {
        this.location = location.getCountryName() + ", " + location.getCity();
        ForecastTime fcttime = forecast.getFcttime();
        this.hour = fcttime.getHour();
        this.amPm = fcttime.getAmPm();
        this.time = fcttime.getWeekdayAbbrev() + " " + fcttime.getMonthDay() + " " + fcttime.getHour() + ":" + fcttime.getMinutePadded();
        this.condition = forecast.getCondition();
        this.tempImperial = forecast.getTemp().getImperial();
        this.tempMetric = forecast.getTemp().getMetric();
        this.feelsLikeImperial = forecast.getFeelsLike().getImperial();
        this.feelsLikeMetric = forecast.getFeelsLike().getMetric();
        this.precipitation = forecast.getPop();
        this.amountImperial = forecast.getQpf().getImperial();
        this.amountMetric = forecast.getQpf().getMetric();
        this.dewPointImperial = forecast.getDewpoint().getImperial();
        this.dewPointMetric = forecast.getDewpoint().getMetric();
        this.humidityImperial = forecast.getHumidity();
        this.humidityMetric = ((Long) Math.round((forecast.getHumidity() - 32) * 0.5556)).intValue();
        this.windSpeedImperial = forecast.getWindSpeed().getImperial();
        this.windSpeedMetric = forecast.getWindSpeed().getMetric();
        this.windImperial = forecast.getWindSpeed().getImperial() + " mph " + forecast.getWindDirection().getDirection();
        this.windMetric = forecast.getWindSpeed().getMetric() + " kph " + forecast.getWindDirection().getDirection();
        this.pressureImperial = forecast.getPressure().getImperial();
        this.pressureMetric = forecast.getPressure().getMetric();
        this.metric = true;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getTempImperial() {
        return tempImperial;
    }

    public void setTempImperial(Integer tempImperial) {
        this.tempImperial = tempImperial;
    }

    public Integer getTempMetric() {
        return tempMetric;
    }

    public void setTempMetric(Integer tempMetric) {
        this.tempMetric = tempMetric;
    }

    public Integer getFeelsLikeImperial() {
        return feelsLikeImperial;
    }

    public void setFeelsLikeImperial(Integer feelsLikeImperial) {
        this.feelsLikeImperial = feelsLikeImperial;
    }

    public Integer getFeelsLikeMetric() {
        return feelsLikeMetric;
    }

    public void setFeelsLikeMetric(Integer feelsLikeMetric) {
        this.feelsLikeMetric = feelsLikeMetric;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Integer precipitation) {
        this.precipitation = precipitation;
    }

    public Double getAmountImperial() {
        return amountImperial;
    }

    public void setAmountImperial(Double amountImperial) {
        this.amountImperial = amountImperial;
    }

    public Integer getAmountMetric() {
        return amountMetric;
    }

    public void setAmountMetric(Integer amountMetric) {
        this.amountMetric = amountMetric;
    }

    public Integer getDewPointImperial() {
        return dewPointImperial;
    }

    public void setDewPointImperial(Integer dewPointImperial) {
        this.dewPointImperial = dewPointImperial;
    }

    public Integer getDewPointMetric() {
        return dewPointMetric;
    }

    public void setDewPointMetric(Integer dewPointMetric) {
        this.dewPointMetric = dewPointMetric;
    }

    public Integer getHumidityImperial() {
        return humidityImperial;
    }

    public void setHumidityImperial(Integer humidityImperial) {
        this.humidityImperial = humidityImperial;
    }

    public Integer getHumidityMetric() {
        return humidityMetric;
    }

    public void setHumidityMetric(Integer humidityMetric) {
        this.humidityMetric = humidityMetric;
    }

    public Integer getWindSpeedImperial() {
        return windSpeedImperial;
    }

    public void setWindSpeedImperial(Integer windSpeedImperial) {
        this.windSpeedImperial = windSpeedImperial;
    }

    public Integer getWindSpeedMetric() {
        return windSpeedMetric;
    }

    public void setWindSpeedMetric(Integer windSpeedMetric) {
        this.windSpeedMetric = windSpeedMetric;
    }

    public String getWindImperial() {
        return windImperial;
    }

    public void setWindImperial(String windImperial) {
        this.windImperial = windImperial;
    }

    public String getWindMetric() {
        return windMetric;
    }

    public void setWindMetric(String windMetric) {
        this.windMetric = windMetric;
    }

    public Double getPressureImperial() {
        return pressureImperial;
    }

    public void setPressureImperial(Double pressureImperial) {
        this.pressureImperial = pressureImperial;
    }

    public Integer getPressureMetric() {
        return pressureMetric;
    }

    public void setPressureMetric(Integer pressureMetric) {
        this.pressureMetric = pressureMetric;
    }

    public boolean isMetric() {
        return metric;
    }

    public void setMetric(boolean metric) {
        this.metric = metric;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }
}
