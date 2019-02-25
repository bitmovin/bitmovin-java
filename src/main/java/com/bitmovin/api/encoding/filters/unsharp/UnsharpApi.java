package com.bitmovin.api.encoding.filters.unsharp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.unsharp.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsharpApi
{
    private final UnsharpClient apiClient;
    public CustomdataApi customdata;

    public UnsharpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public UnsharpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public UnsharpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(UnsharpClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Unsharp Filter
    * 
    * @param unsharpFilter  (optional)
    * @return UnsharpFilter
    * @throws BitmovinException if fails to make API call
    */
    public UnsharpFilter create(UnsharpFilter unsharpFilter) throws BitmovinException
    {
        return this.apiClient.create(unsharpFilter);
    }

    /**
    * Delete Unsharp Filter
    * 
    * @param filterId Id of the unsharp filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Unsharp Filter Details
    * 
    * @param filterId Id of the unsharp filter (required)
    * @return UnsharpFilter
    * @throws BitmovinException if fails to make API call
    */
    public UnsharpFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Unsharp Filters
    * 
    * @return List&lt;UnsharpFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UnsharpFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Unsharp Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;UnsharpFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<UnsharpFilter> list(UnsharpFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
