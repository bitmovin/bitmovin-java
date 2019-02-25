package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingStreamInputDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingStreamInput
 */

public class EncodingStreamInput {
  @JsonProperty("inputId")
  private String inputId;

  @JsonProperty("inputPath")
  private String inputPath;

  @JsonProperty("details")
  private EncodingStreamInputDetails details = null;

  /**
   * Input id
   * @return inputId
  **/
  public String getInputId() {
    return inputId;
  }

  /**
   * Path to media file
   * @return inputPath
  **/
  public String getInputPath() {
    return inputPath;
  }


  /**
   * Get details
   * @return details
  **/
  public EncodingStreamInputDetails getDetails() {
    return details;
  }

  public void setDetails(EncodingStreamInputDetails details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingStreamInput encodingStreamInput = (EncodingStreamInput) o;
    return Objects.equals(this.inputId, encodingStreamInput.inputId) &&
        Objects.equals(this.inputPath, encodingStreamInput.inputPath) &&
        Objects.equals(this.details, encodingStreamInput.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputId, inputPath, details);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingStreamInput {\n");
    
    sb.append("    inputId: ").append(toIndentedString(inputId)).append("\n");
    sb.append("    inputPath: ").append(toIndentedString(inputPath)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

