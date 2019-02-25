package com.bitmovin.api.encoding.outputs.genericS3;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.genericS3.customdata.CustomdataApi;

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
    * Create Generic S3 Output
    * 
    * @param genericS3Output  (optional)
    * @return GenericS3Output
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Output create(GenericS3Output genericS3Output) throws BitmovinException
    {
        return this.apiClient.create(genericS3Output);
    }

    /**
    * Delete Generic S3 Output
    * 
    * @param outputId Id of the output (required)
    * @return GenericS3Output
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Output delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * Generic S3 Output Details
    * 
    * @param outputId Id of the output (required)
    * @return GenericS3Output
    * @throws BitmovinException if fails to make API call
    */
    public GenericS3Output get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List Generic S3 Outputs
    * 
    * @return List&lt;GenericS3Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GenericS3Output> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Generic S3 Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;GenericS3Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<GenericS3Output> list(GenericS3OutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
