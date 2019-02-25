package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.MediaStream;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SubtitleStream
 */

public class SubtitleStream extends MediaStream {
  @JsonProperty("language")
  private String language;

  @JsonProperty("hearingImpaired")
  private Boolean hearingImpaired;


  /**
   * Language of the stream
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  /**
   * Hearing impaired support
   * @return hearingImpaired
  **/
  public Boolean getHearingImpaired() {
    return hearingImpaired;
  }

  public void setHearingImpaired(Boolean hearingImpaired) {
    this.hearingImpaired = hearingImpaired;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubtitleStream subtitleStream = (SubtitleStream) o;
    return Objects.equals(this.language, subtitleStream.language) &&
        Objects.equals(this.hearingImpaired, subtitleStream.hearingImpaired) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, hearingImpaired, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubtitleStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    hearingImpaired: ").append(toIndentedString(hearingImpaired)).append("\n");
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

