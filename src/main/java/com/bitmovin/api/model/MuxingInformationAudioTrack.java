package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * MuxingInformationAudioTrack
 */

public class MuxingInformationAudioTrack {
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

  @JsonProperty("sampleRate")
  private Integer sampleRate;

  @JsonProperty("channels")
  private Integer channels;

  @JsonProperty("duration")
  private Double duration;

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
   * The bitrate of the audio track
   * @return bitRate
  **/
  public Long getBitRate() {
    return bitRate;
  }

  /**
   * Get rate
   * @return rate
  **/
  public Long getRate() {
    return rate;
  }

  /**
   * The sampling rate of the audio stream
   * @return sampleRate
  **/
  public Integer getSampleRate() {
    return sampleRate;
  }

  /**
   * The number of channels in this audio stream
   * @return channels
  **/
  public Integer getChannels() {
    return channels;
  }

  /**
   * TODO add description
   * @return duration
  **/
  public Double getDuration() {
    return duration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MuxingInformationAudioTrack muxingInformationAudioTrack = (MuxingInformationAudioTrack) o;
    return Objects.equals(this.index, muxingInformationAudioTrack.index) &&
        Objects.equals(this.codec, muxingInformationAudioTrack.codec) &&
        Objects.equals(this.codecIso, muxingInformationAudioTrack.codecIso) &&
        Objects.equals(this.bitRate, muxingInformationAudioTrack.bitRate) &&
        Objects.equals(this.rate, muxingInformationAudioTrack.rate) &&
        Objects.equals(this.sampleRate, muxingInformationAudioTrack.sampleRate) &&
        Objects.equals(this.channels, muxingInformationAudioTrack.channels) &&
        Objects.equals(this.duration, muxingInformationAudioTrack.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, codec, codecIso, bitRate, rate, sampleRate, channels, duration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MuxingInformationAudioTrack {\n");
    
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
    sb.append("    codecIso: ").append(toIndentedString(codecIso)).append("\n");
    sb.append("    bitRate: ").append(toIndentedString(bitRate)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    sampleRate: ").append(toIndentedString(sampleRate)).append("\n");
    sb.append("    channels: ").append(toIndentedString(channels)).append("\n");
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

