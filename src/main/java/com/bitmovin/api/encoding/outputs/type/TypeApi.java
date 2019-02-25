package com.bitmovin.api.encoding.outputs.type;

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
    * Get Output Type
    * 
    * @param outputId Id of the wanted output (required)
    * @return OutputTypeResponse
    * @throws BitmovinException if fails to make API call
    */
    public OutputTypeResponse get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
}
