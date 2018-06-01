package com.bitmovin.api.examples.analytics;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.analytics.impressions.AnalyticsImpressionDetails;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GetImpressionDetails
{
    private static final String apiKey = "<INSERT_YOUR_API_KEY>";
    private static final String analyticsLicenseKey = "<INSERT_YOUR_ANALYTICS_LICENSE_KEY>";
    private static final String impressionId = "<INSERT_IMPRESSION_ID>";

    private BitmovinApi bitmovinApi;

    @Before
    public void setUp() throws Exception
    {
        this.bitmovinApi = new BitmovinApi(apiKey);
    }

    @Test
    public void testGetImpressionDetails() throws Exception
    {
        List<AnalyticsImpressionDetails> impressionDetails = bitmovinApi.analytics.impressions.getDetails(impressionId, analyticsLicenseKey);
        for (AnalyticsImpressionDetails details : impressionDetails)
        {
            System.out.println(new JSONObject(details));
        }
    }
}
