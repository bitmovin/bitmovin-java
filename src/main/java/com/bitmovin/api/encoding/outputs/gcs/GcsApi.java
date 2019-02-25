package com.bitmovin.api.encoding.outputs.gcs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.gcs.customdata.CustomdataApi;

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
    * Create GCS Output
    * 
    * @param gcsOutput The GCS output to be created (optional)
    * @return GcsOutput
    * @throws BitmovinException if fails to make API call
    */
    public GcsOutput create(GcsOutput gcsOutput) throws BitmovinException
    {
        return this.apiClient.create(gcsOutput);
    }

    /**
    * Delete GCS Output
    * 
    * @param outputId Id of the output (required)
    * @return GcsOutput
    * @throws BitmovinException if fails to make API call
    */
    public GcsOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * GCS Output Details
    * 
    * @param outputId Id of the output (required)
    * @return GcsOutput
    * @throws BitmovinException if fails to make API call
    */
    public GcsOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List GCS Outputs
    * 
    * @return List&lt;GcsOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GcsOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List GCS Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;GcsOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GcsOutput> list(GcsOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
