package com.bitmovin.api.encoding.inputs.s3RoleBased;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.s3RoleBased.customdata.CustomdataApi;

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
    * Create S3 Role-based Input
    * 
    * @param s3RoleBasedInput The S3 Role-based input to be created (optional)
    * @return S3RoleBasedInput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedInput create(S3RoleBasedInput s3RoleBasedInput) throws BitmovinException
    {
        return this.apiClient.create(s3RoleBasedInput);
    }

    /**
    * Delete S3 Role-based Input
    * 
    * @param inputId Id of the input (required)
    * @return S3RoleBasedInput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * S3 Role-based Input Details
    * 
    * @param inputId Id of the input (required)
    * @return S3RoleBasedInput
    * @throws BitmovinException if fails to make API call
    */
    public S3RoleBasedInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List S3 Role-based Inputs
    * 
    * @return List&lt;S3RoleBasedInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3RoleBasedInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List S3 Role-based Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;S3RoleBasedInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<S3RoleBasedInput> list(S3RoleBasedInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
