package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Trimming
 */

public class Trimming {
  @JsonProperty("offset")
  private Double offset;

  @JsonProperty("duration")
  private Double duration;

  @JsonProperty("ignoreDurationIfInputTooShort")
  private Boolean ignoreDurationIfInputTooShort;

  @JsonProperty("startPicTiming")
  private String startPicTiming;

  @JsonProperty("endPicTiming")
  private String endPicTiming;


  /**
   * Defines the offset in seconds from which the encoding should start, beginning at 0.
   * @return offset
  **/
  public Double getOffset() {
    return offset;
  }

  public void setOffset(Double offset) {
    this.offset = offset;
  }


  /**
   * Defines how many seconds from the input will be encoded.
   * @return duration
  **/
  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }


  /**
   * If set, \&quot;duration\&quot; will be interpreted as a maximum and not cause an error if the input is too short
   * @return ignoreDurationIfInputTooShort
  **/
  public Boolean getIgnoreDurationIfInputTooShort() {
    return ignoreDurationIfInputTooShort;
  }

  public void setIgnoreDurationIfInputTooShort(Boolean ignoreDurationIfInputTooShort) {
    this.ignoreDurationIfInputTooShort = ignoreDurationIfInputTooShort;
  }


  /**
   * Defines the H264 picture timing of the first frame from which the encoding should start. Any defined offset or duration in seconds will be ignored.
   * @return startPicTiming
  **/
  public String getStartPicTiming() {
    return startPicTiming;
  }

  public void setStartPicTiming(String startPicTiming) {
    this.startPicTiming = startPicTiming;
  }


  /**
   * Defines the H264 picture timing of the last frame, that will be included in the encoding. Any defined offset or duration in seconds will be ignored.
   * @return endPicTiming
  **/
  public String getEndPicTiming() {
    return endPicTiming;
  }

  public void setEndPicTiming(String endPicTiming) {
    this.endPicTiming = endPicTiming;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trimming trimming = (Trimming) o;
    return Objects.equals(this.offset, trimming.offset) &&
        Objects.equals(this.duration, trimming.duration) &&
        Objects.equals(this.ignoreDurationIfInputTooShort, trimming.ignoreDurationIfInputTooShort) &&
        Objects.equals(this.startPicTiming, trimming.startPicTiming) &&
        Objects.equals(this.endPicTiming, trimming.endPicTiming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, duration, ignoreDurationIfInputTooShort, startPicTiming, endPicTiming);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Trimming {\n");
    
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    ignoreDurationIfInputTooShort: ").append(toIndentedString(ignoreDurationIfInputTooShort)).append("\n");
    sb.append("    startPicTiming: ").append(toIndentedString(startPicTiming)).append("\n");
    sb.append("    endPicTiming: ").append(toIndentedString(endPicTiming)).append("\n");
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

