package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Mode for vertical low pass filtering
 */
public enum VerticalLowPassFilteringMode {
  
  /**
   * Do not use vertical low pass filtering
   */
  DISABLED("DISABLED"),
  
  /**
   * Recommended for progressive sources. Reduces Moire patterning and twitter
   */
  LOW_PASS("LOW_PASS"),
  
  /**
   * Retaining better detail and sharpness, but less reduction in twitter
   */
  COMPLEX("COMPLEX");

  private String value;

  VerticalLowPassFilteringMode(String value) {
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
  public static VerticalLowPassFilteringMode fromValue(String text) {
    for (VerticalLowPassFilteringMode b : VerticalLowPassFilteringMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

