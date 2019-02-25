package com.bitmovin.api.analytics.queries.avg;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvgApi
{
    private final AvgClient apiClient;

    public AvgApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AvgApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AvgApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AvgClient.class);

    }


    /**
    * Avg
    * 
    * @param analyticsAvgQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsAvgQueryRequest analyticsAvgQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsAvgQueryRequest);
    }
}
