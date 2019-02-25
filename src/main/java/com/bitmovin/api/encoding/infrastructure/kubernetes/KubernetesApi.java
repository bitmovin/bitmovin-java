package com.bitmovin.api.encoding.infrastructure.kubernetes;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.infrastructure.kubernetes.status.StatusApi;
import com.bitmovin.api.encoding.infrastructure.kubernetes.customdata.CustomdataApi;
import com.bitmovin.api.encoding.infrastructure.kubernetes.configuration.ConfigurationApi;
import com.bitmovin.api.encoding.infrastructure.kubernetes.agentDeployment.AgentDeploymentApi;
import com.bitmovin.api.encoding.infrastructure.kubernetes.prewarmedDeployment.PrewarmedDeploymentApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KubernetesApi
{
    private final KubernetesClient apiClient;
    public StatusApi status;
    public CustomdataApi customdata;
    public ConfigurationApi configuration;
    public AgentDeploymentApi agentDeployment;
    public PrewarmedDeploymentApi prewarmedDeployment;

    public KubernetesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public KubernetesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public KubernetesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(KubernetesClient.class);

        status = new StatusApi(clientFactory);
        customdata = new CustomdataApi(clientFactory);
        configuration = new ConfigurationApi(clientFactory);
        agentDeployment = new AgentDeploymentApi(clientFactory);
        prewarmedDeployment = new PrewarmedDeploymentApi(clientFactory);
    }


    /**
    * Connect Kubernetes Cluster
    * 
    * @param kubernetesCluster  (optional)
    * @return KubernetesCluster
    * @throws BitmovinException if fails to make API call
    */
    public KubernetesCluster create(KubernetesCluster kubernetesCluster) throws BitmovinException
    {
        return this.apiClient.create(kubernetesCluster);
    }

    /**
    * Disconnect Kubernetes Cluster
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.delete(infrastructureId);
    }

    /**
    * Kubernetes Cluster Details
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @return KubernetesCluster
    * @throws BitmovinException if fails to make API call
    */
    public KubernetesCluster get(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId);
    }
    /**
    * List Kubernetes Cluster
    * 
    * @return List&lt;KubernetesCluster&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<KubernetesCluster> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Kubernetes Cluster
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;KubernetesCluster&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<KubernetesCluster> list(KubernetesClustersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
