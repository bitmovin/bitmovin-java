package com.bitmovin.api.encoding.outputs.s3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.s3.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S3Api
{
    private final S3Client apiClient;
    public CustomdataApi customdata;

    public S3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public S3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public S3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(S3Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create S3 Output
    * 
    * @param s3Output  (optional)
    * @return S3Output
    * @throws BitmovinException if fails to make API call
    */
    public S3Output create(S3Output s3Output) throws BitmovinException
    {
        return this.apiClient.create(s3Output);
    }

    /**
    * Delete S3 Output
    * 
    * @param outputId Id of the output (required)
    * @return S3Output
    * @throws BitmovinException if fails to make API call
    */
    public S3Output delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * S3 Output Details
    * 
    * @param outputId Id of the input (required)
    * @return S3Output
    * @throws BitmovinException if fails to make API call
    */
    public S3Output get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List S3 Outputs
    * 
    * @return List&lt;S3Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3Output> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List S3 Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;S3Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3Output> list(S3OutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
