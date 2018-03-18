package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "location")
public class Location {

    private String type;
    private String country;
    private String countryIso3166;
    private String countryName;
    private String state;
    private String city;
    private String timezoneShort;
    private String timezoneLong;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "country_iso3166")
    @JsonProperty("country_iso3166")
    public String getCountryIso3166() {
        return countryIso3166;
    }

    public void setCountryIso3166(String countryIso3166) {
        this.countryIso3166 = countryIso3166;
    }

    @XmlElement(name = "country_name")
    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "tz_short")
    @JsonProperty("tz_short")
    public String getTimezoneShort() {
        return timezoneShort;
    }

    public void setTimezoneShort(String timezoneShort) {
        this.timezoneShort = timezoneShort;
    }

    @XmlElement(name = "tz_long")
    @JsonProperty("tz_long")
    public String getTimezoneLong() {
        return timezoneLong;
    }

    public void setTimezoneLong(String timezoneLong) {
        this.timezoneLong = timezoneLong;
    }


}
