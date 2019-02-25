package com.bitmovin.api.encoding.manifests.hls.media.video.iframe;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IframeApi
{
    private final IframeClient apiClient;

    public IframeApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public IframeApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public IframeApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(IframeClient.class);

    }


    /**
    * Add I-frame playlist to video media
    * 
    * @param manifestId Id of the hls manifest (required)
    * @param mediaId Id of the video media (required)
    * @param iframePlaylist  (optional)
    * @return IFramePlaylist
    * @throws BitmovinException if fails to make API call
    */
    public IFramePlaylist create(String manifestId, String mediaId, IFramePlaylist iframePlaylist) throws BitmovinException
    {
        return this.apiClient.create(manifestId, mediaId, iframePlaylist);
    }

    /**
    * Delete I-frame playlist
    * 
    * @param manifestId Id of the hls manifest (required)
    * @param mediaId Id of the video media (required)
    * @param iframeId Id of the Iframe-Playlist (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String mediaId, String iframeId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, mediaId, iframeId);
    }

    /**
    * I-frame playlist Details
    * 
    * @param manifestId Id of the hls manifest (required)
    * @param mediaId Id of the video media (required)
    * @param iframeId Id of the Iframe-Playlist (required)
    * @return IFramePlaylist
    * @throws BitmovinException if fails to make API call
    */
    public IFramePlaylist get(String manifestId, String mediaId, String iframeId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, mediaId, iframeId);
    }
    /**
    * List all I-frame playlists of a video media
    * 
    * @param manifestId Id of the hls manifest (required)
    * @param mediaId Id of the video media (required)
    * @return List&lt;IFramePlaylist&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IFramePlaylist> list(String manifestId, String mediaId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, mediaId, new HashMap<String, Object>());
    }

    /**
    * List all I-frame playlists of a video media
    * 
    * @param manifestId Id of the hls manifest (required)
    * @param mediaId Id of the video media (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;IFramePlaylist&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IFramePlaylist> list(String manifestId, String mediaId, IFramePlaylistsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, mediaId, queryParams);
    }
}
