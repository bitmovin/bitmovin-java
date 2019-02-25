package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Set the Motion search method
 */
public enum MotionSearch {
  
  /**
   * Set the Motion search method
   */
  DIA("DIA"),
  
  /**
   * Set the Motion search method
   */
  HEX("HEX"),
  
  /**
   * Set the Motion search method
   */
  UMH("UMH"),
  
  /**
   * Set the Motion search method
   */
  STAR("STAR"),
  
  /**
   * Set the Motion search method
   */
  FULL("FULL");

  private String value;

  MotionSearch(String value) {
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
  public static MotionSearch fromValue(String text) {
    for (MotionSearch b : MotionSearch.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

