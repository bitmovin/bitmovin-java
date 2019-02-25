package com.bitmovin.api.analytics.impressions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImpressionsApi
{
    private final ImpressionsClient apiClient;

    public ImpressionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ImpressionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ImpressionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ImpressionsClient.class);

    }


    /**
    * Impression Details
    * 
    * @param impressionId Impression id (required)
    * @param analyticsLicense Analytics license (optional)
    * @return AnalyticsImpressionDetails
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsImpressionDetails create(String impressionId, AnalyticsLicense analyticsLicense) throws BitmovinException
    {
        return this.apiClient.create(impressionId, analyticsLicense);
    }
}
