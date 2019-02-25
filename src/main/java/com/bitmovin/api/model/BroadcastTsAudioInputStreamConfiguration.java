package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BroadcastTsInputStreamConfiguration;
import com.bitmovin.api.model.RaiUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BroadcastTsAudioInputStreamConfiguration
 */

public class BroadcastTsAudioInputStreamConfiguration extends BroadcastTsInputStreamConfiguration {
  @JsonProperty("useATSCBufferModel")
  private Boolean useATSCBufferModel;

  @JsonProperty("language")
  private String language;


  /**
   * Use ATSC buffer model for AC-3. If true, use the ATSC version of the T-STD buffer model is used. This parameter applies to AC-3 streams only.
   * @return useATSCBufferModel
  **/
  public Boolean getUseATSCBufferModel() {
    return useATSCBufferModel;
  }

  public void setUseATSCBufferModel(Boolean useATSCBufferModel) {
    this.useATSCBufferModel = useATSCBufferModel;
  }


  /**
   * Language of the audio stream. Specified according to the ISO 639-2 alpha code for the language descriptor.
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastTsAudioInputStreamConfiguration broadcastTsAudioInputStreamConfiguration = (BroadcastTsAudioInputStreamConfiguration) o;
    return Objects.equals(this.useATSCBufferModel, broadcastTsAudioInputStreamConfiguration.useATSCBufferModel) &&
        Objects.equals(this.language, broadcastTsAudioInputStreamConfiguration.language) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(useATSCBufferModel, language, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BroadcastTsAudioInputStreamConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    useATSCBufferModel: ").append(toIndentedString(useATSCBufferModel)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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

