package com.bitmovin.api.encoding.infrastructure.aws.regions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegionsApi
{
    private final RegionsClient apiClient;

    public RegionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RegionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RegionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(RegionsClient.class);

    }


    /**
    * Add AWS Region Setting
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @param region AWS region. (required)
    * @param awsAccountRegionSettings  (optional)
    * @return AwsAccountRegionSettings
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccountRegionSettings create(String infrastructureId, AwsCloudRegion region, AwsAccountRegionSettings awsAccountRegionSettings) throws BitmovinException
    {
        return this.apiClient.create(infrastructureId, region, awsAccountRegionSettings);
    }

    /**
    * Delete AWS Region Settings
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @param region AWS region. (required)
    * @return AwsAccountRegionSettings
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccountRegionSettings delete(String infrastructureId, AwsCloudRegion region) throws BitmovinException
    {
        return this.apiClient.delete(infrastructureId, region);
    }

    /**
    * AWS Region Settings Details
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @param region AWS region. (required)
    * @return AwsAccountRegionSettings
    * @throws BitmovinException if fails to make API call
    */
    public AwsAccountRegionSettings get(String infrastructureId, AwsCloudRegion region) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId, region);
    }
    /**
    * List AWS Region Settings
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @return List&lt;AwsAccountRegionSettings&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AwsAccountRegionSettings> list(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.list(infrastructureId, new HashMap<String, Object>());
    }

    /**
    * List AWS Region Settings
    * 
    * @param infrastructureId Id of the AWS account (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;AwsAccountRegionSettings&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<AwsAccountRegionSettings> list(String infrastructureId, AwsAccountRegionSettingssListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(infrastructureId, queryParams);
    }
}
