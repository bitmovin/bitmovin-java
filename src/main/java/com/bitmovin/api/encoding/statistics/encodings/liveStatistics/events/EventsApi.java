package com.bitmovin.api.encoding.statistics.encodings.liveStatistics.events;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsApi
{
    private final EventsClient apiClient;

    public EventsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EventsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EventsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(EventsClient.class);

    }

    /**
    * List Events of Live Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;LiveEncodingStatsEvent&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LiveEncodingStatsEvent> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Events of Live Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;LiveEncodingStatsEvent&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LiveEncodingStatsEvent> list(String encodingId, LiveEncodingStatsEventsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
