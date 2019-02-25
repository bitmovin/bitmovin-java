package com.bitmovin.api.encoding.manifests.hls.media.subtitles;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtitlesApi
{
    private final SubtitlesClient apiClient;

    public SubtitlesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SubtitlesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SubtitlesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SubtitlesClient.class);

    }


    /**
    * Add Subtitles Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param subtitlesMediaInfo  (optional)
    * @return SubtitlesMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public SubtitlesMediaInfo create(String manifestId, SubtitlesMediaInfo subtitlesMediaInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, subtitlesMediaInfo);
    }

    /**
    * Delete Subtitles Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the subtitles media. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId);
    }

    /**
    * Subtitles Media Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the subtitles media. (required)
    * @return SubtitlesMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public SubtitlesMediaInfo get(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId);
    }
    /**
    * List all Subtitles Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;SubtitlesMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SubtitlesMediaInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Subtitles Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SubtitlesMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SubtitlesMediaInfo> list(String manifestId, SubtitlesMediaInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
