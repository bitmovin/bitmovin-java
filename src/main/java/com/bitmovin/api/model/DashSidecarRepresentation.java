package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DashRepresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashSidecarRepresentation
 */

public class DashSidecarRepresentation extends DashRepresentation {
  @JsonProperty("sidecarId")
  private String sidecarId;


  /**
   * Sidecar Id
   * @return sidecarId
  **/
  public String getSidecarId() {
    return sidecarId;
  }

  public void setSidecarId(String sidecarId) {
    this.sidecarId = sidecarId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashSidecarRepresentation dashSidecarRepresentation = (DashSidecarRepresentation) o;
    return Objects.equals(this.sidecarId, dashSidecarRepresentation.sidecarId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sidecarId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashSidecarRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    sidecarId: ").append(toIndentedString(sidecarId)).append("\n");
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

