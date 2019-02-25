package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AudioVideoSyncMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Tweaks
 */

public class Tweaks {
  @JsonProperty("audioVideoSyncMode")
  private AudioVideoSyncMode audioVideoSyncMode = null;


  /**
   * Defines special audio video sync handling
   * @return audioVideoSyncMode
  **/
  public AudioVideoSyncMode getAudioVideoSyncMode() {
    return audioVideoSyncMode;
  }

  public void setAudioVideoSyncMode(AudioVideoSyncMode audioVideoSyncMode) {
    this.audioVideoSyncMode = audioVideoSyncMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tweaks tweaks = (Tweaks) o;
    return Objects.equals(this.audioVideoSyncMode, tweaks.audioVideoSyncMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(audioVideoSyncMode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tweaks {\n");
    
    sb.append("    audioVideoSyncMode: ").append(toIndentedString(audioVideoSyncMode)).append("\n");
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

