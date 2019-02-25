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
 * TimecodeTrackTrimmingInputStream
 */

public class TimecodeTrackTrimmingInputStream extends BitmovinResource {
  @JsonProperty("inputStreamId")
  private String inputStreamId;

  @JsonProperty("startTimeCode")
  private String startTimeCode;

  @JsonProperty("endTimeCode")
  private String endTimeCode;


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
   * Defines the timecode, in SMPTE-12M format, of the frame from which the encoding should start. The frame indicated by this value will be included in the encoding
   * @return startTimeCode
  **/
  public String getStartTimeCode() {
    return startTimeCode;
  }

  public void setStartTimeCode(String startTimeCode) {
    this.startTimeCode = startTimeCode;
  }


  /**
   * Defines the timecode, in SMPTE-12M format, of the frame at which the encoding should stop. The frame indicated by this value will be included in the encoding
   * @return endTimeCode
  **/
  public String getEndTimeCode() {
    return endTimeCode;
  }

  public void setEndTimeCode(String endTimeCode) {
    this.endTimeCode = endTimeCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimecodeTrackTrimmingInputStream timecodeTrackTrimmingInputStream = (TimecodeTrackTrimmingInputStream) o;
    return Objects.equals(this.inputStreamId, timecodeTrackTrimmingInputStream.inputStreamId) &&
        Objects.equals(this.startTimeCode, timecodeTrackTrimmingInputStream.startTimeCode) &&
        Objects.equals(this.endTimeCode, timecodeTrackTrimmingInputStream.endTimeCode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStreamId, startTimeCode, endTimeCode, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimecodeTrackTrimmingInputStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputStreamId: ").append(toIndentedString(inputStreamId)).append("\n");
    sb.append("    startTimeCode: ").append(toIndentedString(startTimeCode)).append("\n");
    sb.append("    endTimeCode: ").append(toIndentedString(endTimeCode)).append("\n");
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

