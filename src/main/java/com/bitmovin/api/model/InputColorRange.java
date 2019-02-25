package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Override the color range detected in the input file. If not set the input color range will be automatically detected if possible.
 */
public enum InputColorRange {
  
  /**
   * Override the color range detected in the input file. If not set the input color range will be automatically detected if possible.
   */
  UNSPECIFIED("UNSPECIFIED"),
  
  /**
   * Override the color range detected in the input file. If not set the input color range will be automatically detected if possible.
   */
  MPEG("MPEG"),
  
  /**
   * Override the color range detected in the input file. If not set the input color range will be automatically detected if possible.
   */
  JPEG("JPEG");

  private String value;

  InputColorRange(String value) {
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
  public static InputColorRange fromValue(String text) {
    for (InputColorRange b : InputColorRange.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

