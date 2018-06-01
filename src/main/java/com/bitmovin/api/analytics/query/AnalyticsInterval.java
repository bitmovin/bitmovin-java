package com.bitmovin.api.analytics.query;

public enum AnalyticsInterval
{
    MINUTE("MINUTE"),
    HOUR("HOUR"),
    DAY("DAY"),
    MONTH("MONTH");

    private final String text;

    AnalyticsInterval(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
