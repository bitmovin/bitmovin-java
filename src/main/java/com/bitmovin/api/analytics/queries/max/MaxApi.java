package com.bitmovin.api.analytics.queries.max;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxApi
{
    private final MaxClient apiClient;

    public MaxApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public MaxApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public MaxApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(MaxClient.class);

    }


    /**
    * Max
    * 
    * @param analyticsMaxQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsMaxQueryRequest analyticsMaxQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsMaxQueryRequest);
    }
}
