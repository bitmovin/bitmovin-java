package com.bitmovin.utils.infrastructure;

import com.bitmovin.utils.infrastructure.aws.AwsInstanceConfiguration;
import com.bitmovin.utils.infrastructure.azure.AzureInstanceConfiguration;
import com.bitmovin.utils.infrastructure.gce.GceInstanceConfiguration;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 29.02.16
 */
public interface IInstance
{
    String getId();

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "provider")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = GceInstanceConfiguration.class, name = "gce"),
            @JsonSubTypes.Type(value = AwsInstanceConfiguration.class, name = "aws"),
            @JsonSubTypes.Type(value = AzureInstanceConfiguration.class, name = "azure")
    })
    IInstanceConfiguration getConfiguration();

    InstanceStatus getStatus();
    void setStatus(InstanceStatus status);

    UsageState getUsageState();
    void setUsageState(UsageState usageState);

    String getRegion();
    String getExternalIp();
    String getInternalIp();

    Provider getProvider();
    void setProvider(Provider provider);
}
