package com.bitmovin.api.encoding.infrastructure.aws;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.infrastructure.aws.regions.RegionsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AwsApi
{
    private final AwsClient apiClient;
    public RegionsApi regions;

    public AwsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AwsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AwsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AwsClient.class);

        regions = new RegionsApi(clientFactory);
    }


    /**
    * Add AWS Account
    * 
    * @param awsAccount  (optional)
    * @return AwsAccount
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccount create(AwsAccount awsAccount) throws BitmovinException
    {
        return this.apiClient.create(awsAccount);
    }

    /**
    * Delete AWS Account
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @return AwsAccount
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccount delete(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.delete(infrastructureId);
    }

    /**
    * AWS Account Details
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @return AwsAccount
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccount get(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId);
    }
    /**
    * List AWS Accounts
    * 
    * @return List&lt;AwsAccount&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AwsAccount> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List AWS Accounts
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AwsAccount&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AwsAccount> list(AwsAccountsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
