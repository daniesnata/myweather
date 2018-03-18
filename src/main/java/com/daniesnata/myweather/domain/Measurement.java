package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "measurement")
@JsonRootName("measurement")
public class Measurement {

    private Integer imperial;
    private Integer metric;

    public Measurement() {
    }

    @XmlElement(name = "english")
    @JsonProperty("english")
    public Integer getImperial() {
        return imperial;
    }

    public void setImperial(Integer imperial) {
        this.imperial = imperial;
    }

    public Integer getMetric() {
        return metric;
    }

    public void setMetric(Integer metric) {
        this.metric = metric;
    }
}
