package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.FragmentedMp4MuxingManifestType;
import com.bitmovin.api.model.Ignoring;
import com.bitmovin.api.model.InternalChunkLength;
import com.bitmovin.api.model.Muxing;
import com.bitmovin.api.model.MuxingStream;
import com.bitmovin.api.model.MuxingType;
import com.bitmovin.api.model.StreamConditionsMode;
import com.bitmovin.api.model.TimeCode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Mp4Muxing
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Mp4Muxing extends Muxing {
  @JsonProperty("filename")
  private String filename;

  @JsonProperty("fragmentDuration")
  private Integer fragmentDuration;

  @JsonProperty("timeCode")
  private TimeCode timeCode = null;

  @JsonProperty("fragmentedMP4MuxingManifestType")
  private FragmentedMp4MuxingManifestType fragmentedMP4MuxingManifestType = null;

  @JsonProperty("internalChunkLength")
  private InternalChunkLength internalChunkLength = null;


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
   *  Duration of fragments in milliseconds. Required for Fragmented MP4 Muxing (for Smooth Streaming or DASH On-Demand). Not setting this will result in unfragmented mp4.
   * @return fragmentDuration
  **/
  public Integer getFragmentDuration() {
    return fragmentDuration;
  }

  public void setFragmentDuration(Integer fragmentDuration) {
    this.fragmentDuration = fragmentDuration;
  }


  /**
   * Get timeCode
   * @return timeCode
  **/
  public TimeCode getTimeCode() {
    return timeCode;
  }

  public void setTimeCode(TimeCode timeCode) {
    this.timeCode = timeCode;
  }


  /**
   * Get fragmentedMP4MuxingManifestType
   * @return fragmentedMP4MuxingManifestType
  **/
  public FragmentedMp4MuxingManifestType getFragmentedMP4MuxingManifestType() {
    return fragmentedMP4MuxingManifestType;
  }

  public void setFragmentedMP4MuxingManifestType(FragmentedMp4MuxingManifestType fragmentedMP4MuxingManifestType) {
    this.fragmentedMP4MuxingManifestType = fragmentedMP4MuxingManifestType;
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
    Mp4Muxing mp4Muxing = (Mp4Muxing) o;
    return Objects.equals(this.filename, mp4Muxing.filename) &&
        Objects.equals(this.fragmentDuration, mp4Muxing.fragmentDuration) &&
        Objects.equals(this.timeCode, mp4Muxing.timeCode) &&
        Objects.equals(this.fragmentedMP4MuxingManifestType, mp4Muxing.fragmentedMP4MuxingManifestType) &&
        Objects.equals(this.internalChunkLength, mp4Muxing.internalChunkLength) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, fragmentDuration, timeCode, fragmentedMP4MuxingManifestType, internalChunkLength, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mp4Muxing {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    fragmentDuration: ").append(toIndentedString(fragmentDuration)).append("\n");
    sb.append("    timeCode: ").append(toIndentedString(timeCode)).append("\n");
    sb.append("    fragmentedMP4MuxingManifestType: ").append(toIndentedString(fragmentedMP4MuxingManifestType)).append("\n");
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

