package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CaptionsEmbedCea
 */

public class CaptionsEmbedCea extends BitmovinResource {
  @JsonProperty("channel")
  private Integer channel;

  @JsonProperty("inputStream")
  private InputStream inputStream = null;


  /**
   * Select the channel for the caption information
   * @return channel
  **/
  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }


  /**
   * The input stream to extract the subtitle from
   * @return inputStream
  **/
  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaptionsEmbedCea captionsEmbedCea = (CaptionsEmbedCea) o;
    return Objects.equals(this.channel, captionsEmbedCea.channel) &&
        Objects.equals(this.inputStream, captionsEmbedCea.inputStream) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, inputStream, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaptionsEmbedCea {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    inputStream: ").append(toIndentedString(inputStream)).append("\n");
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

