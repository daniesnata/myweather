package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "hourly_forecast")
@JsonRootName("hourly_forecast")
public class ForecastHourlyList {

    private List<ForecastHourly> forecastHourlyList = new ArrayList<>();

    public ForecastHourlyList() {
    }

    public ForecastHourlyList(List<ForecastHourly> forecastHourlyList) {
        this.forecastHourlyList = forecastHourlyList;
    }

    @XmlElement(name = "forecast")
    @JsonProperty("forecast")
    public List<ForecastHourly> getForecastHourlyList() {
        return forecastHourlyList;
    }

    public void setForecastHourlyList(List<ForecastHourly> forecastHourlyList) {
        this.forecastHourlyList = forecastHourlyList;
    }
}
