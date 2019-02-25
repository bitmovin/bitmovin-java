package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AdaptationSet;
import com.bitmovin.api.model.AdaptationSetRole;
import com.bitmovin.api.model.CustomAttribute;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AudioAdaptationSet
 */

public class AudioAdaptationSet extends AdaptationSet {
  @JsonProperty("lang")
  private String lang;


  /**
   * ISO 639-1 (Alpha-2) code identifying the language of the audio adaptation set
   * @return lang
  **/
  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AudioAdaptationSet audioAdaptationSet = (AudioAdaptationSet) o;
    return Objects.equals(this.lang, audioAdaptationSet.lang) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lang, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AudioAdaptationSet {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    lang: ").append(toIndentedString(lang)).append("\n");
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

