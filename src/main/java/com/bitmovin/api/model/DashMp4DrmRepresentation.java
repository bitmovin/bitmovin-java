package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DashMp4Representation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashMp4DrmRepresentation
 */

public class DashMp4DrmRepresentation extends DashMp4Representation {
  @JsonProperty("drmId")
  private String drmId;


  /**
   * DRM Id
   * @return drmId
  **/
  public String getDrmId() {
    return drmId;
  }

  public void setDrmId(String drmId) {
    this.drmId = drmId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashMp4DrmRepresentation dashMp4DrmRepresentation = (DashMp4DrmRepresentation) o;
    return Objects.equals(this.drmId, dashMp4DrmRepresentation.drmId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(drmId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashMp4DrmRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    drmId: ").append(toIndentedString(drmId)).append("\n");
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

