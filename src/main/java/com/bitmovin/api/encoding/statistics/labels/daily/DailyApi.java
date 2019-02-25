package com.bitmovin.api.encoding.statistics.labels.daily;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyApi
{
    private final DailyClient apiClient;

    public DailyApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DailyApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DailyApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DailyClient.class);

    }

    /**
    * Get Daily Statistics per Label
    * 
    * @return List&lt;DailyStatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DailyStatisticsPerLabel> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * Get Daily Statistics per Label
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DailyStatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DailyStatisticsPerLabel> list(DailyStatisticsPerLabelsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * Get daily statistics per label within specific dates
    * 
    * @param from Start date. Format: yyyy-MM-dd (required)
    * @param to End date. Format: yyyy-MM-dd (required)
    * @return List&lt;DailyStatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DailyStatisticsPerLabel> listByDateRange(String from, String to) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, new HashMap<String, Object>());
    }

    /**
    * Get daily statistics per label within specific dates
    * 
    * @param from Start date. Format: yyyy-MM-dd (required)
    * @param to End date. Format: yyyy-MM-dd (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DailyStatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DailyStatisticsPerLabel> listByDateRange(String from, String to, DailyStatisticsPerLabelsListByDateRangeQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, queryParams);
    }
}
