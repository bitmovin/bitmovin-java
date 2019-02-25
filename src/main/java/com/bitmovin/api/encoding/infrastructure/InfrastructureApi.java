package com.bitmovin.api.encoding.infrastructure;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.infrastructure.kubernetes.KubernetesApi;
import com.bitmovin.api.encoding.infrastructure.aws.AwsApi;


public class InfrastructureApi
{
    public KubernetesApi kubernetes;
    public AwsApi aws;

    public InfrastructureApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InfrastructureApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InfrastructureApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        kubernetes = new KubernetesApi(clientFactory);
        aws = new AwsApi(clientFactory);
    }

}
