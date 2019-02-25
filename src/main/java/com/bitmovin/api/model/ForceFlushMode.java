package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Force the encoder to flush frames. Default is DISABLED.
 */
public enum ForceFlushMode {
  
  /**
   * Flush the encoder only when all the input pictures are over
   */
  DISABLED("DISABLED"),
  
  /**
   * Flush all the frames even when the input is not over
   */
  ALL_FRAMES("ALL_FRAMES"),
  
  /**
   * Flush the slicetype decided frames only
   */
  SLICE_TYPE("SLICE_TYPE");

  private String value;

  ForceFlushMode(String value) {
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
  public static ForceFlushMode fromValue(String text) {
    for (ForceFlushMode b : ForceFlushMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

