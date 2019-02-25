package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.live.LiveApi;
import com.bitmovin.api.encoding.encodings.customdata.CustomdataApi;
import com.bitmovin.api.encoding.encodings.streams.StreamsApi;
import com.bitmovin.api.encoding.encodings.inputStreams.InputStreamsApi;
import com.bitmovin.api.encoding.encodings.muxings.MuxingsApi;
import com.bitmovin.api.encoding.encodings.subtitles.SubtitlesApi;
import com.bitmovin.api.encoding.encodings.captions.CaptionsApi;
import com.bitmovin.api.encoding.encodings.sidecars.SidecarsApi;
import com.bitmovin.api.encoding.encodings.keyframes.KeyframesApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingsApi
{
    private final EncodingsClient apiClient;
    public LiveApi live;
    public CustomdataApi customdata;
    public StreamsApi streams;
    public InputStreamsApi inputStreams;
    public MuxingsApi muxings;
    public SubtitlesApi subtitles;
    public CaptionsApi captions;
    public SidecarsApi sidecars;
    public KeyframesApi keyframes;

    public EncodingsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EncodingsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EncodingsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(EncodingsClient.class);

        live = new LiveApi(clientFactory);
        customdata = new CustomdataApi(clientFactory);
        streams = new StreamsApi(clientFactory);
        inputStreams = new InputStreamsApi(clientFactory);
        muxings = new MuxingsApi(clientFactory);
        subtitles = new SubtitlesApi(clientFactory);
        captions = new CaptionsApi(clientFactory);
        sidecars = new SidecarsApi(clientFactory);
        keyframes = new KeyframesApi(clientFactory);
    }


    /**
    * Create Encoding
    * 
    * @param encoding The Encoding to be created (optional)
    * @return Encoding
    * @throws BitmovinException if fails to make API call
    */
    public Encoding create(Encoding encoding) throws BitmovinException
    {
        return this.apiClient.create(encoding);
    }

    /**
    * Delete Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId);
    }

    /**
    * Encoding Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @return Encoding
    * @throws BitmovinException if fails to make API call
    */
    public Encoding get(String encodingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId);
    }

    /**
    * Encoding Start Details
    * 
    * @param encodingId Id of the encoding (required)
    * @return StartEncodingRequest
    * @throws BitmovinException if fails to make API call
    */
    public StartEncodingRequest getStartRequest(String encodingId) throws BitmovinException
    {
        return this.apiClient.getStartRequest(encodingId);
    }
    /**
    * List all Encodings
    * 
    * @return List&lt;Encoding&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Encoding> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Encodings
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Encoding&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Encoding> list(EncodingsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }

    /**
    * Reprioritize Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @param reprioritizeEncodingRequest  (optional)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse reprioritize(String encodingId, ReprioritizeEncodingRequest reprioritizeEncodingRequest) throws BitmovinException
    {
        return this.apiClient.reprioritize(encodingId, reprioritizeEncodingRequest);
    }

    /**
    * Reschedule Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @param rescheduleEncodingRequest  (optional)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse reschedule(String encodingId, RescheduleEncodingRequest rescheduleEncodingRequest) throws BitmovinException
    {
        return this.apiClient.reschedule(encodingId, rescheduleEncodingRequest);
    }

    /**
    * Start Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @param startEncodingRequest  (optional)
    * @return StartEncodingRequest
    * @throws BitmovinException if fails to make API call
    */
    public StartEncodingRequest start(String encodingId, StartEncodingRequest startEncodingRequest) throws BitmovinException
    {
        return this.apiClient.start(encodingId, startEncodingRequest);
    }

    /**
    * Encoding Status
    * 
    * @param encodingId Id of the encoding (required)
    * @return Task
    * @throws BitmovinException if fails to make API call
    */
    public Task status(String encodingId) throws BitmovinException
    {
        return this.apiClient.status(encodingId);
    }

    /**
    * Stop Encoding
    * 
    * @param encodingId Id of the encoding (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse stop(String encodingId) throws BitmovinException
    {
        return this.apiClient.stop(encodingId);
    }
}
