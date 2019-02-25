package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.ConcatenationInputConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ConcatenationInputStream
 */

public class ConcatenationInputStream extends BitmovinResource {
  @JsonProperty("concatenation")
  private List<ConcatenationInputConfiguration> concatenation;


  public ConcatenationInputStream addConcatenationItem(ConcatenationInputConfiguration concatenationItem) {
    if (this.concatenation == null) {
      this.concatenation = new ArrayList<>();
    }
    this.concatenation.add(concatenationItem);
    return this;
  }

  /**
   * Concatenation configuration for the output of this stream
   * @return concatenation
  **/
  public List<ConcatenationInputConfiguration> getConcatenation() {
    return concatenation;
  }

  public void setConcatenation(List<ConcatenationInputConfiguration> concatenation) {
    this.concatenation = concatenation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConcatenationInputStream concatenationInputStream = (ConcatenationInputStream) o;
    return Objects.equals(this.concatenation, concatenationInputStream.concatenation) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(concatenation, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConcatenationInputStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    concatenation: ").append(toIndentedString(concatenation)).append("\n");
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

