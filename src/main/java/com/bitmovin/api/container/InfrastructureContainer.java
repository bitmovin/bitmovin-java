package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.encodings.kubernetes.KubernetesCluster;
import com.bitmovin.api.resource.KubernetesResource;

import java.util.Map;

public class InfrastructureContainer
{
    public KubernetesResource<KubernetesCluster> kubernetes;

    public InfrastructureContainer(Map<String, String> headers)
    {
        this.kubernetes = new KubernetesResource<>(headers, ApiUrls.kubernetesUrl, KubernetesCluster.class);
    }
}
