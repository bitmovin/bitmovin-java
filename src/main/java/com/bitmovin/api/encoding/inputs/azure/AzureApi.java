package com.bitmovin.api.encoding.inputs.azure;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.azure.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AzureApi
{
    private final AzureClient apiClient;
    public CustomdataApi customdata;

    public AzureApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AzureApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AzureApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AzureClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Azure Input
    * 
    * @param azureInput The Azure input to be created (optional)
    * @return AzureInput
    * @throws BitmovinException if fails to make API call
    */
    public AzureInput create(AzureInput azureInput) throws BitmovinException
    {
        return this.apiClient.create(azureInput);
    }

    /**
    * Delete Azure Input
    * 
    * @param inputId Id of the input (required)
    * @return AzureInput
    * @throws BitmovinException if fails to make API call
    */
    public AzureInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Azure Input Details
    * 
    * @param inputId Id of the input (required)
    * @return AzureInput
    * @throws BitmovinException if fails to make API call
    */
    public AzureInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Azure Inputs
    * 
    * @return List&lt;AzureInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AzureInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Azure Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AzureInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AzureInput> list(AzureInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
