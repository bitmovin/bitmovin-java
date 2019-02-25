package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.Ignoring;
import com.bitmovin.api.model.InternalChunkLength;
import com.bitmovin.api.model.Muxing;
import com.bitmovin.api.model.MuxingStream;
import com.bitmovin.api.model.MuxingType;
import com.bitmovin.api.model.StreamConditionsMode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ProgressiveTsMuxing
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ProgressiveTsMuxing extends Muxing {
  @JsonProperty("segmentLength")
  private Double segmentLength;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("startOffset")
  private Double startOffset;

  @JsonProperty("internalChunkLength")
  private InternalChunkLength internalChunkLength = null;


  /**
   * Length of the segments in seconds
   * @return segmentLength
  **/
  public Double getSegmentLength() {
    return segmentLength;
  }

  public void setSegmentLength(Double segmentLength) {
    this.segmentLength = segmentLength;
  }


  /**
   * Name of the new Video
   * @return filename
  **/
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  /**
   * Offset of MPEG-TS timestamps in seconds. E.g., first packet will start with PTS 900,000 for a 10 seconds offset (90,000 MPEG-TS timescale).
   * @return startOffset
  **/
  public Double getStartOffset() {
    return startOffset;
  }

  public void setStartOffset(Double startOffset) {
    this.startOffset = startOffset;
  }


  /**
   * Modifies the internal chunk length used for chunked encoding
   * @return internalChunkLength
  **/
  public InternalChunkLength getInternalChunkLength() {
    return internalChunkLength;
  }

  public void setInternalChunkLength(InternalChunkLength internalChunkLength) {
    this.internalChunkLength = internalChunkLength;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgressiveTsMuxing progressiveTsMuxing = (ProgressiveTsMuxing) o;
    return Objects.equals(this.segmentLength, progressiveTsMuxing.segmentLength) &&
        Objects.equals(this.filename, progressiveTsMuxing.filename) &&
        Objects.equals(this.startOffset, progressiveTsMuxing.startOffset) &&
        Objects.equals(this.internalChunkLength, progressiveTsMuxing.internalChunkLength) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(segmentLength, filename, startOffset, internalChunkLength, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgressiveTsMuxing {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    segmentLength: ").append(toIndentedString(segmentLength)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    startOffset: ").append(toIndentedString(startOffset)).append("\n");
    sb.append("    internalChunkLength: ").append(toIndentedString(internalChunkLength)).append("\n");
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

