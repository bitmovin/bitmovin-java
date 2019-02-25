package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PerTitleFixedResolutionAndBitrateConfigurationMode
 */
public enum PerTitleFixedResolutionAndBitrateConfigurationMode {
  
  /**
   * The next bitrate for the forced representation is the calculated bitrate of the Per-Title representation multiplied by the factor.
   */
  LAST_CALCULATED_BITRATE("LAST_CALCULATED_BITRATE"),
  
  /**
   * The next bitrate for the forced representation is the minimum bitrate defined in the Per-Title template stream multiplied by the factor.
   */
  MINIMUM("MINIMUM"),
  
  /**
   * The next bitrate for the forced representation is the maximum bitrate defined in the Per-Title template stream multiplied by the factor.
   */
  MAXIMUM("MAXIMUM"),
  
  /**
   * The next bitrate for the forced representation is the average bitrate defined in the Per-Title template stream multiplied by the factor.
   */
  AVERAGE("AVERAGE");

  private String value;

  PerTitleFixedResolutionAndBitrateConfigurationMode(String value) {
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
  public static PerTitleFixedResolutionAndBitrateConfigurationMode fromValue(String text) {
    for (PerTitleFixedResolutionAndBitrateConfigurationMode b : PerTitleFixedResolutionAndBitrateConfigurationMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

