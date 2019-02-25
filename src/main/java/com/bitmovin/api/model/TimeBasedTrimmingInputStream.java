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
 * TimeBasedTrimmingInputStream
 */

public class TimeBasedTrimmingInputStream extends BitmovinResource {
  @JsonProperty("inputStreamId")
  private String inputStreamId;

  @JsonProperty("offset")
  private Double offset;

  @JsonProperty("duration")
  private Double duration;


  /**
   * The id of the ingest input stream that should be trimmed
   * @return inputStreamId
  **/
  public String getInputStreamId() {
    return inputStreamId;
  }

  public void setInputStreamId(String inputStreamId) {
    this.inputStreamId = inputStreamId;
  }


  /**
   * Defines the offset in seconds at which the encoding should start, beginning at 0. The frame indicated by this value will be included in the encoding
   * minimum: 0
   * @return offset
  **/
  public Double getOffset() {
    return offset;
  }

  public void setOffset(Double offset) {
    this.offset = offset;
  }


  /**
   * Defines how many seconds of the input will be encoded
   * minimum: 0
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
    TimeBasedTrimmingInputStream timeBasedTrimmingInputStream = (TimeBasedTrimmingInputStream) o;
    return Objects.equals(this.inputStreamId, timeBasedTrimmingInputStream.inputStreamId) &&
        Objects.equals(this.offset, timeBasedTrimmingInputStream.offset) &&
        Objects.equals(this.duration, timeBasedTrimmingInputStream.duration) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStreamId, offset, duration, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeBasedTrimmingInputStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputStreamId: ").append(toIndentedString(inputStreamId)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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

