package com.bitmovin.api.encoding.inputs.s3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.s3.customdata.CustomdataApi;

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
    * Create S3 Input
    * 
    * @param s3Input The S3 input to be created (optional)
    * @return S3Input
    * @throws BitmovinException if fails to make API call
    */
    public S3Input create(S3Input s3Input) throws BitmovinException
    {
        return this.apiClient.create(s3Input);
    }

    /**
    * Delete S3 Input
    * 
    * @param inputId Id of the input (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * S3 Input Details
    * 
    * @param inputId Id of the input (required)
    * @return S3Input
    * @throws BitmovinException if fails to make API call
    */
    public S3Input get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List S3 Inputs
    * 
    * @return List&lt;S3Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3Input> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List S3 Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;S3Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3Input> list(S3InputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
