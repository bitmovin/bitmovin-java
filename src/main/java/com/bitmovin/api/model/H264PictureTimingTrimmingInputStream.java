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
 * H264PictureTimingTrimmingInputStream
 */

public class H264PictureTimingTrimmingInputStream extends BitmovinResource {
  @JsonProperty("inputStreamId")
  private String inputStreamId;

  @JsonProperty("startPicTiming")
  private String startPicTiming;

  @JsonProperty("endPicTiming")
  private String endPicTiming;


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
   * Defines the H264 SEI picture timing, as specified in ISO/IEC 14496-10:2008, of the frame from which the encoding should start. The frame indicated by this value will be included in the encoding
   * @return startPicTiming
  **/
  public String getStartPicTiming() {
    return startPicTiming;
  }

  public void setStartPicTiming(String startPicTiming) {
    this.startPicTiming = startPicTiming;
  }


  /**
   * Defines the H264 SEI picture timing, as specified in ISO/IEC 14496-10:2008, of the frame at which the encoding should stop. The frame indicated by this value will be included in the encoding
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
    H264PictureTimingTrimmingInputStream h264PictureTimingTrimmingInputStream = (H264PictureTimingTrimmingInputStream) o;
    return Objects.equals(this.inputStreamId, h264PictureTimingTrimmingInputStream.inputStreamId) &&
        Objects.equals(this.startPicTiming, h264PictureTimingTrimmingInputStream.startPicTiming) &&
        Objects.equals(this.endPicTiming, h264PictureTimingTrimmingInputStream.endPicTiming) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStreamId, startPicTiming, endPicTiming, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class H264PictureTimingTrimmingInputStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputStreamId: ").append(toIndentedString(inputStreamId)).append("\n");
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

