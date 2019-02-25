package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Noise sensitivity (frames to blur).
 */
public enum Vp8NoiseSensitivity {
  
  /**
   * Noise sensitivity (frames to blur).
   */
  OFF("OFF"),
  
  /**
   * Noise sensitivity (frames to blur).
   */
  ON_Y_ONLY("ON_Y_ONLY"),
  
  /**
   * Noise sensitivity (frames to blur).
   */
  ON_YUV("ON_YUV"),
  
  /**
   * Noise sensitivity (frames to blur).
   */
  ON_YUV_AGGRESSIVE("ON_YUV_AGGRESSIVE"),
  
  /**
   * Noise sensitivity (frames to blur).
   */
  ADAPTIVE("ADAPTIVE");

  private String value;

  Vp8NoiseSensitivity(String value) {
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
  public static Vp8NoiseSensitivity fromValue(String text) {
    for (Vp8NoiseSensitivity b : Vp8NoiseSensitivity.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

