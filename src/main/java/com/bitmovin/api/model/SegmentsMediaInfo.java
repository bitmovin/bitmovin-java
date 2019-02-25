package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BasicMediaInfo;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SegmentsMediaInfo
 */

public class SegmentsMediaInfo extends BasicMediaInfo {
  @JsonProperty("segmentPath")
  private String segmentPath;

  @JsonProperty("encodingId")
  private String encodingId;

  @JsonProperty("streamId")
  private String streamId;

  @JsonProperty("muxingId")
  private String muxingId;

  @JsonProperty("drmId")
  private String drmId;

  @JsonProperty("startSegmentNumber")
  private Long startSegmentNumber;

  @JsonProperty("endSegmentNumber")
  private Long endSegmentNumber;


  /**
   * Path to segments.
   * @return segmentPath
  **/
  public String getSegmentPath() {
    return segmentPath;
  }

  public void setSegmentPath(String segmentPath) {
    this.segmentPath = segmentPath;
  }


  /**
   * Id of the encoding.
   * @return encodingId
  **/
  public String getEncodingId() {
    return encodingId;
  }

  public void setEncodingId(String encodingId) {
    this.encodingId = encodingId;
  }


  /**
   * Id of the stream.
   * @return streamId
  **/
  public String getStreamId() {
    return streamId;
  }

  public void setStreamId(String streamId) {
    this.streamId = streamId;
  }


  /**
   * Id of the muxing.
   * @return muxingId
  **/
  public String getMuxingId() {
    return muxingId;
  }

  public void setMuxingId(String muxingId) {
    this.muxingId = muxingId;
  }


  /**
   * Id of the DRM.
   * @return drmId
  **/
  public String getDrmId() {
    return drmId;
  }

  public void setDrmId(String drmId) {
    this.drmId = drmId;
  }


  /**
   * Number of the first segment. Default is 0.
   * @return startSegmentNumber
  **/
  public Long getStartSegmentNumber() {
    return startSegmentNumber;
  }

  public void setStartSegmentNumber(Long startSegmentNumber) {
    this.startSegmentNumber = startSegmentNumber;
  }


  /**
   * Number of the last segment. Default is the last one that was encoded.
   * @return endSegmentNumber
  **/
  public Long getEndSegmentNumber() {
    return endSegmentNumber;
  }

  public void setEndSegmentNumber(Long endSegmentNumber) {
    this.endSegmentNumber = endSegmentNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SegmentsMediaInfo segmentsMediaInfo = (SegmentsMediaInfo) o;
    return Objects.equals(this.segmentPath, segmentsMediaInfo.segmentPath) &&
        Objects.equals(this.encodingId, segmentsMediaInfo.encodingId) &&
        Objects.equals(this.streamId, segmentsMediaInfo.streamId) &&
        Objects.equals(this.muxingId, segmentsMediaInfo.muxingId) &&
        Objects.equals(this.drmId, segmentsMediaInfo.drmId) &&
        Objects.equals(this.startSegmentNumber, segmentsMediaInfo.startSegmentNumber) &&
        Objects.equals(this.endSegmentNumber, segmentsMediaInfo.endSegmentNumber) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segmentPath, encodingId, streamId, muxingId, drmId, startSegmentNumber, endSegmentNumber, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SegmentsMediaInfo {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    segmentPath: ").append(toIndentedString(segmentPath)).append("\n");
    sb.append("    encodingId: ").append(toIndentedString(encodingId)).append("\n");
    sb.append("    streamId: ").append(toIndentedString(streamId)).append("\n");
    sb.append("    muxingId: ").append(toIndentedString(muxingId)).append("\n");
    sb.append("    drmId: ").append(toIndentedString(drmId)).append("\n");
    sb.append("    startSegmentNumber: ").append(toIndentedString(startSegmentNumber)).append("\n");
    sb.append("    endSegmentNumber: ").append(toIndentedString(endSegmentNumber)).append("\n");
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

