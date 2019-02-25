package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SubtitleStreamDetails
 */

public class SubtitleStreamDetails extends StreamDetails {
  @JsonProperty("language")
  private String language;

  @JsonProperty("hearingImpaired")
  private Boolean hearingImpaired;


  /**
   * Get language
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  /**
   * Get hearingImpaired
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
    SubtitleStreamDetails subtitleStreamDetails = (SubtitleStreamDetails) o;
    return Objects.equals(this.language, subtitleStreamDetails.language) &&
        Objects.equals(this.hearingImpaired, subtitleStreamDetails.hearingImpaired) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, hearingImpaired, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubtitleStreamDetails {\n");
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

