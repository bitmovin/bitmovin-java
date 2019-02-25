package com.bitmovin.api.analytics.queries.sum;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumApi
{
    private final SumClient apiClient;

    public SumApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SumApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SumApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SumClient.class);

    }


    /**
    * Sum
    * 
    * @param analyticsSumQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsSumQueryRequest analyticsSumQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsSumQueryRequest);
    }
}
