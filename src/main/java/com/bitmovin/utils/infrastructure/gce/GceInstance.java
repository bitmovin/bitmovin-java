package com.bitmovin.utils.infrastructure.gce;

import com.bitmovin.utils.infrastructure.AbstractInstance;
import com.bitmovin.utils.infrastructure.InstanceStatus;
import com.bitmovin.utils.infrastructure.Provider;
import com.bitmovin.utils.infrastructure.UsageState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GceInstance extends AbstractInstance
{
    private String name;
    private Long startTimeMillis;

    private GceMachineType machineType;

    private GceCredentials credentials;

    private GceInstanceConfiguration configuration;

    public GceInstance()
    {
        super();
        this.setStatus(InstanceStatus.STARTING);
        this.setUsageState(UsageState.NEW);
        this.setProvider(Provider.GCE);
        this.setId(UUID.randomUUID().toString());
    }

    public GceInstance(GceInstanceConfiguration config, GceCredentials credentials)
    {
        this();
        this.setConfiguration(config);
        this.setCredentials(credentials);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getStartTimeMillis()
    {
        return startTimeMillis;
    }

    public void setStartTimeMillis(Long startTimeMillis)
    {
        this.startTimeMillis = startTimeMillis;
    }

    public GceMachineType getMachineType()
    {
        return machineType;
    }

    public void setMachineType(GceMachineType machineType)
    {
        this.machineType = machineType;
    }

    public GceCredentials getCredentials()
    {
        return credentials;
    }

    public void setCredentials(GceCredentials credentials)
    {
        this.credentials = credentials;
    }

    public void setConfiguration(GceInstanceConfiguration configuration)
    {
        this.configuration = configuration;
    }

    @Override
    public GceInstanceConfiguration getConfiguration()
    {
        return this.configuration;
    }

    @Override
    public String getRegion()
    {
        try
        {
            return this.getConfiguration().getRegion();
        }
        catch (NullPointerException e)
        {
            return "not available";
        }
    }
}
