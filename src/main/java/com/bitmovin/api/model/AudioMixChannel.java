package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.SourceChannel;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AudioMixChannel
 */

public class AudioMixChannel {
  @JsonProperty("channelNumber")
  private Integer channelNumber;

  @JsonProperty("sourceChannels")
  private List<SourceChannel> sourceChannels = new ArrayList<SourceChannel>();


  /**
   * Channel number of this mix (starting with 0)
   * @return channelNumber
  **/
  public Integer getChannelNumber() {
    return channelNumber;
  }

  public void setChannelNumber(Integer channelNumber) {
    this.channelNumber = channelNumber;
  }


  public AudioMixChannel addSourceChannelsItem(SourceChannel sourceChannelsItem) {
    this.sourceChannels.add(sourceChannelsItem);
    return this;
  }

  /**
   * List of source channels to be mixed
   * @return sourceChannels
  **/
  public List<SourceChannel> getSourceChannels() {
    return sourceChannels;
  }

  public void setSourceChannels(List<SourceChannel> sourceChannels) {
    this.sourceChannels = sourceChannels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioMixChannel audioMixChannel = (AudioMixChannel) o;
    return Objects.equals(this.channelNumber, audioMixChannel.channelNumber) &&
        Objects.equals(this.sourceChannels, audioMixChannel.sourceChannels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelNumber, sourceChannels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioMixChannel {\n");
    
    sb.append("    channelNumber: ").append(toIndentedString(channelNumber)).append("\n");
    sb.append("    sourceChannels: ").append(toIndentedString(sourceChannels)).append("\n");
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

