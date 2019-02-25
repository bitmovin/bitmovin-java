package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * MuxingInformationVideoTrack
 */

public class MuxingInformationVideoTrack {
  @JsonProperty("index")
  private Integer index;

  @JsonProperty("codec")
  private String codec;

  @JsonProperty("codecIso")
  private String codecIso;

  @JsonProperty("bitRate")
  private Long bitRate;

  @JsonProperty("rate")
  private Long rate;

  @JsonProperty("pixelFormat")
  private String pixelFormat;

  @JsonProperty("frameMode")
  private String frameMode;

  @JsonProperty("frameWidth")
  private Integer frameWidth;

  @JsonProperty("frameHeight")
  private Integer frameHeight;

  @JsonProperty("frameRate")
  private String frameRate;

  @JsonProperty("startTime")
  private Double startTime;

  @JsonProperty("duration")
  private Double duration;

  @JsonProperty("numberOfFrames")
  private Long numberOfFrames;

  @JsonProperty("aspectRatio")
  private String aspectRatio;

  /**
   * The stream index in the container
   * @return index
  **/
  public Integer getIndex() {
    return index;
  }

  /**
   * The codec used for the track
   * @return codec
  **/
  public String getCodec() {
    return codec;
  }

  /**
   * The codec string of the track
   * @return codecIso
  **/
  public String getCodecIso() {
    return codecIso;
  }

  /**
   * The bitrate of the video track
   * @return bitRate
  **/
  public Long getBitRate() {
    return bitRate;
  }

  /**
   * TODO add description
   * @return rate
  **/
  public Long getRate() {
    return rate;
  }

  /**
   * The pixel format used
   * @return pixelFormat
  **/
  public String getPixelFormat() {
    return pixelFormat;
  }

  /**
   * The frame mode (e.g. progressive)
   * @return frameMode
  **/
  public String getFrameMode() {
    return frameMode;
  }

  /**
   * The width of the frame in pixel
   * @return frameWidth
  **/
  public Integer getFrameWidth() {
    return frameWidth;
  }

  /**
   * The height of the frame in pixel
   * @return frameHeight
  **/
  public Integer getFrameHeight() {
    return frameHeight;
  }

  /**
   * The frame rate of the stream in fractional format
   * @return frameRate
  **/
  public String getFrameRate() {
    return frameRate;
  }

  /**
   * The start time in seconds
   * @return startTime
  **/
  public Double getStartTime() {
    return startTime;
  }

  /**
   * The duration in seconds
   * @return duration
  **/
  public Double getDuration() {
    return duration;
  }

  /**
   * The number of frames of that video track
   * @return numberOfFrames
  **/
  public Long getNumberOfFrames() {
    return numberOfFrames;
  }

  /**
   * The aspect ratio of the stream
   * @return aspectRatio
  **/
  public String getAspectRatio() {
    return aspectRatio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MuxingInformationVideoTrack muxingInformationVideoTrack = (MuxingInformationVideoTrack) o;
    return Objects.equals(this.index, muxingInformationVideoTrack.index) &&
        Objects.equals(this.codec, muxingInformationVideoTrack.codec) &&
        Objects.equals(this.codecIso, muxingInformationVideoTrack.codecIso) &&
        Objects.equals(this.bitRate, muxingInformationVideoTrack.bitRate) &&
        Objects.equals(this.rate, muxingInformationVideoTrack.rate) &&
        Objects.equals(this.pixelFormat, muxingInformationVideoTrack.pixelFormat) &&
        Objects.equals(this.frameMode, muxingInformationVideoTrack.frameMode) &&
        Objects.equals(this.frameWidth, muxingInformationVideoTrack.frameWidth) &&
        Objects.equals(this.frameHeight, muxingInformationVideoTrack.frameHeight) &&
        Objects.equals(this.frameRate, muxingInformationVideoTrack.frameRate) &&
        Objects.equals(this.startTime, muxingInformationVideoTrack.startTime) &&
        Objects.equals(this.duration, muxingInformationVideoTrack.duration) &&
        Objects.equals(this.numberOfFrames, muxingInformationVideoTrack.numberOfFrames) &&
        Objects.equals(this.aspectRatio, muxingInformationVideoTrack.aspectRatio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, codec, codecIso, bitRate, rate, pixelFormat, frameMode, frameWidth, frameHeight, frameRate, startTime, duration, numberOfFrames, aspectRatio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MuxingInformationVideoTrack {\n");
    
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
    sb.append("    codecIso: ").append(toIndentedString(codecIso)).append("\n");
    sb.append("    bitRate: ").append(toIndentedString(bitRate)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    pixelFormat: ").append(toIndentedString(pixelFormat)).append("\n");
    sb.append("    frameMode: ").append(toIndentedString(frameMode)).append("\n");
    sb.append("    frameWidth: ").append(toIndentedString(frameWidth)).append("\n");
    sb.append("    frameHeight: ").append(toIndentedString(frameHeight)).append("\n");
    sb.append("    frameRate: ").append(toIndentedString(frameRate)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    numberOfFrames: ").append(toIndentedString(numberOfFrames)).append("\n");
    sb.append("    aspectRatio: ").append(toIndentedString(aspectRatio)).append("\n");
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

