package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "imperial_double_measurement")
@JsonRootName("imperial_double_measurement")
public class ImperialDoubleMeasurement {

    private Double imperial;
    private Integer metric;

    public ImperialDoubleMeasurement() {
    }

    @XmlElement(name = "english")
    @JsonProperty("english")
    public Double getImperial() {
        return imperial;
    }

    public void setImperial(Double imperial) {
        this.imperial = imperial;
    }

    public Integer getMetric() {
        return metric;
    }

    public void setMetric(Integer metric) {
        this.metric = metric;
    }
}
