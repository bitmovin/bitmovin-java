package com.bitmovin.utils.infrastructure.aws;

import com.amazonaws.services.ec2.model.InstanceStateName;
import com.bitmovin.utils.infrastructure.AbstractInstance;
import com.bitmovin.utils.infrastructure.InstanceStatus;
import com.bitmovin.utils.infrastructure.Provider;
import com.bitmovin.utils.infrastructure.UsageState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

/**
 * This class represents the instance.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsInstance extends AbstractInstance
{
    private String awsId;

    private Long startTimeMilliseconds;

    private long instanceBillingCycleMilliseconds;

    private AwsCredentials credentials;

    private InstanceStateName instanceStateName;

    private AwsInstanceConfiguration configuration;

    public AwsInstance()
    {
        super();
        this.setProvider(Provider.AWS);
        this.setUsageState(UsageState.USED);
        this.setStatus(InstanceStatus.STARTING);
        this.setId(UUID.randomUUID().toString());
        this.instanceBillingCycleMilliseconds = 500000; /*ToDo get from AWSConfig */
        this.instanceStateName = InstanceStateName.Pending;
        this.startTimeMilliseconds = System.currentTimeMillis();
    }

    public AwsInstance(AwsInstanceConfiguration config, AwsCredentials credentials)
    {
        this();
        this.setConfiguration(config);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        this.setId(config.getNamePrefix() + config.getImageId() + "-" + uuid);
        this.credentials = credentials;
    }

    public String getAwsId()
    {
        return this.awsId;
    }

    public void setAwsId(String awsId)
    {
        this.awsId = awsId;
    }

    public Long getStartTimeMilliseconds()
    {
        return this.startTimeMilliseconds;
    }

    public void setStartTimeMilliseconds(Long startTimeMilliseconds)
    {
        this.startTimeMilliseconds = startTimeMilliseconds;
    }

    public AwsCredentials getCredentials()
    {
        return credentials;
    }

    public void setCredentials(AwsCredentials credentials)
    {
        this.credentials = credentials;
    }

    public long getInstanceBillingCycleMilliseconds()
    {
        return instanceBillingCycleMilliseconds;
    }

    public void setInstanceBillingCycleMilliseconds(long instanceBillingCycleMilliseconds)
    {
        this.instanceBillingCycleMilliseconds = instanceBillingCycleMilliseconds;
    }

    @JsonIgnore
    public InstanceStateName getInstanceStateName()
    {
        return instanceStateName;
    }

    @JsonIgnore
    public void setInstanceStateName(InstanceStateName instanceStateName)
    {
        this.instanceStateName = instanceStateName;
    }

    @Override
    public AwsInstanceConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public void setConfiguration(AwsInstanceConfiguration configuration)
    {
        this.configuration = configuration;
    }

    @Override
    public String getRegion()
    {
        return this.getConfiguration().getRegion();
    }
}
