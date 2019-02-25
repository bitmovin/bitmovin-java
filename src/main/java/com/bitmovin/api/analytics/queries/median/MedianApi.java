package com.bitmovin.api.analytics.queries.median;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedianApi
{
    private final MedianClient apiClient;

    public MedianApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MedianApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MedianApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MedianClient.class);

    }


    /**
    * Median
    * 
    * @param analyticsMedianQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsMedianQueryRequest analyticsMedianQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsMedianQueryRequest);
    }
}
