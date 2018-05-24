package com.bitmovin.api.analytics.query;

public enum AnalyticsQueryMethod
{
    COUNT("count"),
    SUM("sum"),
    AVG("avg"),
    MIN("min"),
    MAX("max"),
    MEDIAN("median"),
    PERCENTILE("percentile"),
    STDDEV("stddev"),
    VARIANCE("variance");

    private final String text;

    AnalyticsQueryMethod(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
