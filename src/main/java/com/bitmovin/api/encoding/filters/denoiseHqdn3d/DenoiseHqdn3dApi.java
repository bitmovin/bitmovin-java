package com.bitmovin.api.encoding.filters.denoiseHqdn3d;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.denoiseHqdn3d.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DenoiseHqdn3dApi
{
    private final DenoiseHqdn3dClient apiClient;
    public CustomdataApi customdata;

    public DenoiseHqdn3dApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public DenoiseHqdn3dApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public DenoiseHqdn3dApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(DenoiseHqdn3dClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Denoise hqdn3d Filter
    * 
    * @param denoiseHqdn3dFilter TODO Add Description (optional)
    * @return DenoiseHqdn3dFilter
    * @throws BitmovinException if fails to make API call
    */
    public DenoiseHqdn3dFilter create(DenoiseHqdn3dFilter denoiseHqdn3dFilter) throws BitmovinException
    {
        return this.apiClient.create(denoiseHqdn3dFilter);
    }

    /**
    * Delete Denoise hqdn3d Filter
    * 
    * @param filterId Id of the denoise hqdn3d filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Denoise hqdn3d Filter Details
    * 
    * @param filterId Id of the denoise hqdn3d filter (required)
    * @return DenoiseHqdn3dFilter
    * @throws BitmovinException if fails to make API call
    */
    public DenoiseHqdn3dFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Denoise hqdn3d Filters
    * 
    * @return List&lt;DenoiseHqdn3dFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DenoiseHqdn3dFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Denoise hqdn3d Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;DenoiseHqdn3dFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<DenoiseHqdn3dFilter> list(DenoiseHqdn3dFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
