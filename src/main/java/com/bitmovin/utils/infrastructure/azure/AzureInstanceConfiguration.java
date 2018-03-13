package com.bitmovin.utils.infrastructure.azure;

import com.bitmovin.utils.infrastructure.AbstractInstanceConfiguration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arudich on 13.09.17.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureInstanceConfiguration extends AbstractInstanceConfiguration
{
    private AzureRegion azureRegion;

    private AzureMachineType machineType;

    private AzureDiskType diskType;

    private Integer diskSizeGb;

    private String imageName;

    private String resourceGroupId;

    private String networkName;

    private String subnetName;

    private boolean lowPriorityInstance;

    private Set<Integer> checkPorts = new HashSet<>();

    public AzureInstanceConfiguration()
    {
    }

    public AzureRegion getAzureRegion()
    {
        return this.azureRegion;
    }

    public void setAzureRegion(AzureRegion azureRegion)
    {
        this.azureRegion = azureRegion;
    }

    public AzureMachineType getMachineType()
    {
        return this.machineType;
    }

    public void setMachineType(AzureMachineType machineType)
    {
        this.machineType = machineType;
    }

    public AzureDiskType getDiskType()
    {
        return this.diskType;
    }

    public void setDiskType(AzureDiskType diskType)
    {
        this.diskType = diskType;
    }

    public Integer getDiskSizeGb()
    {
        return this.diskSizeGb;
    }

    public void setDiskSizeGb(Integer diskSizeGb)
    {
        this.diskSizeGb = diskSizeGb;
    }

    public String getImageName()
    {
        return this.imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }

    public String getResourceGroupId()
    {
        return this.resourceGroupId;
    }

    public void setResourceGroupId(String resourceGroupId)
    {
        this.resourceGroupId = resourceGroupId;
    }

    public String getNetworkName()
    {
        return this.networkName;
    }

    public void setNetworkName(String networkName)
    {
        this.networkName = networkName;
    }

    public String getSubnetName()
    {
        return this.subnetName;
    }

    public void setSubnetName(String subnetName)
    {
        this.subnetName = subnetName;
    }

    public boolean getLowPriorityInstance()
    {
        return this.lowPriorityInstance;
    }

    public void setLowPriorityInstance(boolean lowPriorityInstance)
    {
        this.lowPriorityInstance = lowPriorityInstance;
    }

    public Set<Integer> getCheckPorts()
    {
        return this.checkPorts;
    }

    public void setCheckPorts(Set<Integer> checkPorts)
    {
        this.checkPorts = checkPorts;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (!(o instanceof AzureInstanceConfiguration)) return false;

        AzureInstanceConfiguration that = (AzureInstanceConfiguration) o;

        return new EqualsBuilder()
                .append(azureRegion, that.azureRegion)
                .append(machineType, that.machineType)
                .append(diskType, that.diskType)
                .append(diskSizeGb, that.diskSizeGb)
                .append(imageName, that.imageName)
                .append(resourceGroupId, that.resourceGroupId)
                .append(networkName, that.networkName)
                .append(subnetName, that.subnetName)
                .append(checkPorts, that.checkPorts)
                .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(azureRegion)
                .append(machineType)
                .append(diskType)
                .append(diskSizeGb)
                .append(imageName)
                .append(resourceGroupId)
                .append(networkName)
                .append(subnetName)
                .append(checkPorts)
                .toHashCode();
    }

    @Override
    public String getRegion()
    {
        return this.azureRegion.toString();
    }
}
