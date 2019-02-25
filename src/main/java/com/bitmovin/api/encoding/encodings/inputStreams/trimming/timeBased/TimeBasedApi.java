package com.bitmovin.api.encoding.encodings.inputStreams.trimming.timeBased;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedApi
{
    private final TimeBasedClient apiClient;

    public TimeBasedApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TimeBasedApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TimeBasedApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TimeBasedClient.class);

    }


    /**
    * Add Time-Based Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param timeBasedTrimmingInputStream  (optional)
    * @return TimeBasedTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public TimeBasedTrimmingInputStream create(String encodingId, TimeBasedTrimmingInputStream timeBasedTrimmingInputStream) throws BitmovinException
    {
        return this.apiClient.create(encodingId, timeBasedTrimmingInputStream);
    }

    /**
    * Delete Time-Based Trimming Input Stream
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the Time-Based Trimming Input Stream. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.delete(encodingId, inputStreamId);
    }

    /**
    * Time-Based Trimming Input Stream Details
    * 
    * @param encodingId Id of the encoding. (required)
    * @param inputStreamId Id of the Time-Based Trimming Input Stream. (required)
    * @return TimeBasedTrimmingInputStream
    * @throws BitmovinException if fails to make API call
    */
    public TimeBasedTrimmingInputStream get(String encodingId, String inputStreamId) throws BitmovinException
    {
        return this.apiClient.get(encodingId, inputStreamId);
    }
    /**
    * List Time-Based Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;TimeBasedTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TimeBasedTrimmingInputStream> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Time-Based Trimming Input Streams
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TimeBasedTrimmingInputStream&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TimeBasedTrimmingInputStream> list(String encodingId, TimeBasedTrimmingInputStreamsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
