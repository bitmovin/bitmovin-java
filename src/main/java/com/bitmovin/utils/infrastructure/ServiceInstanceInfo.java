package com.bitmovin.utils.infrastructure;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * This class represents information required by any application handling VM instances.
 **/
public class ServiceInstanceInfo
{
    private String instanceId = "";

    private String externalIp = "";

    private String internalIp = "";

    public ServiceInstanceInfo() {}

    public ServiceInstanceInfo(IInstance instance)
    {
        this.instanceId = instance.getId();
        this.externalIp = instance.getExternalIp();
        this.internalIp = instance.getInternalIp();
    }

    public String getInstanceId()
    {
        return instanceId;
    }

    public void setInstanceId(String instanceId)
    {
        this.instanceId = instanceId;
    }

    public String getExternalIp()
    {
        return externalIp;
    }

    public void setExternalIp(String externalIp)
    {
        this.externalIp = externalIp;
    }

    public String getInternalIp()
    {
        return internalIp;
    }

    public void setInternalIp(String internalIp)
    {
        this.internalIp = internalIp;
    }


    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("instanceId", instanceId)
                .append("externalIp", externalIp)
                .append("internalIp", internalIp)
                .toString();
    }
}
