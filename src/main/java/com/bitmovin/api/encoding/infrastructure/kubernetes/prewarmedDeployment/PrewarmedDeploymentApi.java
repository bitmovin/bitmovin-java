package com.bitmovin.api.encoding.infrastructure.kubernetes.prewarmedDeployment;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrewarmedDeploymentApi
{
    private final PrewarmedDeploymentClient apiClient;

    public PrewarmedDeploymentApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public PrewarmedDeploymentApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public PrewarmedDeploymentApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(PrewarmedDeploymentClient.class);

    }


    /**
    * Prewarm Encoders
    * 
    * @param infrastructureId Id of the kubernetes cluster. (required)
    * @param prewarmEncoderSettings  (optional)
    * @return PrewarmEncoderSettings
    * @throws BitmovinException if fails to make API call
    */
    public PrewarmEncoderSettings create(String infrastructureId, PrewarmEncoderSettings prewarmEncoderSettings) throws BitmovinException
    {
        return this.apiClient.create(infrastructureId, prewarmEncoderSettings);
    }

    /**
    * Delete Prewarmed Encoders
    * 
    * @param infrastructureId Id of the kubernetes cluster. (required)
    * @param deploymentId Id of the prewarmed deployment. (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String infrastructureId, String deploymentId) throws BitmovinException
    {
        return this.apiClient.delete(infrastructureId, deploymentId);
    }

    /**
    * Get Prewarmed Encoders
    * 
    * @param infrastructureId Id of the kubernetes cluster. (required)
    * @param deploymentId Id of the prewarmed deployment. (required)
    * @return PrewarmEncoderSettings
    * @throws BitmovinException if fails to make API call
    */
    public PrewarmEncoderSettings get(String infrastructureId, String deploymentId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId, deploymentId);
    }
    /**
    * List Prewarmed Encoders
    * 
    * @param infrastructureId Id of the kubernetes cluster. (required)
    * @return List&lt;PrewarmEncoderSettings&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PrewarmEncoderSettings> list(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.list(infrastructureId, new HashMap<String, Object>());
    }

    /**
    * List Prewarmed Encoders
    * 
    * @param infrastructureId Id of the kubernetes cluster. (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;PrewarmEncoderSettings&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<PrewarmEncoderSettings> list(String infrastructureId, PrewarmEncoderSettingssListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(infrastructureId, queryParams);
    }
}
