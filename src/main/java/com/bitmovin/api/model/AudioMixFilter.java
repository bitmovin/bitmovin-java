package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AudioMixChannel;
import com.bitmovin.api.model.AudioMixChannelLayout;
import com.bitmovin.api.model.Filter;
import com.bitmovin.api.model.FilterType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AudioMixFilter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class AudioMixFilter extends Filter {
  @JsonProperty("channelLayout")
  private AudioMixChannelLayout channelLayout = null;

  @JsonProperty("audioMixChannels")
  private List<AudioMixChannel> audioMixChannels = new ArrayList<AudioMixChannel>();


  /**
   * Channel layout of the audio codec configuration
   * @return channelLayout
  **/
  public AudioMixChannelLayout getChannelLayout() {
    return channelLayout;
  }

  public void setChannelLayout(AudioMixChannelLayout channelLayout) {
    this.channelLayout = channelLayout;
  }


  public AudioMixFilter addAudioMixChannelsItem(AudioMixChannel audioMixChannelsItem) {
    this.audioMixChannels.add(audioMixChannelsItem);
    return this;
  }

  /**
   * List of mixed channels that matches the channel layout
   * @return audioMixChannels
  **/
  public List<AudioMixChannel> getAudioMixChannels() {
    return audioMixChannels;
  }

  public void setAudioMixChannels(List<AudioMixChannel> audioMixChannels) {
    this.audioMixChannels = audioMixChannels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioMixFilter audioMixFilter = (AudioMixFilter) o;
    return Objects.equals(this.channelLayout, audioMixFilter.channelLayout) &&
        Objects.equals(this.audioMixChannels, audioMixFilter.audioMixChannels) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelLayout, audioMixChannels, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioMixFilter {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    channelLayout: ").append(toIndentedString(channelLayout)).append("\n");
    sb.append("    audioMixChannels: ").append(toIndentedString(audioMixChannels)).append("\n");
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

