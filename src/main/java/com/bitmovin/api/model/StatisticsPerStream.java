package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.PsnrPerStreamMode;
import com.bitmovin.api.model.StatisticsPerTitleStream;
import com.bitmovin.api.model.StatisticsResolution;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StatisticsPerStream
 */

public class StatisticsPerStream {
  @JsonProperty("streamId")
  private String streamId;

  @JsonProperty("codecConfigId")
  private String codecConfigId;

  @JsonProperty("multiplicator")
  private Double multiplicator;

  @JsonProperty("encodedBytes")
  private Long encodedBytes;

  @JsonProperty("encodedSeconds")
  private Double encodedSeconds;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;

  @JsonProperty("width")
  private Long width;

  @JsonProperty("height")
  private Long height;

  @JsonProperty("rate")
  private Long rate;

  @JsonProperty("bitrate")
  private Long bitrate;

  @JsonProperty("codec")
  private CodecConfigType codec = null;

  @JsonProperty("resolution")
  private StatisticsResolution resolution = null;

  @JsonProperty("encodingMode")
  private EncodingMode encodingMode = null;

  @JsonProperty("encodingModeMultiplicator")
  private Double encodingModeMultiplicator;

  @JsonProperty("perTitleResultStream")
  private StatisticsPerTitleStream perTitleResultStream = null;

  @JsonProperty("perTitleMultiplicator")
  private Double perTitleMultiplicator;

  @JsonProperty("psnrMode")
  private PsnrPerStreamMode psnrMode = null;

  @JsonProperty("psnrMultiplicator")
  private Double psnrMultiplicator;


  /**
   * ID of the stream
   * @return streamId
  **/
  public String getStreamId() {
    return streamId;
  }

  public void setStreamId(String streamId) {
    this.streamId = streamId;
  }


  /**
   * ID of the condec configuration
   * @return codecConfigId
  **/
  public String getCodecConfigId() {
    return codecConfigId;
  }

  public void setCodecConfigId(String codecConfigId) {
    this.codecConfigId = codecConfigId;
  }


  /**
   * Multiplier for the encoded minutes. Depends on muxing type.
   * @return multiplicator
  **/
  public Double getMultiplicator() {
    return multiplicator;
  }

  public void setMultiplicator(Double multiplicator) {
    this.multiplicator = multiplicator;
  }


  /**
   * Encoded bytes.
   * @return encodedBytes
  **/
  public Long getEncodedBytes() {
    return encodedBytes;
  }

  public void setEncodedBytes(Long encodedBytes) {
    this.encodedBytes = encodedBytes;
  }


  /**
   * Length of the stream.
   * @return encodedSeconds
  **/
  public Double getEncodedSeconds() {
    return encodedSeconds;
  }

  public void setEncodedSeconds(Double encodedSeconds) {
    this.encodedSeconds = encodedSeconds;
  }


  /**
   * Minutes you will be charged for (billableMinutes &#x3D; encodedSeconds * multiplicator)
   * @return billableMinutes
  **/
  public Double getBillableMinutes() {
    return billableMinutes;
  }

  public void setBillableMinutes(Double billableMinutes) {
    this.billableMinutes = billableMinutes;
  }


  /**
   * Video width, only if video stream
   * @return width
  **/
  public Long getWidth() {
    return width;
  }

  public void setWidth(Long width) {
    this.width = width;
  }


  /**
   * Video height, only if video stream
   * @return height
  **/
  public Long getHeight() {
    return height;
  }

  public void setHeight(Long height) {
    this.height = height;
  }


  /**
   * If it&#39; a video stream this value is the FPS, for audio it&#39;s the sample rate.
   * @return rate
  **/
  public Long getRate() {
    return rate;
  }

  public void setRate(Long rate) {
    this.rate = rate;
  }


  /**
   * Bitrate of the stream
   * @return bitrate
  **/
  public Long getBitrate() {
    return bitrate;
  }

  public void setBitrate(Long bitrate) {
    this.bitrate = bitrate;
  }


  /**
   * Get codec
   * @return codec
  **/
  public CodecConfigType getCodec() {
    return codec;
  }

  public void setCodec(CodecConfigType codec) {
    this.codec = codec;
  }


  /**
   * Get resolution
   * @return resolution
  **/
  public StatisticsResolution getResolution() {
    return resolution;
  }

  public void setResolution(StatisticsResolution resolution) {
    this.resolution = resolution;
  }


  /**
   * Get encodingMode
   * @return encodingMode
  **/
  public EncodingMode getEncodingMode() {
    return encodingMode;
  }

  public void setEncodingMode(EncodingMode encodingMode) {
    this.encodingMode = encodingMode;
  }


