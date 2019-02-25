package com.bitmovin.api.encoding.infrastructure.kubernetes.status;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusApi
{
    private final StatusClient apiClient;

    public StatusApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StatusApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StatusApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StatusClient.class);

    }


    /**
    * Kubernetes Cluster Status
    * 
    * @param infrastructureId Id of the Kubernetes cluster (required)
    * @throws BitmovinException if fails to make API call
    */
    public Object get(String infrastructureId) throws BitmovinException
    {
        return this.apiClient.get(infrastructureId);
    }
}
