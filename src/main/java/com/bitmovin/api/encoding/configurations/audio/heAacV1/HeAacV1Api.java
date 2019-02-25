package com.bitmovin.api.encoding.configurations.audio.heAacV1;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.heAacV1.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeAacV1Api
{
    private final HeAacV1Client apiClient;
    public CustomdataApi customdata;

    public HeAacV1Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public HeAacV1Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public HeAacV1Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(HeAacV1Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create HE-AAC v1 Codec Configuration
    * 
    * @param heAacV1AudioConfiguration  (optional)
    * @return HeAacV1AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public HeAacV1AudioConfiguration create(HeAacV1AudioConfiguration heAacV1AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(heAacV1AudioConfiguration);
    }

    /**
    * Delete HE-AAC v1 Codec Configuration
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String configurationId) throws BitmovinException
    {
        return this.apiClient.delete(configurationId);
    }

    /**
    * HE-AAC v1 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return HeAacV1AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public HeAacV1AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List HE-AAC v1 Configurations
    * 
    * @return List&lt;HeAacV1AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HeAacV1AudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List HE-AAC v1 Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;HeAacV1AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HeAacV1AudioConfiguration> list(HeAacV1AudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
