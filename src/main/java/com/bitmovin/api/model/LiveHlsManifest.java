package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveHlsManifest
 */

public class LiveHlsManifest {
  @JsonProperty("manifestId")
  private String manifestId;

  @JsonProperty("timeshift")
  private Double timeshift;


  /**
   * Hls manifest ids
   * @return manifestId
  **/
  public String getManifestId() {
    return manifestId;
  }

  public void setManifestId(String manifestId) {
    this.manifestId = manifestId;
  }


  /**
   * Timeshift in seconds
   * @return timeshift
  **/
  public Double getTimeshift() {
    return timeshift;
  }

  public void setTimeshift(Double timeshift) {
    this.timeshift = timeshift;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveHlsManifest liveHlsManifest = (LiveHlsManifest) o;
    return Objects.equals(this.manifestId, liveHlsManifest.manifestId) &&
        Objects.equals(this.timeshift, liveHlsManifest.timeshift);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manifestId, timeshift);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveHlsManifest {\n");
    
    sb.append("    manifestId: ").append(toIndentedString(manifestId)).append("\n");
    sb.append("    timeshift: ").append(toIndentedString(timeshift)).append("\n");
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

