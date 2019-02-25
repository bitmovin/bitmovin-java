package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AutoRepresentation;
import com.bitmovin.api.model.PerTitleConfiguration;
import com.bitmovin.api.model.PerTitleFixedResolutionAndBitrateConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Vp9PerTitleConfiguration
 */

public class Vp9PerTitleConfiguration extends PerTitleConfiguration {
  @JsonProperty("targetQualityCrf")
  private Double targetQualityCrf;


  /**
   * Desired target quality of the highest representation expressed as CRF value
   * @return targetQualityCrf
  **/
  public Double getTargetQualityCrf() {
    return targetQualityCrf;
  }

  public void setTargetQualityCrf(Double targetQualityCrf) {
    this.targetQualityCrf = targetQualityCrf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vp9PerTitleConfiguration vp9PerTitleConfiguration = (Vp9PerTitleConfiguration) o;
    return Objects.equals(this.targetQualityCrf, vp9PerTitleConfiguration.targetQualityCrf) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetQualityCrf, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vp9PerTitleConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    targetQualityCrf: ").append(toIndentedString(targetQualityCrf)).append("\n");
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

