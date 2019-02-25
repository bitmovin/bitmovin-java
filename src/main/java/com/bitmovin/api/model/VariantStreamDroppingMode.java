package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Variant stream dropping mode.
 */
public enum VariantStreamDroppingMode {
  
  /**
   * Variant stream dropping mode.
   */
  STREAM("STREAM"),
  
  /**
   * Variant stream dropping mode.
   */
  AUDIO("AUDIO");

  private String value;

  VariantStreamDroppingMode(String value) {
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
  public static VariantStreamDroppingMode fromValue(String text) {
    for (VariantStreamDroppingMode b : VariantStreamDroppingMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

