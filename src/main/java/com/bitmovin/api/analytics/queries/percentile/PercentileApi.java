package com.bitmovin.api.analytics.queries.percentile;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentileApi
{
    private final PercentileClient apiClient;

    public PercentileApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PercentileApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PercentileApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PercentileClient.class);

    }


    /**
    * Percentile
    * 
    * @param analyticsPercentileQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsPercentileQueryRequest analyticsPercentileQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsPercentileQueryRequest);
    }
}
