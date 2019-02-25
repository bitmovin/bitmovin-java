package com.bitmovin.api.encoding.statistics.encodings.live;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveApi
{
    private final LiveClient apiClient;

    public LiveApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LiveApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LiveApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LiveClient.class);

    }

    /**
    * List Live Encoding Statistics
    * 
    * @return List&lt;EncodingStatisticsLive&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsLive> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Live Encoding Statistics
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EncodingStatisticsLive&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsLive> list(EncodingStatisticsLivesListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * List live encoding statistics within specific dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @return List&lt;EncodingStatisticsLive&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsLive> listByDateRange(String from, String to) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, new HashMap<String, Object>());
    }

    /**
    * List live encoding statistics within specific dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EncodingStatisticsLive&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsLive> listByDateRange(String from, String to, EncodingStatisticsLivesListByDateRangeQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, queryParams);
    }
}
