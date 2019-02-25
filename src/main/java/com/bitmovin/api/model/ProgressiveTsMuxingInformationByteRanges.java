package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ProgressiveTsMuxingInformationByteRanges
 */

public class ProgressiveTsMuxingInformationByteRanges {
  @JsonProperty("segmentNumber")
  private Integer segmentNumber;

  @JsonProperty("startBytes")
  private Long startBytes;

  @JsonProperty("endBytes")
  private Long endBytes;

  @JsonProperty("duration")
  private Double duration;


  /**
   * Number of the segment (starting at 0)
   * @return segmentNumber
  **/
  public Integer getSegmentNumber() {
    return segmentNumber;
  }

  public void setSegmentNumber(Integer segmentNumber) {
    this.segmentNumber = segmentNumber;
  }


  /**
   * The position of the first byte of the segment
   * @return startBytes
  **/
  public Long getStartBytes() {
    return startBytes;
  }

  public void setStartBytes(Long startBytes) {
    this.startBytes = startBytes;
  }


  /**
   * The position of the last byte of the segment
   * @return endBytes
  **/
  public Long getEndBytes() {
    return endBytes;
  }

  public void setEndBytes(Long endBytes) {
    this.endBytes = endBytes;
  }


  /**
   * The duration of the segment in seconds
   * @return duration
  **/
  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgressiveTsMuxingInformationByteRanges progressiveTsMuxingInformationByteRanges = (ProgressiveTsMuxingInformationByteRanges) o;
    return Objects.equals(this.segmentNumber, progressiveTsMuxingInformationByteRanges.segmentNumber) &&
        Objects.equals(this.startBytes, progressiveTsMuxingInformationByteRanges.startBytes) &&
        Objects.equals(this.endBytes, progressiveTsMuxingInformationByteRanges.endBytes) &&
        Objects.equals(this.duration, progressiveTsMuxingInformationByteRanges.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segmentNumber, startBytes, endBytes, duration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgressiveTsMuxingInformationByteRanges {\n");
    
    sb.append("    segmentNumber: ").append(toIndentedString(segmentNumber)).append("\n");
    sb.append("    startBytes: ").append(toIndentedString(startBytes)).append("\n");
    sb.append("    endBytes: ").append(toIndentedString(endBytes)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

