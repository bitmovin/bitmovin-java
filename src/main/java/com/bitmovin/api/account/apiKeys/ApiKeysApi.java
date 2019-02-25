package com.bitmovin.api.account.apiKeys;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiKeysApi
{
    private final ApiKeysClient apiClient;

    public ApiKeysApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ApiKeysApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ApiKeysApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ApiKeysClient.class);

    }


    /**
    * Create Api Key
    * 
    * @return AccountApiKey
    * @throws BitmovinException if fails to make API call
    */
    public AccountApiKey create() throws BitmovinException
    {
        return this.apiClient.create();
    }

    /**
    * Delete Api Key
    * 
    * @param apiKeyId Id of the api key (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String apiKeyId) throws BitmovinException
    {
        return this.apiClient.delete(apiKeyId);
    }

    /**
    * Get Api Key
    * 
    * @param apiKeyId Id of the api key (required)
    * @return AccountApiKey
    * @throws BitmovinException if fails to make API call
    */
    public AccountApiKey get(String apiKeyId) throws BitmovinException
    {
        return this.apiClient.get(apiKeyId);
    }

    /**
    * List Api Keys
    * 
    * @return List&lt;AccountApiKey&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AccountApiKey> list() throws BitmovinException
    {
        return this.apiClient.list();
    }
}
