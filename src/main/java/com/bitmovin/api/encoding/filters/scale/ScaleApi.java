package com.bitmovin.api.encoding.filters.scale;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.scale.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScaleApi
{
    private final ScaleClient apiClient;
    public CustomdataApi customdata;

    public ScaleApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ScaleApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ScaleApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ScaleClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Scale Filter
    * 
    * @param scaleFilter  (optional)
    * @return ScaleFilter
    * @throws BitmovinException if fails to make API call
    */
    public ScaleFilter create(ScaleFilter scaleFilter) throws BitmovinException
    {
        return this.apiClient.create(scaleFilter);
    }

    /**
    * Delete Scale Filter
    * 
    * @param filterId Id of the scale filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Scale Filter Details
    * 
    * @param filterId Id of the scale filter (required)
    * @return ScaleFilter
    * @throws BitmovinException if fails to make API call
    */
    public ScaleFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Scale Filters
    * 
    * @return List&lt;ScaleFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ScaleFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Scale Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;ScaleFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<ScaleFilter> list(ScaleFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
