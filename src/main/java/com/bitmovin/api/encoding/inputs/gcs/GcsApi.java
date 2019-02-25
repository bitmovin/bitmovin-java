package com.bitmovin.api.encoding.inputs.gcs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.gcs.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GcsApi
{
    private final GcsClient apiClient;
    public CustomdataApi customdata;

    public GcsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public GcsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public GcsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(GcsClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create GCS Input
    * 
    * @param gcsInput The GcsInput to be created (optional)
    * @return GcsInput
    * @throws BitmovinException if fails to make API call
    */
    public GcsInput create(GcsInput gcsInput) throws BitmovinException
    {
        return this.apiClient.create(gcsInput);
    }

    /**
    * Delete GCS Input
    * 
    * @param inputId Id of the input (required)
    * @return GcsInput
    * @throws BitmovinException if fails to make API call
    */
    public GcsInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * GCS Input Details
    * 
    * @param inputId Id of the input (required)
    * @return GcsInput
    * @throws BitmovinException if fails to make API call
    */
    public GcsInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List GCS Inputs
    * 
    * @return List&lt;GcsInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GcsInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List GCS Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;GcsInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GcsInput> list(GcsInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
