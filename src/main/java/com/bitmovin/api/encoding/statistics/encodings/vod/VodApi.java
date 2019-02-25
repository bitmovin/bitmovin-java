package com.bitmovin.api.encoding.statistics.encodings.vod;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VodApi
{
    private final VodClient apiClient;

    public VodApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public VodApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public VodApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(VodClient.class);

    }

    /**
    * List VOD Encoding Statistics
    * 
    * @return List&lt;EncodingStatisticsVod&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsVod> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List VOD Encoding Statistics
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EncodingStatisticsVod&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsVod> list(EncodingStatisticsVodsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * List VOD Encoding Statistics Within Specific Dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @return List&lt;EncodingStatisticsVod&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsVod> listByDateRange(String from, String to) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, new HashMap<String, Object>());
    }

    /**
    * List VOD Encoding Statistics Within Specific Dates
    * 
    * @param from Start date, format: yyyy-MM-dd (required)
    * @param to End date, format: yyyy-MM-dd (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EncodingStatisticsVod&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingStatisticsVod> listByDateRange(String from, String to, EncodingStatisticsVodsListByDateRangeQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByDateRange(from, to, queryParams);
    }
}
