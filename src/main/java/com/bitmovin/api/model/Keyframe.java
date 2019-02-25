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
 * Keyframe
 */

public class Keyframe extends BitmovinResource {
  @JsonProperty("time")
  private Double time;

  @JsonProperty("segmentCut")
  private Boolean segmentCut = true;


  /**
   * Time in seconds where the keyframe should be inserted
   * @return time
  **/
  public Double getTime() {
    return time;
  }

  public void setTime(Double time) {
    this.time = time;
  }


  /**
   * Instructs the encoder to cut the segment at this position
   * @return segmentCut
  **/
  public Boolean getSegmentCut() {
    return segmentCut;
  }

  public void setSegmentCut(Boolean segmentCut) {
    this.segmentCut = segmentCut;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Keyframe keyframe = (Keyframe) o;
    return Objects.equals(this.time, keyframe.time) &&
        Objects.equals(this.segmentCut, keyframe.segmentCut) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, segmentCut, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Keyframe {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    segmentCut: ").append(toIndentedString(segmentCut)).append("\n");
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

