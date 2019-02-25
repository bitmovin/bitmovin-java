package com.bitmovin.api.encoding.outputs.s3RoleBased;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.s3RoleBased.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S3RoleBasedApi
{
    private final S3RoleBasedClient apiClient;
    public CustomdataApi customdata;

    public S3RoleBasedApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public S3RoleBasedApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public S3RoleBasedApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(S3RoleBasedClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create S3 Role-based Output
    * 
    * @param s3RoleBasedOutput The S3 Role-based output to be created (optional)
    * @return S3RoleBasedOutput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedOutput create(S3RoleBasedOutput s3RoleBasedOutput) throws BitmovinException
    {
        return this.apiClient.create(s3RoleBasedOutput);
    }

    /**
    * Delete S3 Role-based Output
    * 
    * @param outputId Id of the output (required)
    * @return S3RoleBasedOutput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * S3 Role-based Output Details
    * 
    * @param outputId Id of the input (required)
    * @return S3RoleBasedOutput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List S3 Role-based Outputs
    * 
    * @return List&lt;S3RoleBasedOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3RoleBasedOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List S3 Role-based Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;S3RoleBasedOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3RoleBasedOutput> list(S3RoleBasedOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
