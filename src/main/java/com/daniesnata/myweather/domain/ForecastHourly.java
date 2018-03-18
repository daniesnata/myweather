package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "forecast")
@JsonRootName("forecast")
public class ForecastHourly {

    private ForecastTime fcttime;
    private Measurement temp;
    private Measurement dewpoint;
    private String condition;
    private Measurement windSpeed;
    private ForecastWindDirection windDirection;
    private Measurement windChill;
    private Measurement feelsLike;
    private Integer humidity;
    private Integer pop;
    private ImperialDoubleMeasurement pressure;
    private ImperialDoubleMeasurement qpf;

    public ForecastHourly() {
    }

    @XmlElement(name = "FCTTIME")
    @JsonProperty("FCTTIME")
    public ForecastTime getFcttime() {
        return fcttime;
    }

    public void setFcttime(ForecastTime fcttime) {
        this.fcttime = fcttime;
    }

    public Measurement getTemp() {
        return temp;
    }

    public void setTemp(Measurement temp) {
        this.temp = temp;
    }

    @XmlElement(name = "dewpoint")
    @JsonProperty("dewpoint")
    public Measurement getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Measurement dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @XmlElement(name = "wspd")
    @JsonProperty("wspd")
    public Measurement getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Measurement windSpeed) {
        this.windSpeed = windSpeed;
    }

    @XmlElement(name = "wdir")
    @JsonProperty("wdir")
    public ForecastWindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(ForecastWindDirection windDirection) {
        this.windDirection = windDirection;
    }

    @XmlElement(name = "windchill")
    @JsonProperty("windchill")
    public Measurement getWindChill() {
        return windChill;
    }

    public void setWindChill(Measurement windChill) {
        this.windChill = windChill;
    }

    @XmlElement(name = "feelslike")
    @JsonProperty("feelslike")
    public Measurement getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Measurement feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    @XmlElement(name = "mslp")
    @JsonProperty("mslp")
    public ImperialDoubleMeasurement getPressure() {
        return pressure;
    }

    public void setPressure(ImperialDoubleMeasurement pressure) {
        this.pressure = pressure;
    }

    public ImperialDoubleMeasurement getQpf() {
        return qpf;
    }

    public void setQpf(ImperialDoubleMeasurement qpf) {
        this.qpf = qpf;
    }
}
