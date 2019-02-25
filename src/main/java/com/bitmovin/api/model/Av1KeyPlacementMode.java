package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies whether keyframes should be placed at fixed intervals or the encoder may determine optimal placement automatically
 */
public enum Av1KeyPlacementMode {
  
  /**
   * Specifies whether keyframes should be placed at fixed intervals or the encoder may determine optimal placement automatically
   */
  AUTO("AUTO"),
  
  /**
   * Specifies whether keyframes should be placed at fixed intervals or the encoder may determine optimal placement automatically
   */
  FIXED("FIXED"),
  
  /**
   * Specifies whether keyframes should be placed at fixed intervals or the encoder may determine optimal placement automatically
   */
  DISABLED("DISABLED");

  private String value;

  Av1KeyPlacementMode(String value) {
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
  public static Av1KeyPlacementMode fromValue(String text) {
    for (Av1KeyPlacementMode b : Av1KeyPlacementMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

