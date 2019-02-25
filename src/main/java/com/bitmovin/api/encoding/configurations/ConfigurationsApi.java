package com.bitmovin.api.encoding.configurations;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.configurations.type.TypeApi;
import com.bitmovin.api.encoding.configurations.video.VideoApi;
import com.bitmovin.api.encoding.configurations.audio.AudioApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationsApi
{
    private final ConfigurationsClient apiClient;
    public TypeApi type;
    public VideoApi video;
    public AudioApi audio;

    public ConfigurationsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ConfigurationsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ConfigurationsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ConfigurationsClient.class);

        type = new TypeApi(clientFactory);
        video = new VideoApi(clientFactory);
        audio = new AudioApi(clientFactory);
    }

    /**
    * List all Codec Configurations
    * 
    * @return List&lt;CodecConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CodecConfiguration> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Codec Configurations
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CodecConfiguration&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CodecConfiguration> list(CodecConfigurationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
