package com.bitmovin.api.encoding.statistics.labels;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.statistics.labels.daily.DailyApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelsApi
{
    private final LabelsClient apiClient;
    public DailyApi daily;

    public LabelsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LabelsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LabelsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LabelsClient.class);

        daily = new DailyApi(clientFactory);
    }

    /**
    * Get Statistics per Label
    * 
    * @return List&lt;StatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StatisticsPerLabel> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * Get Statistics per Label
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;StatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StatisticsPerLabel> list(StatisticsPerLabelsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * Get statistics per label within specific dates
    * 
    * @param from Start date. Format: yyyy-MM-dd (required)
    * @param to End date. Format: yyyy-MM-dd (required)
    * @return List&lt;StatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StatisticsPerLabel> listByDateRange(String from, String to) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, new HashMap<String, Object>());
    }

    /**
    * Get statistics per label within specific dates
    * 
    * @param from Start date. Format: yyyy-MM-dd (required)
    * @param to End date. Format: yyyy-MM-dd (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;StatisticsPerLabel&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<StatisticsPerLabel> listByDateRange(String from, String to, StatisticsPerLabelsListByDateRangeQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, queryParams);
    }
}
