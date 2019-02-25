package com.bitmovin.api.encoding.configurations.audio.opus;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.opus.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpusApi
{
    private final OpusClient apiClient;
    public CustomdataApi customdata;

    public OpusApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public OpusApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public OpusApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(OpusClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Opus Codec Configuration
    * 
    * @param opusAudioConfiguration  (optional)
    * @return OpusAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public OpusAudioConfiguration create(OpusAudioConfiguration opusAudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(opusAudioConfiguration);
    }

    /**
    * Delete Opus Codec Configuration
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
    * Opus Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return OpusAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public OpusAudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List Opus Configurations
    * 
    * @return List&lt;OpusAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<OpusAudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Opus Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;OpusAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<OpusAudioConfiguration> list(OpusAudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
