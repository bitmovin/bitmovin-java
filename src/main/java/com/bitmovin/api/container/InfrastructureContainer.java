package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.encodings.kubernetes.KubernetesCluster;
import com.bitmovin.api.resource.AwsAccountRegionSettingsResource;
import com.bitmovin.api.resource.AwsAccountResource;
import com.bitmovin.api.resource.KubernetesResource;
import com.bitmovin.api.encoding.infrastructure.AwsAccount;

import java.util.Map;

public class InfrastructureContainer
{
    public KubernetesResource<KubernetesCluster> kubernetes;
    public AwsAccountResource awsAccount;
    public AwsAccountRegionSettingsResource awsAccountRegionSettings;

    public InfrastructureContainer(Map<String, String> headers)
    {
        this.kubernetes = new KubernetesResource<>(headers, ApiUrls.kubernetesUrl, KubernetesCluster.class);
        this.awsAccount = new AwsAccountResource(headers, ApiUrls.infrastructureAws);
        this.awsAccountRegionSettings = new AwsAccountRegionSettingsResource(headers,
                ApiUrls.infrastructureAwsRegionSettings);
    }
}
