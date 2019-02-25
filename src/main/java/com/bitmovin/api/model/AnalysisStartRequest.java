package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.CloudRegion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalysisStartRequest
 */

public class AnalysisStartRequest {
  @JsonProperty("path")
  private String path;

  @JsonProperty("cloudRegion")
  private CloudRegion cloudRegion = null;


  /**
   * Get path
   * @return path
  **/
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
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
    AnalysisStartRequest analysisStartRequest = (AnalysisStartRequest) o;
    return Objects.equals(this.path, analysisStartRequest.path) &&
        Objects.equals(this.cloudRegion, analysisStartRequest.cloudRegion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, cloudRegion);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysisStartRequest {\n");
    
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

