package com.bitmovin.api.analytics.impressions;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResource;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class AnalyticsImpressionsResource extends AbstractResource<AnalyticsImpressionDetails>
{
    public AnalyticsImpressionsResource(Map<String, String> headers, String url)
    {
        super(headers, url, AnalyticsImpressionDetails.class);
    }

    public List<AnalyticsImpressionDetails> getDetails(String impressionId, String analyticsLicenseKey) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        String url = this.url.replace("{impressionId}", impressionId);
        AnalyticsImpressionDetails impression = new AnalyticsImpressionDetails();
        impression.setLicenseKey(analyticsLicenseKey);

        return RestClient.postAndGetResults(headers, url, impression, AnalyticsImpressionDetails.class);
    }
}
