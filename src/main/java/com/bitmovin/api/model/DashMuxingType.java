package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets DashMuxingType
 */
public enum DashMuxingType {
  
  /**
   * Generates a SegmentTemplate based representation
   */
  TEMPLATE("TEMPLATE"),
  
  /**
   * Generates a SegmentList based representation
   */
  LIST("LIST"),
  
  /**
   * Generates a SegmentTimeline based representation
   */
  TIMELINE("TIMELINE");

  private String value;

  DashMuxingType(String value) {
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
  public static DashMuxingType fromValue(String text) {
    for (DashMuxingType b : DashMuxingType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

