package com.bitmovin.api.encoding.configurations.audio.mp3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.audio.mp3.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mp3Api
{
    private final Mp3Client apiClient;
    public CustomdataApi customdata;

    public Mp3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public Mp3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public Mp3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(Mp3Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create MP3 Codec Configuration
    * 
    * @param mp3AudioConfiguration  (optional)
    * @return Mp3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Mp3AudioConfiguration create(Mp3AudioConfiguration mp3AudioConfiguration) throws BitmovinException
    {
        return this.apiClient.create(mp3AudioConfiguration);
    }

    /**
    * Delete MP3 Codec Configuration
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
    * MP3 Codec Configuration Details
    * 
    * @param configurationId Id of the codec configuration (required)
    * @return Mp3AudioConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public Mp3AudioConfiguration get(String configurationId) throws BitmovinException
    {
        return this.apiClient.get(configurationId);
    }
    /**
    * List MP3 Configurations
    * 
    * @return List&lt;Mp3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp3AudioConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List MP3 Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Mp3AudioConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Mp3AudioConfiguration> list(Mp3AudioConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
