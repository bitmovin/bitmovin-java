package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.MediaStream;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AudioStream
 */

public class AudioStream extends MediaStream {
  @JsonProperty("sampleRate")
  private Integer sampleRate;

  @JsonProperty("bitrate")
  private Long bitrate;

  @JsonProperty("rate")
  private Long rate;

  @JsonProperty("channelFormat")
  private String channelFormat;

  @JsonProperty("language")
  private String language;

  @JsonProperty("hearingImpaired")
  private Boolean hearingImpaired;


  /**
   * Audio sampling rate in Hz
   * @return sampleRate
  **/
  public Integer getSampleRate() {
    return sampleRate;
  }

  public void setSampleRate(Integer sampleRate) {
    this.sampleRate = sampleRate;
  }


  /**
   * Bitrate in bps
   * @return bitrate
  **/
  public Long getBitrate() {
    return bitrate;
  }

  public void setBitrate(Long bitrate) {
    this.bitrate = bitrate;
  }


  /**
   * Bitrate in bps
   * @return rate
  **/
  public Long getRate() {
    return rate;
  }

  public void setRate(Long rate) {
    this.rate = rate;
  }


  /**
   * Audio channel format
   * @return channelFormat
  **/
  public String getChannelFormat() {
    return channelFormat;
  }

  public void setChannelFormat(String channelFormat) {
    this.channelFormat = channelFormat;
  }


  /**
   * Language of the stream
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  /**
   * Hearing impaired support
   * @return hearingImpaired
  **/
  public Boolean getHearingImpaired() {
    return hearingImpaired;
  }

  public void setHearingImpaired(Boolean hearingImpaired) {
    this.hearingImpaired = hearingImpaired;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioStream audioStream = (AudioStream) o;
    return Objects.equals(this.sampleRate, audioStream.sampleRate) &&
        Objects.equals(this.bitrate, audioStream.bitrate) &&
        Objects.equals(this.rate, audioStream.rate) &&
        Objects.equals(this.channelFormat, audioStream.channelFormat) &&
        Objects.equals(this.language, audioStream.language) &&
        Objects.equals(this.hearingImpaired, audioStream.hearingImpaired) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sampleRate, bitrate, rate, channelFormat, language, hearingImpaired, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    sampleRate: ").append(toIndentedString(sampleRate)).append("\n");
    sb.append("    bitrate: ").append(toIndentedString(bitrate)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    channelFormat: ").append(toIndentedString(channelFormat)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    hearingImpaired: ").append(toIndentedString(hearingImpaired)).append("\n");
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

