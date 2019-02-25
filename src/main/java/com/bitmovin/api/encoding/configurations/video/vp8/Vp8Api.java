package com.bitmovin.api.encoding.configurations.video.vp8;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.vp8.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vp8Api
{
    private final Vp8Client apiClient;
    public CustomdataApi customdata;

    public Vp8Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Vp8Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Vp8Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Vp8Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create VP8 Codec Configuration
    * 
    * @param vp8VideoConfiguration  (optional)
    * @return Vp8VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Vp8VideoConfiguration create(Vp8VideoConfiguration vp8VideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(vp8VideoConfiguration);
    }

    /**
    * Delete VP8 Codec Configuration
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
    * VP8 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Vp8VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Vp8VideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * 
    * 
    * @return List&lt;Vp8VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Vp8VideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * 
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Vp8VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Vp8VideoConfiguration> list(Vp8VideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
