package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.InputPath;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BurnInSubtitleSrt
 */

public class BurnInSubtitleSrt extends BitmovinResource {
  @JsonProperty("input")
  private InputPath input = null;


  /**
   * The input location to get the SRT file from
   * @return input
  **/
  public InputPath getInput() {
    return input;
  }

  public void setInput(InputPath input) {
    this.input = input;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BurnInSubtitleSrt burnInSubtitleSrt = (BurnInSubtitleSrt) o;
    return Objects.equals(this.input, burnInSubtitleSrt.input) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BurnInSubtitleSrt {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
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

