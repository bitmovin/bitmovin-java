package com.bitmovin.api.analytics.query;

public class AnalyticsOrderByEntry
{
    private String name;
    private AnalyticsOrder order;

    public AnalyticsOrderByEntry(String name, AnalyticsOrder order)
    {
        this.name = name;
        this.order = order;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AnalyticsOrder getOrder()
    {
        return order;
    }

    public void setOrder(AnalyticsOrder order)
    {
        this.order = order;
    }
}
