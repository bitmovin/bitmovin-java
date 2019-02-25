package com.bitmovin.api.encoding.configurations.audio.heAacV2;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.heAacV2.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeAacV2Api
{
    private final HeAacV2Client apiClient;
    public CustomdataApi customdata;

    public HeAacV2Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public HeAacV2Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public HeAacV2Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(HeAacV2Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create HE-AAC v2 Codec Configuration
    * 
    * @param heAacV2AudioConfiguration  (optional)
    * @return HeAacV2AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public HeAacV2AudioConfiguration create(HeAacV2AudioConfiguration heAacV2AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(heAacV2AudioConfiguration);
    }

    /**
    * Delete HE-AAC v2 Codec Configuration
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
    * HE-AAC v2 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return HeAacV2AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public HeAacV2AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List HE-AAC v2 Configurations
    * 
    * @return List&lt;HeAacV2AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HeAacV2AudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List HE-AAC v2 Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;HeAacV2AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<HeAacV2AudioConfiguration> list(HeAacV2AudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
