package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.encoding.enums.CloudRegion;

public class InfrastructureSettings
{
    private String infrastructureId;
    private CloudRegion cloudRegion;

    public InfrastructureSettings()
    {
    }

    public String getInfrastructureId()
    {
        return this.infrastructureId;
    }

    public void setInfrastructureId(String infrastructureId)
    {
        this.infrastructureId = infrastructureId;
    }

    public CloudRegion getCloudRegion()
    {
        return this.cloudRegion;
    }

    public void setCloudRegion(CloudRegion cloudRegion)
    {
        this.cloudRegion = cloudRegion;
    }
}
