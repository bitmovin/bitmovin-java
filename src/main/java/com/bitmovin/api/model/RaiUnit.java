package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Set the random access indicator (RAI) on appropriate access units (AUs).
 */
public enum RaiUnit {
  
  /**
   * Never set RAI.
   */
  NONE("NONE"),
  
  /**
   * Set RAI in all PES packets.
   */
  ALL_PES_PACKETS("ALL_PES_PACKETS"),
  
  /**
   * Set RAI if packet is marked acquisition point.
   */
  ACQUISITION_POINT_PACKETS("ACQUISITION_POINT_PACKETS"),
  
  /**
   * Set RAI according to instructions in input file.
   */
  ACCORDING_TO_INPUT("ACCORDING_TO_INPUT");

  private String value;

  RaiUnit(String value) {
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
  public static RaiUnit fromValue(String text) {
    for (RaiUnit b : RaiUnit.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

