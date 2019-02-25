package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Adaptive quantization mode.
 */
public enum Vp9AqMode {
  
  /**
   * Adaptive quantization mode.
   */
  NONE("NONE"),
  
  /**
   * Adaptive quantization mode.
   */
  VARIANCE("VARIANCE"),
  
  /**
   * Adaptive quantization mode.
   */
  COMPLEXITY("COMPLEXITY"),
  
  /**
   * Adaptive quantization mode.
   */
  CYCLIC("CYCLIC");

  private String value;

  Vp9AqMode(String value) {
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
  public static Vp9AqMode fromValue(String text) {
    for (Vp9AqMode b : Vp9AqMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

