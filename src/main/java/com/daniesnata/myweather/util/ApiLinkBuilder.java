package com.daniesnata.myweather.util;

import java.util.*;
import java.util.function.Consumer;

/**
 * This class being used as the builder of the link to the API
 * @author danielsaldinata
 * @version 1.0
 */
public class ApiLinkBuilder {

    private final String apiLink = "http://api.wunderground.com/api";
    private String apiKey;
    private String query;
    private String content = "json";
    private Set<String> features2 = new HashSet<>();

    private Consumer<String> addToSet2 = feature -> this.features2.add(feature);

    public ApiLinkBuilder(String apiKey, String query) {
        this.apiKey = apiKey;
        this.query = query;
    }

    public ApiLinkBuilder feature(List<String> features) {
        features.forEach(addToSet2);
        return this;
    }

    public ApiLinkBuilder feature(String... features) {
        Arrays.asList(features).forEach(addToSet2);
        return this;
    }

    public ApiLinkBuilder content(String jsonOrXml) {
        if ("json".equalsIgnoreCase(jsonOrXml) || "xml".equalsIgnoreCase(jsonOrXml))
            this.content = jsonOrXml;

        return this;
    }


    public String build() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.apiLink + "/").append(apiKey);
        features2.forEach(feature -> sb.append("/" + feature));
        sb.append("/q/").append(query);
        sb.append(".").append(content);
        return sb.toString();
    }

}
