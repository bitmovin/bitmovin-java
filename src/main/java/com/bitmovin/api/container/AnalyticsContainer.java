package com.bitmovin.api.container;

import com.bitmovin.api.analytics.license.AnalyticsDomainResource;
import com.bitmovin.api.analytics.license.AnalyticsLicenseResource;
import com.bitmovin.api.analytics.query.AnalyticsQueryResource;
import com.bitmovin.api.constants.ApiUrls;

import java.util.HashMap;

public class AnalyticsContainer
{
    public AnalyticsLicenseResource licenses;
    public AnalyticsDomainResource domains;
    public AnalyticsQueryResource query;

    public AnalyticsContainer(HashMap<String, String> headers)
    {
        this.licenses = new AnalyticsLicenseResource(headers, ApiUrls.analyticsLicense);
        this.domains = new AnalyticsDomainResource(headers);
        this.query = new AnalyticsQueryResource(headers, ApiUrls.analyticsQuery);
    }
}
