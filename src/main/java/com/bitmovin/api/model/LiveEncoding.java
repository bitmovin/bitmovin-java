package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveEncoding
 */

public class LiveEncoding {
  @JsonProperty("streamKey")
  private String streamKey;

  @JsonProperty("encoderIp")
  private String encoderIp;


  /**
   * Stream key of the live encoder
   * @return streamKey
  **/
  public String getStreamKey() {
    return streamKey;
  }

  public void setStreamKey(String streamKey) {
    this.streamKey = streamKey;
  }


  /**
   * IP address of the live encoder
   * @return encoderIp
  **/
  public String getEncoderIp() {
    return encoderIp;
  }

  public void setEncoderIp(String encoderIp) {
    this.encoderIp = encoderIp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveEncoding liveEncoding = (LiveEncoding) o;
    return Objects.equals(this.streamKey, liveEncoding.streamKey) &&
        Objects.equals(this.encoderIp, liveEncoding.encoderIp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streamKey, encoderIp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveEncoding {\n");
    
    sb.append("    streamKey: ").append(toIndentedString(streamKey)).append("\n");
    sb.append("    encoderIp: ").append(toIndentedString(encoderIp)).append("\n");
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

