package com.bitmovin.api.encoding.inputs.genericS3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.genericS3.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericS3Api
{
    private final GenericS3Client apiClient;
    public CustomdataApi customdata;

    public GenericS3Api(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public GenericS3Api(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public GenericS3Api(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(GenericS3Client.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create Generic S3 Input
    * 
    * @param genericS3Input The GenericS3 input to be created (optional)
    * @return GenericS3Input
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Input create(GenericS3Input genericS3Input) throws BitmovinException
    {
        return this.apiClient.create(genericS3Input);
    }

    /**
    * Delete Generic S3 Input
    * 
    * @param inputId Id of the input (required)
    * @return GenericS3Input
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Input delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * Generic S3 Input Details
    * 
    * @param inputId Id of the input (required)
    * @return GenericS3Input
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Input get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List Generic S3 Inputs
    * 
    * @return List&lt;GenericS3Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GenericS3Input> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Generic S3 Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;GenericS3Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GenericS3Input> list(GenericS3InputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
