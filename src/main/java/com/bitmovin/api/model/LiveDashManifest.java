package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveDashManifest
 */

public class LiveDashManifest {
  @JsonProperty("manifestId")
  private String manifestId;

  @JsonProperty("timeshift")
  private Double timeshift;

  @JsonProperty("liveEdgeOffset")
  private Double liveEdgeOffset;


  /**
   * Dash manifest ids
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


  /**
   * Live edge offset in seconds
   * @return liveEdgeOffset
  **/
  public Double getLiveEdgeOffset() {
    return liveEdgeOffset;
  }

  public void setLiveEdgeOffset(Double liveEdgeOffset) {
    this.liveEdgeOffset = liveEdgeOffset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveDashManifest liveDashManifest = (LiveDashManifest) o;
    return Objects.equals(this.manifestId, liveDashManifest.manifestId) &&
        Objects.equals(this.timeshift, liveDashManifest.timeshift) &&
        Objects.equals(this.liveEdgeOffset, liveDashManifest.liveEdgeOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manifestId, timeshift, liveEdgeOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveDashManifest {\n");
    
    sb.append("    manifestId: ").append(toIndentedString(manifestId)).append("\n");
    sb.append("    timeshift: ").append(toIndentedString(timeshift)).append("\n");
    sb.append("    liveEdgeOffset: ").append(toIndentedString(liveEdgeOffset)).append("\n");
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

