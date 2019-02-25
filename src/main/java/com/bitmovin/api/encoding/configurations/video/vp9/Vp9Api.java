package com.bitmovin.api.encoding.configurations.video.vp9;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.video.vp9.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vp9Api
{
    private final Vp9Client apiClient;
    public CustomdataApi customdata;

    public Vp9Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Vp9Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Vp9Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Vp9Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create VP9 Codec Configuration
    * 
    * @param vp9VideoConfiguration  (optional)
    * @return Vp9VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Vp9VideoConfiguration create(Vp9VideoConfiguration vp9VideoConfiguration) throws BitmovinException
    {
        return this.apiClient.create(vp9VideoConfiguration);
    }

    /**
    * Delete VP9 Codec Configuration
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
    * VP9 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Vp9VideoConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Vp9VideoConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List VP9 Codec Configurations
    * 
    * @return List&lt;Vp9VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Vp9VideoConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List VP9 Codec Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Vp9VideoConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Vp9VideoConfiguration> list(Vp9VideoConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
