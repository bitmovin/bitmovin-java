package com.bitmovin.api.encoding.filters.text;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.text.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextApi
{
    private final TextClient apiClient;
    public CustomdataApi customdata;

    public TextApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public TextApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public TextApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(TextClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Text Filter
    * 
    * @param textFilter  (optional)
    * @return TextFilter
    * @throws BitmovinException if fails to make API call
    */
    public TextFilter create(TextFilter textFilter) throws BitmovinException
    {
        return this.apiClient.create(textFilter);
    }

    /**
    * Delete Text Filter
    * 
    * @param filterId Id of the Text Filter (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String filterId) throws BitmovinException
    {
        return this.apiClient.delete(filterId);
    }

    /**
    * Text Filter Details
    * 
    * @param filterId Id of the Text Filter (required)
    * @return TextFilter
    * @throws BitmovinException if fails to make API call
    */
    public TextFilter get(String filterId) throws BitmovinException
    {
        return this.apiClient.get(filterId);
    }
    /**
    * List Text Filters
    * 
    * @return List&lt;TextFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TextFilter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Text Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;TextFilter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<TextFilter> list(TextFiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
