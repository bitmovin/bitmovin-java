package com.bitmovin.api.encoding.manifests.hls.streams.iframe;

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
    * Add I-frame playlist to variant stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param iframePlaylist  (optional)
    * @return IFramePlaylist
    * @throws BitmovinException if fails to make API call
    */
    public IFramePlaylist create(String manifestId, String streamId, IFramePlaylist iframePlaylist) throws BitmovinException
    {
        return this.apiClient.create(manifestId, streamId, iframePlaylist);
    }

    /**
    * Delete I-frame playlist
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param iframeId Id of the Iframe-Playlist. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String manifestId, String streamId, String iframeId) throws BitmovinException
    {
        return this.apiClient.delete(manifestId, streamId, iframeId);
    }

    /**
    * I-frame playlist Details
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param iframeId Id of the Iframe-Playlist. (required)
    * @return IFramePlaylist
    * @throws BitmovinException if fails to make API call
    */
    public IFramePlaylist get(String manifestId, String streamId, String iframeId) throws BitmovinException
    {
        return this.apiClient.get(manifestId, streamId, iframeId);
    }
    /**
    * List all I-frame playlists of a variant stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @return List&lt;IFramePlaylist&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IFramePlaylist> list(String manifestId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(manifestId, streamId, new HashMap<String, Object>());
    }

    /**
    * List all I-frame playlists of a variant stream
    * 
    * @param manifestId Id of the hls manifest. (required)
    * @param streamId Id of the variant stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;IFramePlaylist&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<IFramePlaylist> list(String manifestId, String streamId, IFramePlaylistsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(manifestId, streamId, queryParams);
    }
}
