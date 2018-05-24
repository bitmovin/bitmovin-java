package com.bitmovin.api.analytics.query;

import com.bitmovin.api.AbstractApiResponse;

import java.util.Arrays;
import java.util.List;

public class AnalyticsQuery extends AbstractApiResponse
{
    private String dimension;
    private int percentile;
    private String start;
    private String end;
    private AnalyticsInterval interval;
    private String functionParam;
    private String licenseKey;
    private List<String> groupBy;
    private List<AnalyticsOrderByEntry> orderBy;
    private List<AnalyticsFilter> filters;

    public AnalyticsQuery()
    {
    }

    public String getDimension()
    {
        return dimension;
    }

    public void setDimension(String dimension)
    {
        this.dimension = dimension;
    }

    public int getPercentile()
    {
        return percentile;
    }

    public void setPercentile(int percentile)
    {
        this.percentile = percentile;
    }

    public String getStart()
    {
        return start;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public String getEnd()
    {
        return end;
    }

    public void setEnd(String end)
    {
        this.end = end;
    }

    public AnalyticsInterval getInterval()
    {
        return interval;
    }

    public void setInterval(AnalyticsInterval interval)
    {
        this.interval = interval;
    }

    public List<AnalyticsFilter> getFilters()
    {
        return filters;
    }

    public void setFilters(List<AnalyticsFilter> filters)
    {
        this.filters = filters;
    }

    public String getFunctionParam()
    {
        return functionParam;
    }

    public void setFunctionParam(String functionParam)
    {
        this.functionParam = functionParam;
    }

    public String getLicenseKey()
    {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
    }

    public void setGroupBy(String... names)
    {
        this.groupBy = Arrays.asList(names);
    }

    public List<String> getGroupBy()
    {
        return this.groupBy;
    }

    public List<AnalyticsOrderByEntry> getOrderBy()
    {
        return orderBy;
    }

    public void setOrderBy(List<AnalyticsOrderByEntry> orderBy)
    {
        this.orderBy = orderBy;
    }
}
