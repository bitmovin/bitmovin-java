package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets BitrateSelectionMode
 */
public enum BitrateSelectionMode {
  
  /**
   * Bitrate will be selected to provide the best quality for the resulting encoding profile.
   */
  OPTIMIZED("OPTIMIZED"),
  
  /**
   * Bitrate will be selected based on the complexity range given in the configuration (&#x60;lowComplexityBoundaryForMaxBitrate&#x60; and &#x60;highComplexityBoundaryForMaxBitrate&#x60;). Complexity is defined by the max bitrate selected for the resulting encoding profile.
   */
  COMPLEXITY_RANGE("COMPLEXITY_RANGE");

  private String value;

  BitrateSelectionMode(String value) {
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
  public static BitrateSelectionMode fromValue(String text) {
    for (BitrateSelectionMode b : BitrateSelectionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

