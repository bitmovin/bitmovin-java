package com.bitmovin.api.encoding.statistics.encodings.liveStatistics.streams;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamsApi
{
    private final StreamsClient apiClient;

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

    }

    /**
    * List Stream Infos of Live Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @return List&lt;StreamInfos&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamInfos> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Stream Infos of Live Statistics from an Encoding
    * 
    * @param encodingId Id of the encoding. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;StreamInfos&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StreamInfos> list(String encodingId, StreamInfossListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
