package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Extra recursion depth for intra coded units
 */
public enum TuInterDepth {
  
  /**
   * Extra recursion depth for intra coded units
   */
  D1("1"),
  
  /**
   * Extra recursion depth for intra coded units
   */
  D2("2"),
  
  /**
   * Extra recursion depth for intra coded units
   */
  D3("3"),
  
  /**
   * Extra recursion depth for intra coded units
   */
  D4("4");

  private String value;

  TuInterDepth(String value) {
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
  public static TuInterDepth fromValue(String text) {
    for (TuInterDepth b : TuInterDepth.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

