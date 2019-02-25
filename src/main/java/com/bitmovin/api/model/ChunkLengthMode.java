package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines how the internal chunk length for encoding will be determined
 */
public enum ChunkLengthMode {
  
  /**
   * The chunk length is optimized for fast turnaround times
   */
  SPEED_OPTIMIZED("SPEED_OPTIMIZED"),
  
  /**
   * The chunk length is defined by the customChunkLength attribute
   */
  CUSTOM("CUSTOM");

  private String value;

  ChunkLengthMode(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ChunkLengthMode fromValue(String text) {
    for (ChunkLengthMode b : ChunkLengthMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

