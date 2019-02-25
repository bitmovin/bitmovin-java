package com.bitmovin.api.encoding.inputs.akamaiNetstorage;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.akamaiNetstorage.customdata.CustomdataApi;

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
    * Create Akamai NetStorage Input
    * 
    * @param akamaiNetStorageInput The Akamai NetStorage input to be created (optional)
    * @return AkamaiNetStorageInput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageInput create(AkamaiNetStorageInput akamaiNetStorageInput) throws BitmovinException
    {
        return this.apiClient.create(akamaiNetStorageInput);
    }

    /**
    * Delete Akamai NetStorage Input
    * 
    * @param inputId Id of the input (required)
    * @return AkamaiNetStorageInput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Akamai NetStorage Input Details
    * 
    * @param inputId Id of the input (required)
    * @return AkamaiNetStorageInput
    * @throws BitmovinException if fails to make API call
    */
    public AkamaiNetStorageInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Akamai NetStorage Inputs
    * 
    * @return List&lt;AkamaiNetStorageInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AkamaiNetStorageInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Akamai NetStorage Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AkamaiNetStorageInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AkamaiNetStorageInput> list(AkamaiNetStorageInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
