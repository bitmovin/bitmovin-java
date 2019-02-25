package com.bitmovin.api.encoding.outputs.akamaiNetstorage;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.akamaiNetstorage.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AkamaiNetstorageApi
{
    private final AkamaiNetstorageClient apiClient;
    public CustomdataApi customdata;

    public AkamaiNetstorageApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AkamaiNetstorageApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AkamaiNetstorageApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AkamaiNetstorageClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Akamai NetStorage Output
    * 
    * @param akamaiNetStorageOutput The Akamai NetStorage output to be created (optional)
    * @return AkamaiNetStorageOutput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageOutput create(AkamaiNetStorageOutput akamaiNetStorageOutput) throws BitmovinException
    {
        return this.apiClient.create(akamaiNetStorageOutput);
    }

    /**
    * Delete Akamai NetStorage Output
    * 
    * @param outputId Id of the output (required)
    * @return AkamaiNetStorageOutput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * Akamai NetStorage Output Details
    * 
    * @param outputId Id of the output (required)
    * @return AkamaiNetStorageOutput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List Akamai NetStorage Outputs
    * 
    * @return List&lt;AkamaiNetStorageOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AkamaiNetStorageOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Akamai NetStorage Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AkamaiNetStorageOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AkamaiNetStorageOutput> list(AkamaiNetStorageOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
