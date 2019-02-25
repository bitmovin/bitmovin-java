package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.SegmentsMediaInfo;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ClosedCaptionsMediaInfo
 */

public class ClosedCaptionsMediaInfo extends SegmentsMediaInfo {
  @JsonProperty("instreamId")
  private String instreamId;

  @JsonProperty("forced")
  private Boolean forced;


  /**
   * Specifies a Rendition within the segments in the Media Playlist. (See HLS spec 4.3.4.1. EXT-X-MEDIA INSTREAM-ID)
   * @return instreamId
  **/
  public String getInstreamId() {
    return instreamId;
  }

  public void setInstreamId(String instreamId) {
    this.instreamId = instreamId;
  }


  /**
   * A value of true indicates that the Rendition contains content which is considered essential to play.
   * @return forced
  **/
  public Boolean getForced() {
    return forced;
  }

  public void setForced(Boolean forced) {
    this.forced = forced;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClosedCaptionsMediaInfo closedCaptionsMediaInfo = (ClosedCaptionsMediaInfo) o;
    return Objects.equals(this.instreamId, closedCaptionsMediaInfo.instreamId) &&
        Objects.equals(this.forced, closedCaptionsMediaInfo.forced) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instreamId, forced, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClosedCaptionsMediaInfo {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    instreamId: ").append(toIndentedString(instreamId)).append("\n");
    sb.append("    forced: ").append(toIndentedString(forced)).append("\n");
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

