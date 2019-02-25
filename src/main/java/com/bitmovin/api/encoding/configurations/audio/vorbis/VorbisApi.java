package com.bitmovin.api.encoding.configurations.audio.vorbis;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.vorbis.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VorbisApi
{
    private final VorbisClient apiClient;
    public CustomdataApi customdata;

    public VorbisApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VorbisApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VorbisApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VorbisClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Vorbis Codec Configuration
    * 
    * @param vorbisAudioConfiguration  (optional)
    * @return VorbisAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public VorbisAudioConfiguration create(VorbisAudioConfiguration vorbisAudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(vorbisAudioConfiguration);
    }

    /**
    * Delete Vorbis Codec Configuration
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
    * Vorbis Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return VorbisAudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public VorbisAudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List Vorbis Configurations
    * 
    * @return List&lt;VorbisAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VorbisAudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Vorbis Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;VorbisAudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VorbisAudioConfiguration> list(VorbisAudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
