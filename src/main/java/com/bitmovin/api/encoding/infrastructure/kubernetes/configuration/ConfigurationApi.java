package com.bitmovin.api.encoding.infrastructure.kubernetes.configuration;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationApi
{
    private final ConfigurationClient apiClient;

    public ConfigurationApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ConfigurationApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ConfigurationApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ConfigurationClient.class);

    }


    /**
    * Retrieve Kubernetes Cluster Configuration
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @return KubernetesClusterConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public KubernetesClusterConfiguration get(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId);
    }

    /**
    * Update Kubernetes Cluster Configuration
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @param kubernetesClusterConfiguration  (optional)
    * @return KubernetesClusterConfiguration
    * @throws BitmovinException if fails to make API call
    */
    public KubernetesClusterConfiguration putEncodingInfrastructureKubernetesConfigurationByInfrastructureId(String infrastructureId, KubernetesClusterConfiguration kubernetesClusterConfiguration) throws BitmovinException
    {
        return this.apiClient.putEncodingInfrastructureKubernetesConfigurationByInfrastructureId(infrastructureId, kubernetesClusterConfiguration);
    }
}
