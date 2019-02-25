package com.bitmovin.api.encoding.infrastructure.kubernetes.agentDeployment;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentDeploymentApi
{
    private final AgentDeploymentClient apiClient;

    public AgentDeploymentApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public AgentDeploymentApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public AgentDeploymentApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(AgentDeploymentClient.class);

    }


    /**
    * Download bitmovin-agent deployment
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @throws BitmovinException if fails to make API call
    */
    public Object get(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId);
    }
}
