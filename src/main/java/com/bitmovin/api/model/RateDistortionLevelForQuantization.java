package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets RateDistortionLevelForQuantization
 */
public enum RateDistortionLevelForQuantization {
  
  /**
   * Rate-distortion cost is not considered in quantization.
   */
  DISABLED("DISABLED"),
  
  /**
   * Rate-distortion cost is used to find optimal rounding values for each level.
   */
  LEVELS("LEVELS"),
  
  /**
   * Rate-distortion cost is used to make decimate decisions on each 4x4 coding group.
   */
  LEVELS_AND_CODING_GROUPS("LEVELS_AND_CODING_GROUPS");

  private String value;

  RateDistortionLevelForQuantization(String value) {
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
  public static RateDistortionLevelForQuantization fromValue(String text) {
    for (RateDistortionLevelForQuantization b : RateDistortionLevelForQuantization.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

