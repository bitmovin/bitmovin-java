package com.bitmovin.api.encoding.statistics.encodings.liveStatistics;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.statistics.encodings.liveStatistics.events.EventsApi;
import com.bitmovin.api.encoding.statistics.encodings.liveStatistics.streams.StreamsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveStatisticsApi
{
    private final LiveStatisticsClient apiClient;
    public EventsApi events;
    public StreamsApi streams;

    public LiveStatisticsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LiveStatisticsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LiveStatisticsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LiveStatisticsClient.class);

        events = new EventsApi(clientFactory);
        streams = new StreamsApi(clientFactory);
    }


    /**
    * List Live Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @return LiveEncodingStats
    * @throws BitmovinException if fails to make API call
    */
    public LiveEncodingStats get(String encodingId) throws BitmovinException
    {
        return this.apiClient.get(encodingId);
    }
}
