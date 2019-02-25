package com.bitmovin.api.encoding.filters.deinterlace;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.deinterlace.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeinterlaceApi
{
    private final DeinterlaceClient apiClient;
    public CustomdataApi customdata;

    public DeinterlaceApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DeinterlaceApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DeinterlaceApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DeinterlaceClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Deinterlace Filter
    * 
    * @param deinterlaceFilter  (optional)
    * @return DeinterlaceFilter
    * @throws BitmovinException if fails to make API call
    */
    public DeinterlaceFilter create(DeinterlaceFilter deinterlaceFilter) throws BitmovinException
    {
        return this.apiClient.create(deinterlaceFilter);
    }

    /**
    * Delete Deinterlace Filter
    * 
    * @param filterId Id of the deinterlace filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Deinterlace Filter Details
    * 
    * @param filterId Id of the deinterlace filter (required)
    * @return DeinterlaceFilter
    * @throws BitmovinException if fails to make API call
    */
    public DeinterlaceFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Deinterlace Filters
    * 
    * @return List&lt;DeinterlaceFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DeinterlaceFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Deinterlace Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DeinterlaceFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DeinterlaceFilter> list(DeinterlaceFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
