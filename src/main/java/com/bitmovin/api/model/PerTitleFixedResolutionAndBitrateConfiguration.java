package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.PerTitleFixedResolutionAndBitrateConfigurationMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * PerTitleFixedResolutionAndBitrateConfiguration
 */

public class PerTitleFixedResolutionAndBitrateConfiguration {
  @JsonProperty("forcedRenditionAboveHighestFixedRepresentation")
  private Integer forcedRenditionAboveHighestFixedRepresentation;

  @JsonProperty("forcedRenditionAboveHighestFixedRepresentationFactor")
  private Double forcedRenditionAboveHighestFixedRepresentationFactor;

  @JsonProperty("forcedRenditionAboveHighestFixedRepresentationCalculationMode")
  private PerTitleFixedResolutionAndBitrateConfigurationMode forcedRenditionAboveHighestFixedRepresentationCalculationMode = null;


  /**
   * Number of forced renditions above the highest fixed representation (e.g. FIXED_RESOLUTION_AND_BITRATE). Forced renditions will be added, also if the Per-Title algorithm chooses the user defined force rendition to be the highest one.
   * minimum: 1
   * @return forcedRenditionAboveHighestFixedRepresentation
  **/
  public Integer getForcedRenditionAboveHighestFixedRepresentation() {
    return forcedRenditionAboveHighestFixedRepresentation;
  }

  public void setForcedRenditionAboveHighestFixedRepresentation(Integer forcedRenditionAboveHighestFixedRepresentation) {
    this.forcedRenditionAboveHighestFixedRepresentation = forcedRenditionAboveHighestFixedRepresentation;
  }


  /**
   * The factor to calculate the bitrate that will be chosen based on the bitrate of the last FIXED_RESOLUTION.
   * @return forcedRenditionAboveHighestFixedRepresentationFactor
  **/
  public Double getForcedRenditionAboveHighestFixedRepresentationFactor() {
    return forcedRenditionAboveHighestFixedRepresentationFactor;
  }

  public void setForcedRenditionAboveHighestFixedRepresentationFactor(Double forcedRenditionAboveHighestFixedRepresentationFactor) {
    this.forcedRenditionAboveHighestFixedRepresentationFactor = forcedRenditionAboveHighestFixedRepresentationFactor;
  }


  /**
   * Mode to calculate the bitrate of the next representation
   * @return forcedRenditionAboveHighestFixedRepresentationCalculationMode
  **/
  public PerTitleFixedResolutionAndBitrateConfigurationMode getForcedRenditionAboveHighestFixedRepresentationCalculationMode() {
    return forcedRenditionAboveHighestFixedRepresentationCalculationMode;
  }

  public void setForcedRenditionAboveHighestFixedRepresentationCalculationMode(PerTitleFixedResolutionAndBitrateConfigurationMode forcedRenditionAboveHighestFixedRepresentationCalculationMode) {
    this.forcedRenditionAboveHighestFixedRepresentationCalculationMode = forcedRenditionAboveHighestFixedRepresentationCalculationMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerTitleFixedResolutionAndBitrateConfiguration perTitleFixedResolutionAndBitrateConfiguration = (PerTitleFixedResolutionAndBitrateConfiguration) o;
    return Objects.equals(this.forcedRenditionAboveHighestFixedRepresentation, perTitleFixedResolutionAndBitrateConfiguration.forcedRenditionAboveHighestFixedRepresentation) &&
        Objects.equals(this.forcedRenditionAboveHighestFixedRepresentationFactor, perTitleFixedResolutionAndBitrateConfiguration.forcedRenditionAboveHighestFixedRepresentationFactor) &&
        Objects.equals(this.forcedRenditionAboveHighestFixedRepresentationCalculationMode, perTitleFixedResolutionAndBitrateConfiguration.forcedRenditionAboveHighestFixedRepresentationCalculationMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forcedRenditionAboveHighestFixedRepresentation, forcedRenditionAboveHighestFixedRepresentationFactor, forcedRenditionAboveHighestFixedRepresentationCalculationMode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerTitleFixedResolutionAndBitrateConfiguration {\n");
    
    sb.append("    forcedRenditionAboveHighestFixedRepresentation: ").append(toIndentedString(forcedRenditionAboveHighestFixedRepresentation)).append("\n");
    sb.append("    forcedRenditionAboveHighestFixedRepresentationFactor: ").append(toIndentedString(forcedRenditionAboveHighestFixedRepresentationFactor)).append("\n");
    sb.append("    forcedRenditionAboveHighestFixedRepresentationCalculationMode: ").append(toIndentedString(forcedRenditionAboveHighestFixedRepresentationCalculationMode)).append("\n");
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

