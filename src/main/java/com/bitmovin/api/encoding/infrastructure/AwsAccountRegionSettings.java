package com.bitmovin.api.encoding.infrastructure;

import com.bitmovin.api.AbstractApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsAccountRegionSettings extends AbstractApiResponse
{
    private Long limitParallelEncodings;
    private Long maximumAmountOfCoordinatorsAndWorkersInRegion;
    private BigDecimal maxMoneyToSpendPerMonth;
    private String securityGroupId;
    private String subnetId;
    private List<String> machineTypes;

    public Long getLimitParallelEncodings()
    {
        return this.limitParallelEncodings;
    }

    public void setLimitParallelEncodings(Long limitParallelEncodings)
    {
        this.limitParallelEncodings = limitParallelEncodings;
    }

    public Long getMaximumAmountOfCoordinatorsAndWorkersInRegion()
    {
        return this.maximumAmountOfCoordinatorsAndWorkersInRegion;
    }

    public void setMaximumAmountOfCoordinatorsAndWorkersInRegion(Long maximumAmountOfCoordinatorsAndWorkersInRegion)
    {
        this.maximumAmountOfCoordinatorsAndWorkersInRegion = maximumAmountOfCoordinatorsAndWorkersInRegion;
    }

    public BigDecimal getMaxMoneyToSpendPerMonth()
    {
        return this.maxMoneyToSpendPerMonth;
    }

    public void setMaxMoneyToSpendPerMonth(BigDecimal maxMoneyToSpendPerMonth)
    {
        this.maxMoneyToSpendPerMonth = maxMoneyToSpendPerMonth;
    }

    public String getSecurityGroupId()
    {
        return this.securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId)
    {
        this.securityGroupId = securityGroupId;
    }

    public String getSubnetId()
    {
        return this.subnetId;
    }

    public void setSubnetId(String subnetId)
    {
        this.subnetId = subnetId;
    }

    public List<String> getMachineTypes()
    {
        return this.machineTypes;
    }

    public void setMachineTypes(List<String> machineTypes)
    {
        this.machineTypes = machineTypes;
    }
}
