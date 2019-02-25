package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AudioConfiguration;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.VorbisChannelLayout;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * VorbisAudioConfiguration
 */

public class VorbisAudioConfiguration extends AudioConfiguration {
  @JsonProperty("channelLayout")
  private VorbisChannelLayout channelLayout = null;


  /**
   * Channel layout of the audio codec configuration
   * @return channelLayout
  **/
  public VorbisChannelLayout getChannelLayout() {
    return channelLayout;
  }

  public void setChannelLayout(VorbisChannelLayout channelLayout) {
    this.channelLayout = channelLayout;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VorbisAudioConfiguration vorbisAudioConfiguration = (VorbisAudioConfiguration) o;
    return Objects.equals(this.channelLayout, vorbisAudioConfiguration.channelLayout) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelLayout, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VorbisAudioConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    channelLayout: ").append(toIndentedString(channelLayout)).append("\n");
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

