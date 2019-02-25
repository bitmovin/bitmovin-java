package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.ChunkLengthMode;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * InternalChunkLength
 */

public class InternalChunkLength {
  @JsonProperty("mode")
  private ChunkLengthMode mode = null;

  @JsonProperty("customChunkLength")
  private Double customChunkLength;


  /**
   * Defines how the internal chunk length for encoding will be determined
   * @return mode
  **/
  public ChunkLengthMode getMode() {
    return mode;
  }

  public void setMode(ChunkLengthMode mode) {
    this.mode = mode;
  }


  /**
   * Defines a custom internal chunk length in seconds to be used for encoding if mode is set to &#x60;CUSTOM&#x60;. Valid range is from 1 to 180 seconds
   * minimum: 1
   * maximum: 180
   * @return customChunkLength
  **/
  public Double getCustomChunkLength() {
    return customChunkLength;
  }

  public void setCustomChunkLength(Double customChunkLength) {
    this.customChunkLength = customChunkLength;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternalChunkLength internalChunkLength = (InternalChunkLength) o;
    return Objects.equals(this.mode, internalChunkLength.mode) &&
        Objects.equals(this.customChunkLength, internalChunkLength.customChunkLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, customChunkLength);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternalChunkLength {\n");
    
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    customChunkLength: ").append(toIndentedString(customChunkLength)).append("\n");
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

