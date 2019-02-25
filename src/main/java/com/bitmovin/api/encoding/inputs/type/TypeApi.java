package com.bitmovin.api.encoding.inputs.type;

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
    * Get Input Type
    * 
    * @param inputId Id of the input (required)
    * @return InputTypeResponse
    * @throws BitmovinException if fails to make API call
    */
    public InputTypeResponse get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
}
