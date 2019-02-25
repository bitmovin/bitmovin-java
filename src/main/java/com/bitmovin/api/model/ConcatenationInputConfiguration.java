package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ConcatenationInputConfiguration
 */

public class ConcatenationInputConfiguration {
  @JsonProperty("inputStreamId")
  private String inputStreamId;

  @JsonProperty("isMain")
  private Boolean isMain;

  @JsonProperty("position")
  private Integer position;


  /**
   * The id of the input stream that should be used for concatenation. Can be either an ingest input stream, or the result of a trimming input stream
   * @return inputStreamId
  **/
  public String getInputStreamId() {
    return inputStreamId;
  }

  public void setInputStreamId(String inputStreamId) {
    this.inputStreamId = inputStreamId;
  }


  /**
   * Exactly one input stream of a concatenation must have this set to true, which will be used as reference for scaling, aspect ratio, FPS, sample rate, etc. 
   * @return isMain
  **/
  public Boolean getIsMain() {
    return isMain;
  }

  public void setIsMain(Boolean isMain) {
    this.isMain = isMain;
  }


  /**
   * Position of the stream
   * @return position
  **/
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConcatenationInputConfiguration concatenationInputConfiguration = (ConcatenationInputConfiguration) o;
    return Objects.equals(this.inputStreamId, concatenationInputConfiguration.inputStreamId) &&
        Objects.equals(this.isMain, concatenationInputConfiguration.isMain) &&
        Objects.equals(this.position, concatenationInputConfiguration.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputStreamId, isMain, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConcatenationInputConfiguration {\n");
    
    sb.append("    inputStreamId: ").append(toIndentedString(inputStreamId)).append("\n");
    sb.append("    isMain: ").append(toIndentedString(isMain)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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

