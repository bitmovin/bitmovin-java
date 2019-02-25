package com.bitmovin.api.encoding.statistics;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.statistics.daily.DailyApi;
import com.bitmovin.api.encoding.statistics.encodings.EncodingsApi;
import com.bitmovin.api.encoding.statistics.labels.LabelsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsApi
{
    private final StatisticsClient apiClient;
    public DailyApi daily;
    public EncodingsApi encodings;
    public LabelsApi labels;

    public StatisticsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StatisticsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StatisticsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StatisticsClient.class);

        daily = new DailyApi(clientFactory);
        encodings = new EncodingsApi(clientFactory);
        labels = new LabelsApi(clientFactory);
    }


    /**
    * Show Overall Statistics
    * 
    * @return Statistics
    * @throws BitmovinException if fails to make API call
    */
    public Statistics get() throws BitmovinException
    {
        return this.apiClient.get();
    }
    /**
    * Show Overall Statistics Within Specific Dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @return List&lt;Statistics&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Statistics> list(String from, String to) throws BitmovinException
    {
        return this.apiClient.list(from, to, new HashMap<String, Object>());
    }

    /**
    * Show Overall Statistics Within Specific Dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Statistics&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Statistics> list(String from, String to, StatisticssListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(from, to, queryParams);
    }
}
