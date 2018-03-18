package com.daniesnata.myweather.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielsaldinata on 17/03/18.
 */
@XmlRootElement(name = "features")
public class FeatureList {

    private List<String> feature = new ArrayList<>();

    public FeatureList() {
    }

    public FeatureList(List<String> feature) {
        this.feature = feature;
    }

    @XmlElement(name = "feature")
    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }
}
