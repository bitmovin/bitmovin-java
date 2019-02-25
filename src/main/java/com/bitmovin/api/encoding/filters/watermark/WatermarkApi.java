package com.bitmovin.api.encoding.filters.watermark;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.watermark.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WatermarkApi
{
    private final WatermarkClient apiClient;
    public CustomdataApi customdata;

    public WatermarkApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WatermarkApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WatermarkApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(WatermarkClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Watermark Filter
    * 
    * @param watermarkFilter Only one horizontal and one vertical distance parameter is allowed, either top or bottom, and either left or right. See example body. (optional)
    * @return WatermarkFilter
    * @throws BitmovinException if fails to make API call
    */
    public WatermarkFilter create(WatermarkFilter watermarkFilter) throws BitmovinException
    {
        return this.apiClient.create(watermarkFilter);
    }

    /**
    * Delete Watermark Filter
    * 
    * @param filterId Id of the watermark configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Watermark Filter Details
    * 
    * @param filterId Id of the watermark configuration. (required)
    * @return WatermarkFilter
    * @throws BitmovinException if fails to make API call
    */
    public WatermarkFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Watermark Filters
    * 
    * @return List&lt;WatermarkFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WatermarkFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Watermark Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;WatermarkFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<WatermarkFilter> list(WatermarkFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
