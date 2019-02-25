package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AwsAccountRegionSettings
 */

public class AwsAccountRegionSettings extends BitmovinResource {
  @JsonProperty("limitParallelEncodings")
  private Long limitParallelEncodings;

  @JsonProperty("maximumAmountOfCoordinatorsAndWorkersInRegion")
  private Long maximumAmountOfCoordinatorsAndWorkersInRegion;

  @JsonProperty("maxMoneyToSpendPerMonth")
  private BigDecimal maxMoneyToSpendPerMonth;

  @JsonProperty("securityGroupId")
  private String securityGroupId;

  @JsonProperty("subnetId")
  private String subnetId;

  @JsonProperty("machineTypes")
  private List<String> machineTypes;

  @JsonProperty("sshPort")
  private Integer sshPort;


  /**
   * Limit for the amount of running encodings at a time. Leave empty for no limit.
   * @return limitParallelEncodings
  **/
  public Long getLimitParallelEncodings() {
    return limitParallelEncodings;
  }

  public void setLimitParallelEncodings(Long limitParallelEncodings) {
    this.limitParallelEncodings = limitParallelEncodings;
  }


  /**
   * Maximum amount of encoding coordinators and workers allowed in this region at any time. Leave empty for no limit.
   * @return maximumAmountOfCoordinatorsAndWorkersInRegion
  **/
  public Long getMaximumAmountOfCoordinatorsAndWorkersInRegion() {
    return maximumAmountOfCoordinatorsAndWorkersInRegion;
  }

  public void setMaximumAmountOfCoordinatorsAndWorkersInRegion(Long maximumAmountOfCoordinatorsAndWorkersInRegion) {
    this.maximumAmountOfCoordinatorsAndWorkersInRegion = maximumAmountOfCoordinatorsAndWorkersInRegion;
  }


  /**
   * Limit the amount of money to spend in this region on this account. Leave empty for no limit.
   * @return maxMoneyToSpendPerMonth
  **/
  public BigDecimal getMaxMoneyToSpendPerMonth() {
    return maxMoneyToSpendPerMonth;
  }

  public void setMaxMoneyToSpendPerMonth(BigDecimal maxMoneyToSpendPerMonth) {
    this.maxMoneyToSpendPerMonth = maxMoneyToSpendPerMonth;
  }


  /**
   * Id of the security group for encoding instances
   * @return securityGroupId
  **/
  public String getSecurityGroupId() {
    return securityGroupId;
  }

  public void setSecurityGroupId(String securityGroupId) {
    this.securityGroupId = securityGroupId;
  }


  /**
   * Id of the subnet for encoding instances
   * @return subnetId
  **/
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }


  public AwsAccountRegionSettings addMachineTypesItem(String machineTypesItem) {
    if (this.machineTypes == null) {
      this.machineTypes = new ArrayList<>();
    }
    this.machineTypes.add(machineTypesItem);
    return this;
  }

  /**
   * Which machine types are allowed to be deployed. Leave empty for no machine type restrictions.
   * @return machineTypes
  **/
  public List<String> getMachineTypes() {
    return machineTypes;
  }

  public void setMachineTypes(List<String> machineTypes) {
    this.machineTypes = machineTypes;
  }


  /**
   * Custom SSH port. Valid values: 1 - 65535. Leave empty if the default SSH port 22 is OK.
   * minimum: 1
   * maximum: 65535
   * @return sshPort
  **/
  public Integer getSshPort() {
    return sshPort;
  }

  public void setSshPort(Integer sshPort) {
    this.sshPort = sshPort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsAccountRegionSettings awsAccountRegionSettings = (AwsAccountRegionSettings) o;
    return Objects.equals(this.limitParallelEncodings, awsAccountRegionSettings.limitParallelEncodings) &&
        Objects.equals(this.maximumAmountOfCoordinatorsAndWorkersInRegion, awsAccountRegionSettings.maximumAmountOfCoordinatorsAndWorkersInRegion) &&
        Objects.equals(this.maxMoneyToSpendPerMonth, awsAccountRegionSettings.maxMoneyToSpendPerMonth) &&
        Objects.equals(this.securityGroupId, awsAccountRegionSettings.securityGroupId) &&
        Objects.equals(this.subnetId, awsAccountRegionSettings.subnetId) &&
        Objects.equals(this.machineTypes, awsAccountRegionSettings.machineTypes) &&
        Objects.equals(this.sshPort, awsAccountRegionSettings.sshPort) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limitParallelEncodings, maximumAmountOfCoordinatorsAndWorkersInRegion, maxMoneyToSpendPerMonth, securityGroupId, subnetId, machineTypes, sshPort, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsAccountRegionSettings {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    limitParallelEncodings: ").append(toIndentedString(limitParallelEncodings)).append("\n");
    sb.append("    maximumAmountOfCoordinatorsAndWorkersInRegion: ").append(toIndentedString(maximumAmountOfCoordinatorsAndWorkersInRegion)).append("\n");
    sb.append("    maxMoneyToSpendPerMonth: ").append(toIndentedString(maxMoneyToSpendPerMonth)).append("\n");
    sb.append("    securityGroupId: ").append(toIndentedString(securityGroupId)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
    sb.append("    machineTypes: ").append(toIndentedString(machineTypes)).append("\n");
    sb.append("    sshPort: ").append(toIndentedString(sshPort)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

