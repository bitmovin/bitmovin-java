package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DashMuxingType;
import com.bitmovin.api.model.DashRepresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashSegmentedRepresentation
 */

public class DashSegmentedRepresentation extends DashRepresentation {
  @JsonProperty("type")
  private DashMuxingType type = null;

  @JsonProperty("segmentPath")
  private String segmentPath;

  @JsonProperty("startSegmentNumber")
  private Long startSegmentNumber;

  @JsonProperty("endSegmentNumber")
  private Long endSegmentNumber;

  @JsonProperty("startKeyframeId")
  private String startKeyframeId;

  @JsonProperty("endKeyframeId")
  private String endKeyframeId;


  /**
   * Get type
   * @return type
  **/
  public DashMuxingType getType() {
    return type;
  }

  public void setType(DashMuxingType type) {
    this.type = type;
  }


  /**
   * Path to segments
   * @return segmentPath
  **/
  public String getSegmentPath() {
    return segmentPath;
  }

  public void setSegmentPath(String segmentPath) {
    this.segmentPath = segmentPath;
  }


  /**
   * Number of the first segment
   * @return startSegmentNumber
  **/
  public Long getStartSegmentNumber() {
    return startSegmentNumber;
  }

  public void setStartSegmentNumber(Long startSegmentNumber) {
    this.startSegmentNumber = startSegmentNumber;
  }


  /**
   * Number of the last segment. Default is the last one that was encoded
   * @return endSegmentNumber
  **/
  public Long getEndSegmentNumber() {
    return endSegmentNumber;
  }

  public void setEndSegmentNumber(Long endSegmentNumber) {
    this.endSegmentNumber = endSegmentNumber;
  }


  /**
   * Id of the Keyframe to start with
   * @return startKeyframeId
  **/
  public String getStartKeyframeId() {
    return startKeyframeId;
  }

  public void setStartKeyframeId(String startKeyframeId) {
    this.startKeyframeId = startKeyframeId;
  }


  /**
   * Id of the Keyframe to end with
   * @return endKeyframeId
  **/
  public String getEndKeyframeId() {
    return endKeyframeId;
  }

  public void setEndKeyframeId(String endKeyframeId) {
    this.endKeyframeId = endKeyframeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashSegmentedRepresentation dashSegmentedRepresentation = (DashSegmentedRepresentation) o;
    return Objects.equals(this.type, dashSegmentedRepresentation.type) &&
        Objects.equals(this.segmentPath, dashSegmentedRepresentation.segmentPath) &&
        Objects.equals(this.startSegmentNumber, dashSegmentedRepresentation.startSegmentNumber) &&
        Objects.equals(this.endSegmentNumber, dashSegmentedRepresentation.endSegmentNumber) &&
        Objects.equals(this.startKeyframeId, dashSegmentedRepresentation.startKeyframeId) &&
        Objects.equals(this.endKeyframeId, dashSegmentedRepresentation.endKeyframeId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, segmentPath, startSegmentNumber, endSegmentNumber, startKeyframeId, endKeyframeId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashSegmentedRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    segmentPath: ").append(toIndentedString(segmentPath)).append("\n");
    sb.append("    startSegmentNumber: ").append(toIndentedString(startSegmentNumber)).append("\n");
    sb.append("    endSegmentNumber: ").append(toIndentedString(endSegmentNumber)).append("\n");
    sb.append("    startKeyframeId: ").append(toIndentedString(startKeyframeId)).append("\n");
    sb.append("    endKeyframeId: ").append(toIndentedString(endKeyframeId)).append("\n");
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

