package com.bitmovin.api.encoding.outputs.azure;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.azure.customdata.CustomdataApi;

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
    * Create Azure Output
    * 
    * @param azureOutput The Azure output to be created (optional)
    * @return AzureOutput
    * @throws BitmovinException if fails to make API call
    */
    public AzureOutput create(AzureOutput azureOutput) throws BitmovinException
    {
        return this.apiClient.create(azureOutput);
    }

    /**
    * Delete Azure Output
    * 
    * @param outputId Id of the output (required)
    * @return AzureOutput
    * @throws BitmovinException if fails to make API call
    */
    public AzureOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * Azure Output Details
    * 
    * @param outputId Id of the output (required)
    * @return AzureOutput
    * @throws BitmovinException if fails to make API call
    */
    public AzureOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List Azure Outputs
    * 
    * @return List&lt;AzureOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AzureOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Azure Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AzureOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AzureOutput> list(AzureOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
