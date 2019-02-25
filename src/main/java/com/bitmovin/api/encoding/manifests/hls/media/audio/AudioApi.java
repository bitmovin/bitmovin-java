package com.bitmovin.api.encoding.manifests.hls.media.audio;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AudioApi
{
    private final AudioClient apiClient;

    public AudioApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AudioApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AudioApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AudioClient.class);

    }


    /**
    * Add Audio Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param audioMediaInfo  (optional)
    * @return AudioMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public AudioMediaInfo create(String manifestId, AudioMediaInfo audioMediaInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, audioMediaInfo);
    }

    /**
    * Delete Audio Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId);
    }

    /**
    * Audio Media Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the audio media. (required)
    * @return AudioMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public AudioMediaInfo get(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId);
    }
    /**
    * List all Audio Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;AudioMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioMediaInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Audio Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AudioMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AudioMediaInfo> list(String manifestId, AudioMediaInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
