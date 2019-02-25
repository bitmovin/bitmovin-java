package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamPerTitleFixedResolutionAndBitrateSettings;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StreamPerTitleSettings
 */

public class StreamPerTitleSettings {
  @JsonProperty("fixedResolutionAndBitrateSettings")
  private StreamPerTitleFixedResolutionAndBitrateSettings fixedResolutionAndBitrateSettings = null;


  /**
   * Settings for PER_TITLE_TEMPLATE_FIXED_RESOLUTION_AND_BITRATE mode
   * @return fixedResolutionAndBitrateSettings
  **/
  public StreamPerTitleFixedResolutionAndBitrateSettings getFixedResolutionAndBitrateSettings() {
    return fixedResolutionAndBitrateSettings;
  }

  public void setFixedResolutionAndBitrateSettings(StreamPerTitleFixedResolutionAndBitrateSettings fixedResolutionAndBitrateSettings) {
    this.fixedResolutionAndBitrateSettings = fixedResolutionAndBitrateSettings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamPerTitleSettings streamPerTitleSettings = (StreamPerTitleSettings) o;
    return Objects.equals(this.fixedResolutionAndBitrateSettings, streamPerTitleSettings.fixedResolutionAndBitrateSettings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fixedResolutionAndBitrateSettings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamPerTitleSettings {\n");
    
    sb.append("    fixedResolutionAndBitrateSettings: ").append(toIndentedString(fixedResolutionAndBitrateSettings)).append("\n");
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

