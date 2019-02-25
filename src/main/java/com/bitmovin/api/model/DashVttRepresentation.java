package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashVttRepresentation
 */

public class DashVttRepresentation extends BitmovinResource {
  @JsonProperty("vttUrl")
  private String vttUrl;


  /**
   * URL of the referenced VTT file
   * @return vttUrl
  **/
  public String getVttUrl() {
    return vttUrl;
  }

  public void setVttUrl(String vttUrl) {
    this.vttUrl = vttUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashVttRepresentation dashVttRepresentation = (DashVttRepresentation) o;
    return Objects.equals(this.vttUrl, dashVttRepresentation.vttUrl) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vttUrl, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashVttRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    vttUrl: ").append(toIndentedString(vttUrl)).append("\n");
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

