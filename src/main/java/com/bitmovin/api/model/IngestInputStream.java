package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.StreamSelectionMode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * IngestInputStream
 */

public class IngestInputStream extends BitmovinResource {
  @JsonProperty("inputId")
  private String inputId;

  @JsonProperty("inputPath")
  private String inputPath;

  @JsonProperty("selectionMode")
  private StreamSelectionMode selectionMode = null;

  @JsonProperty("position")
  private Integer position;


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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngestInputStream ingestInputStream = (IngestInputStream) o;
    return Objects.equals(this.inputId, ingestInputStream.inputId) &&
        Objects.equals(this.inputPath, ingestInputStream.inputPath) &&
        Objects.equals(this.selectionMode, ingestInputStream.selectionMode) &&
        Objects.equals(this.position, ingestInputStream.position) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputId, inputPath, selectionMode, position, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IngestInputStream {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    inputId: ").append(toIndentedString(inputId)).append("\n");
    sb.append("    inputPath: ").append(toIndentedString(inputPath)).append("\n");
    sb.append("    selectionMode: ").append(toIndentedString(selectionMode)).append("\n");
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

