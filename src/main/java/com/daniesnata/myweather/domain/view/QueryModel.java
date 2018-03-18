package com.daniesnata.myweather.domain.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class represent a query from View
 * @author danielsaldinata
 * @version 1.0
 */
public class QueryModel {

    private String location;
    private String sortedBy;
    private String sortDir;
    private String scale;
    private Integer size;

    public QueryModel() {
    }

    public QueryModel(String sortedBy, String sortDir, String scale, Integer size) {
        this.sortedBy = sortedBy;
        this.sortDir = sortDir;
        this.scale = scale;
        this.size = size;
    }

    public boolean isSizeValid() {
        return this.size != null && this.size > 0;
    }

    public boolean isLocationValid() {
        return this.location != null && !"".equalsIgnoreCase(this.location);
    }

    public boolean isSorted() {
        Optional<String> theColumn;
        if (this.sortedBy != null) {
            theColumn = HourlyView.FIELDS.stream().filter(this.sortedBy::equalsIgnoreCase).findFirst();
            return theColumn.isPresent();
        }
        return false;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    /**
     * This method is used to populate a html dropdown data
     * @return a Map String, key for html select.option value, value for html select.option text 
     */
    public Map<String, String> getSortByOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("location", "Location");
        options.put("time", "Time");
        options.put("condition", "Condition");
        options.put("temp", "Temperature");
        options.put("feelsLike", "Feels Like");
        options.put("precip", "Precipitation");
        options.put("amount", "Amount");
        options.put("humidity", "Humidity");
        options.put("wind", "Wind");
        options.put("pressure", "Pressure");
        return options;
    }

    /**
     * This method is used to populate a html dropdown data
     * @return a Map String, key for html select.option value, value for html select.option text
     */
    public Map<String, String> getSearchedLocations() {
        Map<String, String> options = new HashMap<>();
        options.put("NE/Omaha", "NE, Omaha");
        options.put("Japan/Sapporo", "Japan, Sapporo");
        options.put("NY/New_York", "NY, New York");
        options.put("Singapore/Raffles_Place", "Singapore, Raffles Place");
        options.put("Indonesia/Jakarta", "Indonesia, Jakarta");
        return options;
    }

    @Override
    public String toString() {
        return "QueryModel{" +
                "location='" + location + '\'' +
                ", sortedBy='" + sortedBy + '\'' +
                ", sortDir='" + sortDir + '\'' +
                ", scale='" + scale + '\'' +
                ", size=" + size +
                '}';
    }
}
