package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.Ignoring;
import com.bitmovin.api.model.MuxingStream;
import com.bitmovin.api.model.MuxingType;
import com.bitmovin.api.model.StreamConditionsMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Muxing
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
  @JsonSubTypes.Type(value = Fmp4Muxing.class, name = "FMP4"),
  @JsonSubTypes.Type(value = Mp4Muxing.class, name = "MP4"),
  @JsonSubTypes.Type(value = TsMuxing.class, name = "TS"),
  @JsonSubTypes.Type(value = WebmMuxing.class, name = "WEBM"),
  @JsonSubTypes.Type(value = Mp3Muxing.class, name = "MP3"),
  @JsonSubTypes.Type(value = ProgressiveWebmMuxing.class, name = "PROGRESSIVE_WEBM"),
  @JsonSubTypes.Type(value = ProgressiveMovMuxing.class, name = "PROGRESSIVE_MOV"),
  @JsonSubTypes.Type(value = ProgressiveTsMuxing.class, name = "PROGRESSIVE_TS"),
  @JsonSubTypes.Type(value = BroadcastTsMuxing.class, name = "BROADCAST_TS"),
})

public class Muxing extends BitmovinResource {
  @JsonProperty("streams")
  private List<MuxingStream> streams = new ArrayList<MuxingStream>();

  @JsonProperty("outputs")
  private List<EncodingOutput> outputs;

  @JsonProperty("type")
  private MuxingType type = null;

  @JsonProperty("avgBitrate")
  private Integer avgBitrate;

  @JsonProperty("minBitrate")
  private Integer minBitrate;

  @JsonProperty("maxBitrate")
  private Integer maxBitrate;

  @JsonProperty("ignoredBy")
  private List<Ignoring> ignoredBy;

  @JsonProperty("streamConditionsMode")
  private StreamConditionsMode streamConditionsMode = null;


  public Muxing addStreamsItem(MuxingStream streamsItem) {
    this.streams.add(streamsItem);
    return this;
  }

  /**
   * Get streams
   * @return streams
  **/
  public List<MuxingStream> getStreams() {
    return streams;
  }

  public void setStreams(List<MuxingStream> streams) {
    this.streams = streams;
  }


  public Muxing addOutputsItem(EncodingOutput outputsItem) {
    if (this.outputs == null) {
      this.outputs = new ArrayList<>();
    }
    this.outputs.add(outputsItem);
    return this;
  }

  /**
   * Get outputs
   * @return outputs
  **/
  public List<EncodingOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<EncodingOutput> outputs) {
    this.outputs = outputs;
  }

  /**
   * Type of the muxing
   * @return type
  **/
  public MuxingType getType() {
    return type;
  }

  /**
   * Average bitrate. Available after encoding finishes.
   * @return avgBitrate
  **/
  public Integer getAvgBitrate() {
    return avgBitrate;
  }

  /**
   * Min bitrate. Available after encoding finishes.
   * @return minBitrate
  **/
  public Integer getMinBitrate() {
    return minBitrate;
  }

  /**
   * Max bitrate. Available after encoding finishes.
   * @return maxBitrate
  **/
  public Integer getMaxBitrate() {
    return maxBitrate;
  }

  /**
   * If this is set and contains objects, then this muxing has been ignored during the encoding process
   * @return ignoredBy
  **/
  public List<Ignoring> getIgnoredBy() {
    return ignoredBy;
  }


  /**
   * Specifies how to handle streams that don&#39;t fulfill stream conditions
   * @return streamConditionsMode
  **/
  public StreamConditionsMode getStreamConditionsMode() {
    return streamConditionsMode;
  }

  public void setStreamConditionsMode(StreamConditionsMode streamConditionsMode) {
    this.streamConditionsMode = streamConditionsMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Muxing muxing = (Muxing) o;
    return Objects.equals(this.streams, muxing.streams) &&
        Objects.equals(this.outputs, muxing.outputs) &&
        Objects.equals(this.type, muxing.type) &&
        Objects.equals(this.avgBitrate, muxing.avgBitrate) &&
        Objects.equals(this.minBitrate, muxing.minBitrate) &&
        Objects.equals(this.maxBitrate, muxing.maxBitrate) &&
        Objects.equals(this.ignoredBy, muxing.ignoredBy) &&
        Objects.equals(this.streamConditionsMode, muxing.streamConditionsMode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streams, outputs, type, avgBitrate, minBitrate, maxBitrate, ignoredBy, streamConditionsMode, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Muxing {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    streams: ").append(toIndentedString(streams)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    avgBitrate: ").append(toIndentedString(avgBitrate)).append("\n");
    sb.append("    minBitrate: ").append(toIndentedString(minBitrate)).append("\n");
    sb.append("    maxBitrate: ").append(toIndentedString(maxBitrate)).append("\n");
    sb.append("    ignoredBy: ").append(toIndentedString(ignoredBy)).append("\n");
    sb.append("    streamConditionsMode: ").append(toIndentedString(streamConditionsMode)).append("\n");
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

