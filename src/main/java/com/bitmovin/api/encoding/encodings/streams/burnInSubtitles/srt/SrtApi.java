package com.bitmovin.api.encoding.encodings.streams.burnInSubtitles.srt;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SrtApi
{
    private final SrtClient apiClient;

    public SrtApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SrtApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SrtApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SrtClient.class);

    }


    /**
    * Burn-In SRT Subtitle into Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param burnInSubtitleSrt  (optional)
    * @return BurnInSubtitleSrt
    * @throws BitmovinException if fails to make API call
    */
    public BurnInSubtitleSrt create(String encodingId, String streamId, BurnInSubtitleSrt burnInSubtitleSrt) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, burnInSubtitleSrt);
    }

    /**
    * Delete Burn-In SRT Subtitle from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param subtitleId Id of the burn-in subtitle. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, subtitleId);
    }

    /**
    * Get Burn-In SRT Subtitle Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param subtitleId Id of the burn-in subtitle. (required)
    * @return BurnInSubtitleSrt
    * @throws BitmovinException if fails to make API call
    */
    public BurnInSubtitleSrt get(String encodingId, String streamId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId, subtitleId);
    }
    /**
    * List the Burn-In SRT subtitles of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;BurnInSubtitleSrt&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<BurnInSubtitleSrt> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List the Burn-In SRT subtitles of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;BurnInSubtitleSrt&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<BurnInSubtitleSrt> list(String encodingId, String streamId, BurnInSubtitleSrtsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
