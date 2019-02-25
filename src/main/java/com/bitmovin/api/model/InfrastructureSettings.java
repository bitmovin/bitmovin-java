package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.CloudRegion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * InfrastructureSettings
 */

public class InfrastructureSettings {
  @JsonProperty("infrastructureId")
  private String infrastructureId;

  @JsonProperty("cloudRegion")
  private CloudRegion cloudRegion = null;


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


  /**
   * Get cloudRegion
   * @return cloudRegion
  **/
  public CloudRegion getCloudRegion() {
    return cloudRegion;
  }

  public void setCloudRegion(CloudRegion cloudRegion) {
    this.cloudRegion = cloudRegion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfrastructureSettings infrastructureSettings = (InfrastructureSettings) o;
    return Objects.equals(this.infrastructureId, infrastructureSettings.infrastructureId) &&
        Objects.equals(this.cloudRegion, infrastructureSettings.cloudRegion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infrastructureId, cloudRegion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfrastructureSettings {\n");
    
    sb.append("    infrastructureId: ").append(toIndentedString(infrastructureId)).append("\n");
    sb.append("    cloudRegion: ").append(toIndentedString(cloudRegion)).append("\n");
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

