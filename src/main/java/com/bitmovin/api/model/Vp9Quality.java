package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Determines quality for the price of speed.
 */
public enum Vp9Quality {
  
  /**
   * Determines quality for the price of speed.
   */
  REALTIME("REALTIME"),
  
  /**
   * Determines quality for the price of speed.
   */
  GOOD("GOOD"),
  
  /**
   * Determines quality for the price of speed.
   */
  BEST("BEST");

  private String value;

  Vp9Quality(String value) {
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
  public static Vp9Quality fromValue(String text) {
    for (Vp9Quality b : Vp9Quality.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

