package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamSelectionMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * InputStream
 */

public class InputStream {
  @JsonProperty("inputId")
  private String inputId;

  @JsonProperty("inputPath")
  private String inputPath;

  @JsonProperty("selectionMode")
  private StreamSelectionMode selectionMode = null;

  @JsonProperty("position")
  private Integer position;

  @JsonProperty("inputStreamId")
  private String inputStreamId;


  /**
   * Id of input
   * @return inputId
  **/
  public String getInputId() {
    return inputId;
  }

  public void setInputId(String inputId) {
    this.inputId = inputId;
  }


  /**
   * Path to media file
   * @return inputPath
  **/
  public String getInputPath() {
    return inputPath;
  }

  public void setInputPath(String inputPath) {
    this.inputPath = inputPath;
  }


  /**
   * Specifies the algorithm how the stream in the input file will be selected
   * @return selectionMode
  **/
  public StreamSelectionMode getSelectionMode() {
    return selectionMode;
  }

  public void setSelectionMode(StreamSelectionMode selectionMode) {
    this.selectionMode = selectionMode;
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


  /**
   * Set this property instead of all others to reference an ingest, trimming or concatenation input stream
   * @return inputStreamId
  **/
  public String getInputStreamId() {
    return inputStreamId;
  }

  public void setInputStreamId(String inputStreamId) {
    this.inputStreamId = inputStreamId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputStream inputStream = (InputStream) o;
    return Objects.equals(this.inputId, inputStream.inputId) &&
        Objects.equals(this.inputPath, inputStream.inputPath) &&
        Objects.equals(this.selectionMode, inputStream.selectionMode) &&
        Objects.equals(this.position, inputStream.position) &&
        Objects.equals(this.inputStreamId, inputStream.inputStreamId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputId, inputPath, selectionMode, position, inputStreamId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputStream {\n");
    
    sb.append("    inputId: ").append(toIndentedString(inputId)).append("\n");
    sb.append("    inputPath: ").append(toIndentedString(inputPath)).append("\n");
    sb.append("    selectionMode: ").append(toIndentedString(selectionMode)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    inputStreamId: ").append(toIndentedString(inputStreamId)).append("\n");
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

