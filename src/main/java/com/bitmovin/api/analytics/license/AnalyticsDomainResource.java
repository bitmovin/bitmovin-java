package com.bitmovin.api.analytics.license;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;

public class AnalyticsDomainResource
{
    private Map<String, String> headers;

    public AnalyticsDomainResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public AnalyticsLicenseDomain addDomain(AnalyticsLicense analyticsLicense, String domain) throws BitmovinApiException, IOException, URISyntaxException, UnirestException
    {
        String addDomainUrl = Paths.get(ApiUrls.analyticsLicense.replace("{analyticsLicenseId}", analyticsLicense.getId()), "domains").toString();

        AnalyticsLicenseDomain domainBody = new AnalyticsLicenseDomain();
        domainBody.setUrl(domain);

        return RestClient.post(this.headers, addDomainUrl, domainBody, AnalyticsLicenseDomain.class);
    }

    public void deleteDomain(AnalyticsLicense analyticsLicense, AnalyticsLicenseDomain domain) throws BitmovinApiException, IOException, URISyntaxException, UnirestException, RestException
    {
        String deleteDomainUrl = Paths.get(ApiUrls.analyticsLicense.replace("{analyticsLicenseId}", analyticsLicense.getId()), "domains", domain.getId()).toString();

        RestClient.delete(deleteDomainUrl, this.headers, domain);
    }
}
