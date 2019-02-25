package com.bitmovin.api.encoding.outputs.local;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.local.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalApi
{
    private final LocalClient apiClient;
    public CustomdataApi customdata;

    public LocalApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LocalApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LocalApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LocalClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Local Output
    * 
    * @param localOutput The Local output to be created (optional)
    * @return LocalOutput
    * @throws BitmovinException if fails to make API call
    */
    public LocalOutput create(LocalOutput localOutput) throws BitmovinException
    {
        return this.apiClient.create(localOutput);
    }

    /**
    * Delete Local Output
    * 
    * @param outputId Id of the output (required)
    * @return LocalOutput
    * @throws BitmovinException if fails to make API call
    */
    public LocalOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * Local Output Details
    * 
    * @param outputId Id of the output (required)
    * @return LocalOutput
    * @throws BitmovinException if fails to make API call
    */
    public LocalOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List Local Outputs
    * 
    * @return List&lt;LocalOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LocalOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Local Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;LocalOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LocalOutput> list(LocalOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