  /**
   * The output minutes multiplicator for the given encodingMode
   * @return encodingModeMultiplicator
  **/
  public Double getEncodingModeMultiplicator() {
    return encodingModeMultiplicator;
  }

  public void setEncodingModeMultiplicator(Double encodingModeMultiplicator) {
    this.encodingModeMultiplicator = encodingModeMultiplicator;
  }


  /**
   * Get perTitleResultStream
   * @return perTitleResultStream
  **/
  public StatisticsPerTitleStream getPerTitleResultStream() {
    return perTitleResultStream;
  }

  public void setPerTitleResultStream(StatisticsPerTitleStream perTitleResultStream) {
    this.perTitleResultStream = perTitleResultStream;
  }


  /**
   * The output minutes multiplicator for per-title
   * @return perTitleMultiplicator
  **/
  public Double getPerTitleMultiplicator() {
    return perTitleMultiplicator;
  }

  public void setPerTitleMultiplicator(Double perTitleMultiplicator) {
    this.perTitleMultiplicator = perTitleMultiplicator;
  }


  /**
   * Get psnrMode
   * @return psnrMode
  **/
  public PsnrPerStreamMode getPsnrMode() {
    return psnrMode;
  }

  public void setPsnrMode(PsnrPerStreamMode psnrMode) {
    this.psnrMode = psnrMode;
  }


  /**
   * The output minutes multiplicator for psnr streams
   * @return psnrMultiplicator
  **/
  public Double getPsnrMultiplicator() {
    return psnrMultiplicator;
  }

  public void setPsnrMultiplicator(Double psnrMultiplicator) {
    this.psnrMultiplicator = psnrMultiplicator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticsPerStream statisticsPerStream = (StatisticsPerStream) o;
    return Objects.equals(this.streamId, statisticsPerStream.streamId) &&
        Objects.equals(this.codecConfigId, statisticsPerStream.codecConfigId) &&
        Objects.equals(this.multiplicator, statisticsPerStream.multiplicator) &&
        Objects.equals(this.encodedBytes, statisticsPerStream.encodedBytes) &&
        Objects.equals(this.encodedSeconds, statisticsPerStream.encodedSeconds) &&
        Objects.equals(this.billableMinutes, statisticsPerStream.billableMinutes) &&
        Objects.equals(this.width, statisticsPerStream.width) &&
        Objects.equals(this.height, statisticsPerStream.height) &&
        Objects.equals(this.rate, statisticsPerStream.rate) &&
        Objects.equals(this.bitrate, statisticsPerStream.bitrate) &&
        Objects.equals(this.codec, statisticsPerStream.codec) &&
        Objects.equals(this.resolution, statisticsPerStream.resolution) &&
        Objects.equals(this.encodingMode, statisticsPerStream.encodingMode) &&
        Objects.equals(this.encodingModeMultiplicator, statisticsPerStream.encodingModeMultiplicator) &&
        Objects.equals(this.perTitleResultStream, statisticsPerStream.perTitleResultStream) &&
        Objects.equals(this.perTitleMultiplicator, statisticsPerStream.perTitleMultiplicator) &&
        Objects.equals(this.psnrMode, statisticsPerStream.psnrMode) &&
        Objects.equals(this.psnrMultiplicator, statisticsPerStream.psnrMultiplicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streamId, codecConfigId, multiplicator, encodedBytes, encodedSeconds, billableMinutes, width, height, rate, bitrate, codec, resolution, encodingMode, encodingModeMultiplicator, perTitleResultStream, perTitleMultiplicator, psnrMode, psnrMultiplicator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatisticsPerStream {\n");
    
    sb.append("    streamId: ").append(toIndentedString(streamId)).append("\n");
    sb.append("    codecConfigId: ").append(toIndentedString(codecConfigId)).append("\n");
    sb.append("    multiplicator: ").append(toIndentedString(multiplicator)).append("\n");
    sb.append("    encodedBytes: ").append(toIndentedString(encodedBytes)).append("\n");
    sb.append("    encodedSeconds: ").append(toIndentedString(encodedSeconds)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    bitrate: ").append(toIndentedString(bitrate)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    encodingMode: ").append(toIndentedString(encodingMode)).append("\n");
    sb.append("    encodingModeMultiplicator: ").append(toIndentedString(encodingModeMultiplicator)).append("\n");
    sb.append("    perTitleResultStream: ").append(toIndentedString(perTitleResultStream)).append("\n");
    sb.append("    perTitleMultiplicator: ").append(toIndentedString(perTitleMultiplicator)).append("\n");
    sb.append("    psnrMode: ").append(toIndentedString(psnrMode)).append("\n");
    sb.append("    psnrMultiplicator: ").append(toIndentedString(psnrMultiplicator)).append("\n");
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

