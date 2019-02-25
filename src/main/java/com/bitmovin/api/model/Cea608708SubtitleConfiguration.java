package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Cea608708SubtitleConfiguration
 */

public class Cea608708SubtitleConfiguration {
  @JsonProperty("passthroughActivated")
  private Boolean passthroughActivated;


  /**
   * If enabled, CEA 608 an CEA 708 subtitles will be copied from the input video stream to the output video stream. Note: This does not work, if the output framerate is different than the input framerate (except doubling the framerate with deinterlacing per field)
   * @return passthroughActivated
  **/
  public Boolean getPassthroughActivated() {
    return passthroughActivated;
  }

  public void setPassthroughActivated(Boolean passthroughActivated) {
    this.passthroughActivated = passthroughActivated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cea608708SubtitleConfiguration cea608708SubtitleConfiguration = (Cea608708SubtitleConfiguration) o;
    return Objects.equals(this.passthroughActivated, cea608708SubtitleConfiguration.passthroughActivated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passthroughActivated);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cea608708SubtitleConfiguration {\n");
    
    sb.append("    passthroughActivated: ").append(toIndentedString(passthroughActivated)).append("\n");
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

