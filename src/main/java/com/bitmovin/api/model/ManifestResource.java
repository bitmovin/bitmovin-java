package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ManifestResource
 */

public class ManifestResource {
  @JsonProperty("manifestId")
  private String manifestId;


  /**
   * Id of the manifest resource
   * @return manifestId
  **/
  public String getManifestId() {
    return manifestId;
  }

  public void setManifestId(String manifestId) {
    this.manifestId = manifestId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManifestResource manifestResource = (ManifestResource) o;
    return Objects.equals(this.manifestId, manifestResource.manifestId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manifestId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestResource {\n");
    
    sb.append("    manifestId: ").append(toIndentedString(manifestId)).append("\n");
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

