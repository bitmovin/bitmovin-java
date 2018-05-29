package com.bitmovin.api.analytics.query;

public enum AnalyticsOrder
{
    ASC("ASC"),
    DESC("DESC");

    private final String text;

    AnalyticsOrder(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
