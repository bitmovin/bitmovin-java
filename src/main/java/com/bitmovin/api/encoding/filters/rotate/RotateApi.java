package com.bitmovin.api.encoding.filters.rotate;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.rotate.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotateApi
{
    private final RotateClient apiClient;
    public CustomdataApi customdata;

    public RotateApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RotateApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RotateApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(RotateClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Rotate Filter
    * 
    * @param rotateFilter  (optional)
    * @return RotateFilter
    * @throws BitmovinException if fails to make API call
    */
    public RotateFilter create(RotateFilter rotateFilter) throws BitmovinException
    {
        return this.apiClient.create(rotateFilter);
    }

    /**
    * Delete Rotate Filter
    * 
    * @param filterId Id of the Rotate configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Rotate Filter Details
    * 
    * @param filterId Id of the Rotate configuration. (required)
    * @return RotateFilter
    * @throws BitmovinException if fails to make API call
    */
    public RotateFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Rotate Filters
    * 
    * @return List&lt;RotateFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RotateFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Rotate Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;RotateFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<RotateFilter> list(RotateFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
