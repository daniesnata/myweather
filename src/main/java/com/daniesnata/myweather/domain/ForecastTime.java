package com.daniesnata.myweather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "forecast_time")
@JsonRootName("forecast_time")
public class ForecastTime {

    private Integer hour;
    private String hourPadded;
    private Integer minute;
    private String minutePadded;
    private Integer year;
    private Integer monthDay;
    private String monthDayPadded;
    private Integer month;
    private String monthPadded;
    private String monthNameAbbrev;
    private Boolean isDst;
    private String civil;
    private String weekdayName;
    private String weekdayAbbrev;
    private String amPm;

    public ForecastTime() {
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @XmlElement(name = "hour_padded")
    @JsonProperty("hour_padded")
    public String getHourPadded() {
        return hourPadded;
    }

    public void setHourPadded(String hourPadded) {
        this.hourPadded = hourPadded;
    }

    @XmlElement(name = "min_unpadded")
    @JsonProperty("min_unpadded")
    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    @XmlElement(name = "min")
    @JsonProperty("min")
    public String getMinutePadded() {
        return minutePadded;
    }

    public void setMinutePadded(String minutePadded) {
        this.minutePadded = minutePadded;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @XmlElement(name = "mday")
    @JsonProperty("mday")
    public Integer getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay) {
        this.monthDay = monthDay;
    }

    public String getMonthDayPadded() {
        return monthDayPadded;
    }

    public void setMonthDayPadded(String monthDayPadded) {
        this.monthDayPadded = monthDayPadded;
    }

    @XmlElement(name = "mon")
    @JsonProperty("mon")
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @XmlElement(name = "mon_padded")
    @JsonProperty("mon_padded")
    public String getMonthPadded() {
        return monthPadded;
    }

    public void setMonthPadded(String monthPadded) {
        this.monthPadded = monthPadded;
    }

    @XmlElement(name = "month_name_abbrev")
    @JsonProperty("month_name_abbrev")
    public String getMonthNameAbbrev() {
        return monthNameAbbrev;
    }

    public void setMonthNameAbbrev(String monthNameAbbrev) {
        this.monthNameAbbrev = monthNameAbbrev;
    }

    @XmlElement(name = "isdst")
    @JsonProperty("isdst")
    public Boolean getDst() {
        return isDst;
    }

    public void setDst(Boolean dst) {
        isDst = dst;
    }

    public String getCivil() {
        return civil;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }

    @XmlElement(name = "weekday_name")
    @JsonProperty("weekday_name")
    public String getWeekdayName() {
        return weekdayName;
    }

    public void setWeekdayName(String weekdayName) {
        this.weekdayName = weekdayName;
    }

    @XmlElement(name = "weekday_name_abbrev")
    @JsonProperty("weekday_name_abbrev")
    public String getWeekdayAbbrev() {
        return weekdayAbbrev;
    }

    public void setWeekdayAbbrev(String weekdayAbbrev) {
        this.weekdayAbbrev = weekdayAbbrev;
    }

    @XmlElement(name = "ampm")
    @JsonProperty("ampm")
    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }
}
