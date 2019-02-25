package com.bitmovin.api.encoding.encodings.streams.subtitles.dvbsub;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.subtitles.dvbsub.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvbsubApi
{
    private final DvbsubClient apiClient;
    public CustomdataApi customdata;

    public DvbsubApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DvbsubApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DvbsubApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DvbsubClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Burn-In DVB-SUB Subtitle into Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param streamDvbSubSubtitle  (optional)
    * @return StreamDvbSubSubtitle
    * @throws BitmovinException if fails to make API call
    */
    public StreamDvbSubSubtitle create(String encodingId, String streamId, StreamDvbSubSubtitle streamDvbSubSubtitle) throws BitmovinException
    {
        return this.apiClient.create(encodingId, streamId, streamDvbSubSubtitle);
    }

    /**
    * Delete Specific DVB-SUB Subtitle from Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param subtitleId TODO Add description (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId, subtitleId);
    }

    /**
    * Subtitle DVB-SUB BurnIn Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param subtitleId Id of the subtitle. (required)
    * @return StreamDvbSubSubtitle
    * @throws BitmovinException if fails to make API call
    */
    public StreamDvbSubSubtitle get(String encodingId, String streamId, String subtitleId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId, subtitleId);
    }
    /**
    * List the DVB-SUB subtitles of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return List&lt;StreamDvbSubSubtitle&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamDvbSubSubtitle> list(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, new HashMap<String, Object>());
    }

    /**
    * List the DVB-SUB subtitles of a stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;StreamDvbSubSubtitle&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamDvbSubSubtitle> list(String encodingId, String streamId, StreamDvbSubSubtitlesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, streamId, queryParams);
    }
}
