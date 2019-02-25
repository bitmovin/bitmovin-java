package com.bitmovin.api.encoding.configurations.audio.aac;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.aac.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AacApi
{
    private final AacClient apiClient;
    public CustomdataApi customdata;

    public AacApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AacApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AacApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AacClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create AAC Codec Configuration
    * 
    * @param aacAudioConfiguration  (optional)
    * @return AacAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public AacAudioConfiguration create(AacAudioConfiguration aacAudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(aacAudioConfiguration);
    }

    /**
    * Delete AAC Codec Configuration
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
    * AAC Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return AacAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public AacAudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List AAC Configurations
    * 
    * @return List&lt;AacAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AacAudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List AAC Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AacAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AacAudioConfiguration> list(AacAudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
