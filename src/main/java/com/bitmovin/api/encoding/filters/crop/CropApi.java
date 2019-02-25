package com.bitmovin.api.encoding.filters.crop;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.crop.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CropApi
{
    private final CropClient apiClient;
    public CustomdataApi customdata;

    public CropApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CropApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CropApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CropClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Crop Filter
    * 
    * @param cropFilter  (optional)
    * @return CropFilter
    * @throws BitmovinException if fails to make API call
    */
    public CropFilter create(CropFilter cropFilter) throws BitmovinException
    {
        return this.apiClient.create(cropFilter);
    }

    /**
    * Delete Crop Filter
    * 
    * @param filterId Id of the Crop configuration. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Crop Filter Details
    * 
    * @param filterId Id of the Crop configuration. (required)
    * @return CropFilter
    * @throws BitmovinException if fails to make API call
    */
    public CropFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Crop Filters
    * 
    * @return List&lt;CropFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CropFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Crop Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;CropFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<CropFilter> list(CropFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
