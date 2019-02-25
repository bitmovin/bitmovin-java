package com.bitmovin.api.analytics.queries.min;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinApi
{
    private final MinClient apiClient;

    public MinApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MinApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MinApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MinClient.class);

    }


    /**
    * Min
    * 
    * @param analyticsMinQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsMinQueryRequest analyticsMinQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsMinQueryRequest);
    }
}
