package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ConvertSccPositionMode
 */
public enum ConvertSccPositionMode {
  
  /**
   * Use all position information in the output format.
   */
  FULL("FULL"),
  
  /**
   * Convert to simple top/bottom center-aligned captions.
   */
  SIMPLE("SIMPLE"),
  
  /**
   * This will remove all position information from the output
   */
  NONE("NONE");

  private String value;

  ConvertSccPositionMode(String value) {
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
  public static ConvertSccPositionMode fromValue(String text) {
    for (ConvertSccPositionMode b : ConvertSccPositionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

