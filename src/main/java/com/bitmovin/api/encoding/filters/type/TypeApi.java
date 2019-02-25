package com.bitmovin.api.encoding.filters.type;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeApi
{
    private final TypeClient apiClient;

    public TypeApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TypeApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TypeApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TypeClient.class);

    }


    /**
    * Get Filter Type
    * 
    * @param filterId Id of the filter (required)
    * @return FilterTypeResponse
    * @throws BitmovinException if fails to make API call
    */
    public FilterTypeResponse get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
}
