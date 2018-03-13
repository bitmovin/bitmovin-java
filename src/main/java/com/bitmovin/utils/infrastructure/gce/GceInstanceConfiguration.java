package com.bitmovin.utils.infrastructure.gce;

import com.bitmovin.utils.infrastructure.AbstractInstanceConfiguration;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public class GceInstanceConfiguration extends AbstractInstanceConfiguration
{
    private String projectId = "bitmovintest";

    private GceZoneName zoneName = GceZoneName.EUROPE_WEST1_D;

    private Set<GceMachineType> typeRange = new HashSet<>();

    private GceMachineType preferredType;

    private String imagePath;

    private Boolean externalIP = true;

    private Boolean preemptible = false;

    private GceDisk disk = GceDisk.PERSISTENT;

    private long diskSizeGb = 100;

    private GceDiskType diskType = GceDiskType.HDD;

    private String network = "/global/networks/default";

    private Set<Integer> checkPorts = new HashSet<>();


    public GceInstanceConfiguration()
    {
    }

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public GceZoneName getZoneName()
    {
        return zoneName;
    }

    public void setZoneName(GceZoneName zoneName)
    {
        this.zoneName = zoneName;
    }

    public Set<GceMachineType> getTypeRange()
    {
        return typeRange;
    }

    public void setTypeRange(Set<GceMachineType> typeRange)
    {
        this.typeRange = typeRange;
    }

    public GceMachineType getPreferredType()
    {
        return preferredType;
    }

    public void setPreferredType(GceMachineType preferredType)
    {
        this.preferredType = preferredType;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public Boolean getPreemptible()
    {
        return preemptible;
    }

    public Boolean hasExternalIp()
    {
        return externalIP;
    }

    public void setExternalIP(Boolean externalIP)
    {
        this.externalIP = externalIP;
    }

    public void setPreemptible(Boolean preemptible)
    {
        this.preemptible = preemptible;
    }

    public Boolean isPreemptible()
    {
        return preemptible;
    }

    public GceDisk getDisk()
    {
        return disk;
    }

    public void setDisk(GceDisk disk)
    {
        this.disk = disk;
    }

    public GceDiskType getDiskType()
    {
        return diskType;
    }

    public void setDiskType(GceDiskType diskType)
    {
        this.diskType = diskType;
    }

    public String getNetwork()
    {
        return network;
    }

    public void setNetwork(String network)
    {
        this.network = network;
    }

    public long getDiskSizeGb()
    {
        return diskSizeGb;
    }

    public void setDiskSizeGb(long diskSizeGb)
    {
        this.diskSizeGb = diskSizeGb;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof GceInstanceConfiguration)) return false;

        GceInstanceConfiguration that = (GceInstanceConfiguration) o;

        if (this.diskSizeGb != that.diskSizeGb) return false;
        if (this.projectId != null ? !this.projectId.equals(that.projectId) : that.projectId != null) return false;
        if (this.zoneName != that.zoneName) return false;
        if (!this.typeRange.equals(that.typeRange)) return false;
        if (this.preferredType != that.preferredType) return false;
        if (!this.imagePath.equals(that.imagePath)) return false;
        if (this.externalIP != null ? !this.externalIP.equals(that.externalIP) : that.externalIP != null) return false;
        if (this.preemptible != null ? !this.preemptible.equals(that.preemptible) : that.preemptible != null) return false;
        if (this.disk != that.disk) return false;
        if (this.diskType != that.diskType) return false;
        if (this.network != null ? !this.network.equals(that.network) : that.network != null) return false;
        return this.checkPorts != null ? this.checkPorts.equals(that.checkPorts) : that.checkPorts == null;

    }

    @Override
    public int hashCode()
    {
        int result = this.projectId != null ? this.projectId.hashCode() : 0;
        result = 31 * result + this.zoneName.hashCode();
        result = 31 * result + this.typeRange.hashCode();
        result = 31 * result + this.preferredType.hashCode();
        result = 31 * result + this.imagePath.hashCode();
        result = 31 * result + (this.externalIP != null ? this.externalIP.hashCode() : 0);
        result = 31 * result + (this.preemptible != null ? this.preemptible.hashCode() : 0);
        result = 31 * result + (this.disk != null ? this.disk.hashCode() : 0);
        result = 31 * result + (int) (this.diskSizeGb ^ (this.diskSizeGb >>> 32));
        result = 31 * result + (this.diskType != null ? this.diskType.hashCode() : 0);
        result = 31 * result + (this.network != null ? this.network.hashCode() : 0);
        result = 31 * result + (this.checkPorts != null ? this.checkPorts.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    public static String getDefaultNetworkInterfaceConfig() { return "ONE_TO_ONE_NAT"; }

    @JsonIgnore
    public static String getDefaultNetworkAccessConfig() { return "External NAT"; }

    public Set<Integer> getCheckPorts() { return this.checkPorts; }

    public void setCheckPorts(Set<Integer> checkPorts) { this.checkPorts = checkPorts; }

    @Override
    public String getRegion()
    {
        if(this.zoneName == null)
        {
            return "not available";
        }

        if(this.zoneName.toString().lastIndexOf('-') > 0)
        {
            return this.zoneName.toString().substring(0, this.zoneName.toString().lastIndexOf('-'));
        }
        else
        {
            return this.zoneName.toString();
        }
    }
}
