package com.bitmovin.api.analytics.license;

import com.bitmovin.api.AbstractApiResponse;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsLicense extends AbstractApiResponse
{
    private String id;
    private String name;
    private String licenseKey;
    private Long maxImpressions;
    private Long impressions;
    private List<AnalyticsLicenseDomain> domains;

    public AnalyticsLicense()
    {
        this.domains = new ArrayList<>();
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLicenseKey()
    {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
    }

    public List<AnalyticsLicenseDomain> getDomains()
    {
        return domains;
    }

    public void setDomains(List<AnalyticsLicenseDomain> domains)
    {
        this.domains = domains;
    }

    public Long getMaxImpressions()
    {
        return maxImpressions;
    }

    public void setMaxImpressions(Long maxImpressions)
    {
        this.maxImpressions = maxImpressions;
    }

    public Long getImpressions()
    {
        return impressions;
    }

    public void setImpressions(Long impressions)
    {
        this.impressions = impressions;
    }
}
