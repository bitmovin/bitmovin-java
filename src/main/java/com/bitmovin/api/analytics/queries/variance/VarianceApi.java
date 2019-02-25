package com.bitmovin.api.analytics.queries.variance;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarianceApi
{
    private final VarianceClient apiClient;

    public VarianceApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VarianceApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VarianceApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VarianceClient.class);

    }


    /**
    * Variance
    * 
    * @param analyticsVarianceQueryRequest  (optional)
    * @return AnalyticsResponse
    * @throws BitmovinException if fails to make API call
    */
    public AnalyticsResponse create(AnalyticsVarianceQueryRequest analyticsVarianceQueryRequest) throws BitmovinException
    {
        return this.apiClient.create(analyticsVarianceQueryRequest);
    }
}
