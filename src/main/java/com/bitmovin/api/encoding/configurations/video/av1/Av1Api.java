package com.bitmovin.api.encoding.configurations.video.av1;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.av1.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Av1Api
{
    private final Av1Client apiClient;
    public CustomdataApi customdata;

    public Av1Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Av1Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Av1Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Av1Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create AV1 Codec Configuration
    * 
    * @param av1VideoConfiguration  (optional)
    * @return Av1VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Av1VideoConfiguration create(Av1VideoConfiguration av1VideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(av1VideoConfiguration);
    }

    /**
    * Delete AV1 Codec Configuration
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
    * AV1 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Av1VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Av1VideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List AV1 Codec Configurations
    * 
    * @return List&lt;Av1VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Av1VideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List AV1 Codec Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Av1VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Av1VideoConfiguration> list(Av1VideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
