package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * RescheduleEncodingRequest
 */

public class RescheduleEncodingRequest {
  @JsonProperty("infrastructureId")
  private String infrastructureId;


  /**
   * Id of a custom infrastructure, e.g., Kubernetes Cluster
   * @return infrastructureId
  **/
  public String getInfrastructureId() {
    return infrastructureId;
  }

  public void setInfrastructureId(String infrastructureId) {
    this.infrastructureId = infrastructureId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RescheduleEncodingRequest rescheduleEncodingRequest = (RescheduleEncodingRequest) o;
    return Objects.equals(this.infrastructureId, rescheduleEncodingRequest.infrastructureId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infrastructureId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RescheduleEncodingRequest {\n");
    
    sb.append("    infrastructureId: ").append(toIndentedString(infrastructureId)).append("\n");
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

