package com.bitmovin.api.encoding.inputs.local;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.local.customdata.CustomdataApi;

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
    * Create Local Input
    * 
    * @param localInput The LocalInput to be created. (optional)
    * @return LocalInput
    * @throws BitmovinException if fails to make API call
    */
    public LocalInput create(LocalInput localInput) throws BitmovinException
    {
        return this.apiClient.create(localInput);
    }

    /**
    * Delete Local Input
    * 
    * @param inputId Id of the input (required)
    * @return LocalInput
    * @throws BitmovinException if fails to make API call
    */
    public LocalInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Local Input Details
    * 
    * @param inputId Id of the input (required)
    * @return LocalInput
    * @throws BitmovinException if fails to make API call
    */
    public LocalInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Local Inputs
    * 
    * @return List&lt;LocalInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LocalInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Local Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;LocalInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<LocalInput> list(LocalInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
