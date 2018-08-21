package com.bitmovin.api.analytics.query;

public enum AnalyticsOperator
{
    EQ("EQ"),
    NE("NE"),
    LT("LT"),
    LTE("LTE"),
    GT("GT"),
    GTE("GTE"),
    CONTAINS("CONTAINS"),
    NOTCONTAINS("NOTCONTAINS");

    private final String text;

    AnalyticsOperator(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }
}
