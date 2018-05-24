package com.bitmovin.api.analytics.license;

import com.bitmovin.api.AbstractApiResponse;

public class AnalyticsLicenseDomain extends AbstractApiResponse
{
    private String url;

    public AnalyticsLicenseDomain()
    {
    }

    public AnalyticsLicenseDomain(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
