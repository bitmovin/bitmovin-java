package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingFeatureInformation
{
    private Double encodedMinutes;
    private String featureType;
    private Double featureMultiplier;
    private Double billableMinutes;

    public EncodingFeatureInformation()
    {
    }

    public Double getEncodedMinutes()
    {
        return this.encodedMinutes;
    }

    public void setEncodedMinutes(Double encodedMinutes)
    {
        this.encodedMinutes = encodedMinutes;
    }

    public Double getBillableMinutes()
    {
        return this.billableMinutes;
    }

    public void setBillableMinutes(Double billableMinutes)
    {
        this.billableMinutes = billableMinutes;
    }

    public String getFeatureType()
    {
        return this.featureType;
    }

    public void setFeatureType(String featureType)
    {
        this.featureType = featureType;
    }

    public Double getFeatureMultiplier()
    {
        return this.featureMultiplier;
    }

    public void setFeatureMultiplier(Double featureMultiplier)
    {
        this.featureMultiplier = featureMultiplier;
    }

    @Override
    public String toString()
    {
        return "EncodingFeatureInformation{" +
                "encodedMinutes=" + encodedMinutes +
                ", featureType='" + featureType + '\'' +
                ", featureMultiplier=" + featureMultiplier +
                ", billableMinutes=" + billableMinutes +
                '}';
    }
}
