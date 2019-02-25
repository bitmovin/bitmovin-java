package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * MediaStream
 */

public class MediaStream extends BitmovinResponse {
  @JsonProperty("position")
  private Integer position;

  @JsonProperty("duration")
  private Long duration;

  @JsonProperty("codec")
  private String codec;


  /**
   * Position starts from 0 and indicates the position of the stream in the media. 0 means that this is the first stream found in the media
   * @return position
  **/
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }


  /**
   * Duration of the stream in seconds
   * @return duration
  **/
  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }


  /**
   * Codec of the stream
   * @return codec
  **/
  public String getCodec() {
    return codec;
  }

  public void setCodec(String codec) {
    this.codec = codec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaStream mediaStream = (MediaStream) o;
    return Objects.equals(this.position, mediaStream.position) &&
        Objects.equals(this.duration, mediaStream.duration) &&
        Objects.equals(this.codec, mediaStream.codec) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, duration, codec, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
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

