package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The color range to be applied
 */
public enum ColorRange {
  
  /**
   * The color range to be applied
   */
  UNSPECIFIED("UNSPECIFIED"),
  
  /**
   * The color range to be applied
   */
  MPEG("MPEG"),
  
  /**
   * The color range to be applied
   */
  JPEG("JPEG");

  private String value;

  ColorRange(String value) {
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
  public static ColorRange fromValue(String text) {
    for (ColorRange b : ColorRange.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

