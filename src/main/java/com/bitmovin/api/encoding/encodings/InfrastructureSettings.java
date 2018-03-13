package com.bitmovin.api.encoding.encodings;

import com.bitmovin.utils.infrastructure.CloudRegion;

/**
 * Created by arudich on 09.11.17.
 **/
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
