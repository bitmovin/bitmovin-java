package com.bitmovin.utils.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public abstract class AbstractInstance implements IInstance
{
    private String id;

    private Provider provider;

    private String externalIp;
    private String internalIp;

    private InstanceStatus status;

    private UsageState usageState;

    private Boolean manualShutdown = null;

    @JsonIgnore
    private long version;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setExternalIp(String externalIp)
    {
        this.externalIp = externalIp;
    }

    public void setInternalIp(String internalIp)
    {
        this.internalIp = internalIp;
    }

    public void setStatus(InstanceStatus status)
    {
        this.status = status;
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public InstanceStatus getStatus()
    {
        return this.status;
    }

    @Override
    public UsageState getUsageState()
    {
        return this.usageState;
    }

    @Override
    public void setUsageState(UsageState usageState)
    {
        this.usageState = usageState;
    }

    @Override
    public String getExternalIp()
    {
        return this.externalIp;
    }

    @Override
    public String getInternalIp()
    {
        return this.internalIp;
    }

    @Override
    public Provider getProvider()
    {
        return this.provider;
    }

    public void setProvider(Provider provider)
    {
        this.provider = provider;
    }

    public Boolean getManualShutdown()
    {
        return this.manualShutdown;
    }

    public void setManualShutdown(Boolean manualShutdown)
    {
        this.manualShutdown = manualShutdown;
    }

    public long getVersion()
    {
        return version;
    }

    public void setVersion(long version)
    {
        this.version = version;
    }
}
