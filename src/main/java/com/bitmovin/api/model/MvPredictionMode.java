package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Sets the Motion Vector Prediction Mode.
 */
public enum MvPredictionMode {
  
  /**
   * Sets the Motion Vector Prediction Mode.
   */
  NONE("NONE"),
  
  /**
   * Sets the Motion Vector Prediction Mode.
   */
  SPATIAL("SPATIAL"),
  
  /**
   * Sets the Motion Vector Prediction Mode.
   */
  TEMPORAL("TEMPORAL"),
  
  /**
   * Sets the Motion Vector Prediction Mode.
   */
  AUTO("AUTO");

  private String value;

  MvPredictionMode(String value) {
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
  public static MvPredictionMode fromValue(String text) {
    for (MvPredictionMode b : MvPredictionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

