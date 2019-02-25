package com.bitmovin.api.analytics.queries.stddev;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StddevApi
{
    private final StddevClient apiClient;

    public StddevApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StddevApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StddevApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StddevClient.class);

    }


    /**
    * Stddev
    * 
    * @param analyticsStddevQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsStddevQueryRequest analyticsStddevQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsStddevQueryRequest);
    }
}
