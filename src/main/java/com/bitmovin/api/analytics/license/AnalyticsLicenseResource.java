package com.bitmovin.api.analytics.license;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class AnalyticsLicenseResource extends AbstractResource<AnalyticsLicense>
{
    public AnalyticsLicenseResource(Map<String, String> headers, String url)
    {
        super(headers, url, AnalyticsLicense.class);
    }

    public List<AnalyticsLicense> getAnalyticsLicenses() throws BitmovinApiException, IOException, URISyntaxException, UnirestException
    {
        String url = ApiUrls.analyticsLicenses;
        return RestClient.getItems(url, this.headers, AnalyticsLicense.class);
    }

    public AnalyticsLicense getAnalyticsLicense(String licenseId) throws BitmovinApiException, IOException, URISyntaxException, UnirestException
    {
        String url = ApiUrls.analyticsLicense.replace("{analyticsLicenseId}", licenseId);
        return RestClient.getDetailsFromResponse(url, this.headers, AnalyticsLicense.class);
    }
}
