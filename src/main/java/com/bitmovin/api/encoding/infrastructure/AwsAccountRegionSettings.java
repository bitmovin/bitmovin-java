package com.bitmovin.api.encoding.infrastructure;

import com.bitmovin.api.AbstractApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by arudich on 23.11.17.
 **/
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
        return limitParallelEncodings;
    }

    public void setLimitParallelEncodings(Long limitParallelEncodings)
    {
        this.limitParallelEncodings = limitParallelEncodings;
    }

    public Long getMaximumAmountOfCoordinatorsAndWorkersInRegion()
    {
        return maximumAmountOfCoordinatorsAndWorkersInRegion;
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
        return securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId)
    {
        this.securityGroupId = securityGroupId;
    }

    public String getSubnetId()
    {
        return subnetId;
    }

    public void setSubnetId(String subnetId)
    {
        this.subnetId = subnetId;
    }

    public List<String> getMachineTypes()
    {
        return machineTypes;
    }

    public void setMachineTypes(List<String> machineTypes)
    {
        this.machineTypes = machineTypes;
    }
}
