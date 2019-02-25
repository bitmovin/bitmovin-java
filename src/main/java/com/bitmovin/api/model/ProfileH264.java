package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ProfileH264
 */
public enum ProfileH264 {
  
  /**
   * Baseline profile
   */
  BASELINE("BASELINE"),
  
  /**
   * Main profile
   */
  MAIN("MAIN"),
  
  /**
   * High profile
   */
  HIGH("HIGH");

  private String value;

  ProfileH264(String value) {
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
  public static ProfileH264 fromValue(String text) {
    for (ProfileH264 b : ProfileH264.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

