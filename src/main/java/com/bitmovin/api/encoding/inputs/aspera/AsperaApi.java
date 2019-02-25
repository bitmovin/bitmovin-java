package com.bitmovin.api.encoding.inputs.aspera;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.aspera.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsperaApi
{
    private final AsperaClient apiClient;
    public CustomdataApi customdata;

    public AsperaApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AsperaApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AsperaApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AsperaClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Aspera Input
    * 
    * @param asperaInput The Aspera input to be created (optional)
    * @return AsperaInput
    * @throws BitmovinException if fails to make API call
    */
    public AsperaInput create(AsperaInput asperaInput) throws BitmovinException
    {
        return this.apiClient.create(asperaInput);
    }

    /**
    * Delete Aspera Input
    * 
    * @param inputId Id of the input (required)
    * @return AsperaInput
    * @throws BitmovinException if fails to make API call
    */
    public AsperaInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Aspera Input Details
    * 
    * @param inputId Id of the input (required)
    * @return AsperaInput
    * @throws BitmovinException if fails to make API call
    */
    public AsperaInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Aspera Inputs
    * 
    * @return List&lt;AsperaInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AsperaInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Aspera Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AsperaInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AsperaInput> list(AsperaInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
