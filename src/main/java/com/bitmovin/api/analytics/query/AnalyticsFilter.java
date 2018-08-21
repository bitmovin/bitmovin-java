package com.bitmovin.api.analytics.query;

public class AnalyticsFilter
{
    private String name;

    public AnalyticsFilter() {}

    public AnalyticsFilter(String name, AnalyticsOperator operator, Object value) {
        this.name = name;
        this.operator = operator;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AnalyticsOperator getOperator()
    {
        return operator;
    }

    public void setOperator(AnalyticsOperator operator)
    {
        this.operator = operator;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    private AnalyticsOperator operator;
    private Object value;
}
