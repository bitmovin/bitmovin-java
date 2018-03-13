package com.bitmovin.utils.infrastructure.aws;

import com.amazonaws.services.ec2.model.InstanceType;
import com.bitmovin.utils.infrastructure.AbstractInstanceConfiguration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsInstanceConfiguration extends AbstractInstanceConfiguration
{
    private String availabilityZone;

    private Integer diskSizeGb = 100;

    private InstanceType instanceType;

    private String imageId;

    private String subnetId;

    private String securityGroupId;

    private String namePrefix;

    private Boolean spotInstance;

    private float maxSpotInstancePrice;

    private Integer spotInstanceDurationMinutes;

    private Set<Integer> checkPorts = new HashSet<>();

    private String region;

    public String getRegion()
    {
        return this.region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public AwsInstanceConfiguration()
    {
        this.maxSpotInstancePrice = 0;
    }

    public String getAvailabilityZone() { return this.availabilityZone; }

    public void setAvailabilityZone(String availabilityZone)
    {
        this.availabilityZone = availabilityZone;
    }

    public String getInstanceType() { return this.instanceType.toString(); }

    public InstanceType instanceTypeObject() { return this.instanceType; }

    public void setInstanceType(String instanceType) { this.instanceType = InstanceType.fromValue(instanceType); }

    public String getImageId() { return this.imageId; }

    public void setImageId(String imageId) { this.imageId = imageId; }

    public String getSubnetId() { return this.subnetId; }

    public void setSubnetId(String subnetId) { this.subnetId = subnetId; }

    public String getSecurityGroupId() { return this.securityGroupId; }

    public void setSecurityGroupId(String securityGroupId) { this.securityGroupId = securityGroupId; }

    public String getNamePrefix() { return this.namePrefix; }

    public void setNamePrefix(String namePrefix) { this.namePrefix = namePrefix; }

    public Boolean isSpotInstance() { return this.spotInstance; }

    public void setSpotInstance(Boolean spotInstance) { this.spotInstance = spotInstance; }

    public float getMaxSpotInstancePrice() { return this.maxSpotInstancePrice; }

    public void setMaxSpotInstancePrice(float maxSpotInstancePrice) { this.maxSpotInstancePrice = maxSpotInstancePrice; }

    public Set<Integer> getCheckPorts() { return this.checkPorts; }

    public void setCheckPorts(Set<Integer> checkPorts) { this.checkPorts = checkPorts; }

    public Integer getDiskSizeGb()
    {
        return diskSizeGb;
    }

    public void setDiskSizeGb(Integer diskSizeGb)
    {
        this.diskSizeGb = diskSizeGb;
    }

    public Boolean getSpotInstance()
    {
        return spotInstance;
    }

    public Integer getSpotInstanceDurationMinutes()
    {
        return this.spotInstanceDurationMinutes;
    }

    public void setSpotInstanceDurationMinutes(Integer spotInstanceDurationMinutes)
    {
        this.spotInstanceDurationMinutes = spotInstanceDurationMinutes;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof AwsInstanceConfiguration)) return false;

        AwsInstanceConfiguration that = (AwsInstanceConfiguration) o;

        if (Float.compare(that.maxSpotInstancePrice, maxSpotInstancePrice) != 0) return false;
        if (availabilityZone != null ? !availabilityZone.equals(that.availabilityZone) : that.availabilityZone != null)
            return false;
        if (diskSizeGb != null ? !diskSizeGb.equals(that.diskSizeGb) : that.diskSizeGb != null) return false;
        if (instanceType != that.instanceType) return false;
        if (imageId != null ? !imageId.equals(that.imageId) : that.imageId != null) return false;
        if (subnetId != null ? !subnetId.equals(that.subnetId) : that.subnetId != null) return false;
        if (securityGroupId != null ? !securityGroupId.equals(that.securityGroupId) : that.securityGroupId != null)
            return false;
        if (namePrefix != null ? !namePrefix.equals(that.namePrefix) : that.namePrefix != null) return false;
        if (spotInstance != null ? !spotInstance.equals(that.spotInstance) : that.spotInstance != null) return false;
        if (spotInstanceDurationMinutes != null ? !spotInstanceDurationMinutes.equals(that.spotInstanceDurationMinutes) : that.spotInstanceDurationMinutes != null)
            return false;
        if (checkPorts != null ? !checkPorts.equals(that.checkPorts) : that.checkPorts != null) return false;
        return region != null ? region.equals(that.region) : that.region == null;

    }

    @Override
    public int hashCode()
    {
        int result = availabilityZone != null ? availabilityZone.hashCode() : 0;
        result = 31 * result + (diskSizeGb != null ? diskSizeGb.hashCode() : 0);
        result = 31 * result + (instanceType != null ? instanceType.hashCode() : 0);
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        result = 31 * result + (subnetId != null ? subnetId.hashCode() : 0);
        result = 31 * result + (securityGroupId != null ? securityGroupId.hashCode() : 0);
        result = 31 * result + (namePrefix != null ? namePrefix.hashCode() : 0);
        result = 31 * result + (spotInstance != null ? spotInstance.hashCode() : 0);
        result = 31 * result + (maxSpotInstancePrice != +0.0f ? Float.floatToIntBits(maxSpotInstancePrice) : 0);
        result = 31 * result + (spotInstanceDurationMinutes != null ? spotInstanceDurationMinutes.hashCode() : 0);
        result = 31 * result + (checkPorts != null ? checkPorts.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }
}
