package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines the mode for weighted prediction for P-frames
 */
public enum WeightedPredictionPFrames {
  
  /**
   * Do not keep P-frame references
   */
  DISABLED("DISABLED"),
  
  /**
   * Enable weighted references
   */
  SIMPLE("SIMPLE"),
  
  /**
   * Enable weighted references and duplicates
   */
  SMART("SMART");

  private String value;

  WeightedPredictionPFrames(String value) {
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
  public static WeightedPredictionPFrames fromValue(String text) {
    for (WeightedPredictionPFrames b : WeightedPredictionPFrames.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

