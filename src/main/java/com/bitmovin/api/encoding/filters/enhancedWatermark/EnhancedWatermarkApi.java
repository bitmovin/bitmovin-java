package com.bitmovin.api.encoding.filters.enhancedWatermark;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.enhancedWatermark.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnhancedWatermarkApi
{
    private final EnhancedWatermarkClient apiClient;
    public CustomdataApi customdata;

    public EnhancedWatermarkApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EnhancedWatermarkApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EnhancedWatermarkApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(EnhancedWatermarkClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Enhanced Watermark Filter
    * 
    * @param enhancedWatermarkFilter Only one horizontal and one vertical distance parameter is allowed, either top or bottom, and either left or right. See example body. (optional)
    * @return EnhancedWatermarkFilter
    * @throws BitmovinException if fails to make API call
    */
    public EnhancedWatermarkFilter create(EnhancedWatermarkFilter enhancedWatermarkFilter) throws BitmovinException
    {
        return this.apiClient.create(enhancedWatermarkFilter);
    }

    /**
    * Delete Enhanced Watermark Filter
    * 
    * @param filterId Id of the enhanced watermark configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Enhanced Watermark Filter Details
    * 
    * @param filterId Id of the enhanced watermark configuration. (required)
    * @return EnhancedWatermarkFilter
    * @throws BitmovinException if fails to make API call
    */
    public EnhancedWatermarkFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Enhanced Watermark Filters
    * 
    * @return List&lt;EnhancedWatermarkFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EnhancedWatermarkFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Enhanced Watermark Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EnhancedWatermarkFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EnhancedWatermarkFilter> list(EnhancedWatermarkFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
