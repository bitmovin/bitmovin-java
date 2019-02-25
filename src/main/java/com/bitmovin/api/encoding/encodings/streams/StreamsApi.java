package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.streams.input.InputApi;
import com.bitmovin.api.encoding.encodings.streams.inputs.InputsApi;
import com.bitmovin.api.encoding.encodings.streams.filters.FiltersApi;
import com.bitmovin.api.encoding.encodings.streams.subtitles.SubtitlesApi;
import com.bitmovin.api.encoding.encodings.streams.burnInSubtitles.BurnInSubtitlesApi;
import com.bitmovin.api.encoding.encodings.streams.captions.CaptionsApi;
import com.bitmovin.api.encoding.encodings.streams.thumbnails.ThumbnailsApi;
import com.bitmovin.api.encoding.encodings.streams.sprites.SpritesApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamsApi
{
    private final StreamsClient apiClient;
    public CustomdataApi customdata;
    public InputApi input;
    public InputsApi inputs;
    public FiltersApi filters;
    public SubtitlesApi subtitles;
    public BurnInSubtitlesApi burnInSubtitles;
    public CaptionsApi captions;
    public ThumbnailsApi thumbnails;
    public SpritesApi sprites;

    public StreamsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StreamsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StreamsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StreamsClient.class);

        customdata = new CustomdataApi(clientFactory);
        input = new InputApi(clientFactory);
        inputs = new InputsApi(clientFactory);
        filters = new FiltersApi(clientFactory);
        subtitles = new SubtitlesApi(clientFactory);
        burnInSubtitles = new BurnInSubtitlesApi(clientFactory);
        captions = new CaptionsApi(clientFactory);
        thumbnails = new ThumbnailsApi(clientFactory);
        sprites = new SpritesApi(clientFactory);
    }


    /**
    * Add Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param stream  (optional)
    * @return Stream
    * @throws BitmovinException if fails to make API call
    */
    public Stream create(String encodingId, Stream stream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, stream);
    }

    /**
    * Delete Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, streamId);
    }

    /**
    * Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param streamId Id of the stream. (required)
    * @return Stream
    * @throws BitmovinException if fails to make API call
    */
    public Stream get(String encodingId, String streamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, streamId);
    }
    /**
    * List Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;Stream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Stream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Stream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Stream> list(String encodingId, StreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
