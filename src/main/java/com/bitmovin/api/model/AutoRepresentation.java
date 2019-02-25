package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AutoRepresentation
 */

public class AutoRepresentation {
  @JsonProperty("adoptConfigurationThreshold")
  private Double adoptConfigurationThreshold;


  /**
   * This is the threshold if the settings of the lower or the upper representation (codec configuration) should be used, when representations are added automatically
   * @return adoptConfigurationThreshold
  **/
  public Double getAdoptConfigurationThreshold() {
    return adoptConfigurationThreshold;
  }

  public void setAdoptConfigurationThreshold(Double adoptConfigurationThreshold) {
    this.adoptConfigurationThreshold = adoptConfigurationThreshold;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AutoRepresentation autoRepresentation = (AutoRepresentation) o;
    return Objects.equals(this.adoptConfigurationThreshold, autoRepresentation.adoptConfigurationThreshold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adoptConfigurationThreshold);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AutoRepresentation {\n");
    
    sb.append("    adoptConfigurationThreshold: ").append(toIndentedString(adoptConfigurationThreshold)).append("\n");
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

