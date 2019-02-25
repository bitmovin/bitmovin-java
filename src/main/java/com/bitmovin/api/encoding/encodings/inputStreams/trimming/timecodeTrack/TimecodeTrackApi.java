package com.bitmovin.api.encoding.encodings.inputStreams.trimming.timecodeTrack;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimecodeTrackApi
{
    private final TimecodeTrackClient apiClient;

    public TimecodeTrackApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TimecodeTrackApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TimecodeTrackApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TimecodeTrackClient.class);

    }


    /**
    * Add Timecode Track Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param timecodeTrackTrimmingInputStream  (optional)
    * @return TimecodeTrackTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public TimecodeTrackTrimmingInputStream create(String encodingId, TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, timecodeTrackTrimmingInputStream);
    }

    /**
    * Delete Timecode Track Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the Timecode Track Trimming Input Stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, inputStreamId);
    }

    /**
    * Timecode Track Trimming Input Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the Timecode Track Trimming Input Stream. (required)
    * @return TimecodeTrackTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public TimecodeTrackTrimmingInputStream get(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, inputStreamId);
    }
    /**
    * List Timecode Track Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;TimecodeTrackTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TimecodeTrackTrimmingInputStream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Timecode Track Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TimecodeTrackTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TimecodeTrackTrimmingInputStream> list(String encodingId, TimecodeTrackTrimmingInputStreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
