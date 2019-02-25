package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.SourceChannelType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SourceChannel
 */

public class SourceChannel {
  @JsonProperty("gain")
  private Double gain;

  @JsonProperty("type")
  private SourceChannelType type = null;

  @JsonProperty("channelNumber")
  private Integer channelNumber;


  /**
   * Gain for this source channel. Default is 1.0.
   * @return gain
  **/
  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }


  /**
   * Get type
   * @return type
  **/
  public SourceChannelType getType() {
    return type;
  }

  public void setType(SourceChannelType type) {
    this.type = type;
  }


  /**
   * Number of this source channel. If type is &#39;CHANNEL_NUMBER&#39;, this must be set.
   * @return channelNumber
  **/
  public Integer getChannelNumber() {
    return channelNumber;
  }

  public void setChannelNumber(Integer channelNumber) {
    this.channelNumber = channelNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceChannel sourceChannel = (SourceChannel) o;
    return Objects.equals(this.gain, sourceChannel.gain) &&
        Objects.equals(this.type, sourceChannel.type) &&
        Objects.equals(this.channelNumber, sourceChannel.channelNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gain, type, channelNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceChannel {\n");
    
    sb.append("    gain: ").append(toIndentedString(gain)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    channelNumber: ").append(toIndentedString(channelNumber)).append("\n");
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

