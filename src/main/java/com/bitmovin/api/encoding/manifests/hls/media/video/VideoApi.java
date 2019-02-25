package com.bitmovin.api.encoding.manifests.hls.media.video;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.hls.media.video.iframe.IframeApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoApi
{
    private final VideoClient apiClient;
    public IframeApi iframe;

    public VideoApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VideoApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VideoApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VideoClient.class);

        iframe = new IframeApi(clientFactory);
    }


    /**
    * Add Video Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param videoMediaInfo  (optional)
    * @return VideoMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public VideoMediaInfo create(String manifestId, VideoMediaInfo videoMediaInfo) throws BitmovinException
    {
        return this.apiClient.create(manifestId, videoMediaInfo);
    }

    /**
    * Delete Video Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the video media. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId);
    }

    /**
    * Video Media Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param mediaId Id of the video media. (required)
    * @return VideoMediaInfo
    * @throws BitmovinException if fails to make API call
    */
    public VideoMediaInfo get(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId);
    }
    /**
    * List all Video Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @return List&lt;VideoMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VideoMediaInfo> list(String manifestId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, new HashMap<String, Object>());
    }

    /**
    * List all Video Media
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;VideoMediaInfo&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<VideoMediaInfo> list(String manifestId, VideoMediaInfosListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, queryParams);
    }
}
