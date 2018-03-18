package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "wdir")
@JsonRootName("wdir")
public class ForecastWindDirection {

    String direction;
    Integer degrees;

    public ForecastWindDirection() {
    }

    @XmlElement(name = "dir")
    @JsonProperty("dir")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }
}
