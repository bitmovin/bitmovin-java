package com.bitmovin.utils.infrastructure;


/**
 * Created by akopper on 21.06.16.
 */

public class PlatformConfiguration
{

    private Provider platform;

    private String region;

    ////////////////////////////////////////
    // Overrides

    private String image;

    private String instanceType;

    private Boolean spotInstances;

    private Integer numberOfInstancesOverride;

    private Integer diskSizeGB;

    ////////////////////////////////////////
    // Getter & Setter

    public Provider getPlatform()
    {
        return platform;
    }

    public void setPlatform(Provider platform)
    {
        this.platform = platform;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getInstanceType()
    {
        return instanceType;
    }

    public void setInstanceType(String instanceType)
    {
        this.instanceType = instanceType;
    }

    public Boolean isSpotInstances()
    {
        return spotInstances;
    }

    public void setSpotInstances(Boolean spotInstances)
    {
        this.spotInstances = spotInstances;
    }

    public Boolean getSpotInstances()
    {
        return this.spotInstances;
    }

    public Integer getNumberOfInstancesOverride()
    {
        return this.numberOfInstancesOverride;
    }

    public void setNumberOfInstancesOverride(Integer numberOfInstancesOverride)
    {
        this.numberOfInstancesOverride = numberOfInstancesOverride;
    }

    public Integer getDiskSizeGB()
    {
        return this.diskSizeGB;
    }

    public void setDiskSizeGB(Integer diskSizeGB)
    {
        this.diskSizeGB = diskSizeGB;
    }

}
