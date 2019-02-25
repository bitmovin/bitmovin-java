package com.bitmovin.api.encoding.filters.interlace;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.interlace.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterlaceApi
{
    private final InterlaceClient apiClient;
    public CustomdataApi customdata;

    public InterlaceApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InterlaceApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InterlaceApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(InterlaceClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Interlace Filter
    * 
    * @param interlaceFilter  (optional)
    * @return InterlaceFilter
    * @throws BitmovinException if fails to make API call
    */
    public InterlaceFilter create(InterlaceFilter interlaceFilter) throws BitmovinException
    {
        return this.apiClient.create(interlaceFilter);
    }

    /**
    * Delete Interlace Filter
    * 
    * @param filterId Id of the Interlace Filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Interlace Filter Details
    * 
    * @param filterId Id of the Interlace Filter (required)
    * @return InterlaceFilter
    * @throws BitmovinException if fails to make API call
    */
    public InterlaceFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Interlace Filters
    * 
    * @return List&lt;InterlaceFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<InterlaceFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Interlace Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;InterlaceFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<InterlaceFilter> list(InterlaceFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
