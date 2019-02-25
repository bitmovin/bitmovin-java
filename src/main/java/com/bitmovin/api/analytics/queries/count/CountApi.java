package com.bitmovin.api.analytics.queries.count;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountApi
{
    private final CountClient apiClient;

    public CountApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CountApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CountApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CountClient.class);

    }


    /**
    * Count
    * 
    * @param analyticsCountQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsCountQueryRequest analyticsCountQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsCountQueryRequest);
    }
}
