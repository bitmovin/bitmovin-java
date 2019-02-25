package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AnalyticsOperator
 */
public enum AnalyticsOperator {
  
  
  EQ("EQ"),
  
  
  NE("NE"),
  
  
  LT("LT"),
  
  
  LTE("LTE"),
  
  
  GT("GT"),
  
  
  GTE("GTE"),
  
  
  CONTAINS("CONTAINS"),
  
  
  NOTCONTAINS("NOTCONTAINS");

  private String value;

  AnalyticsOperator(String value) {
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
  public static AnalyticsOperator fromValue(String text) {
    for (AnalyticsOperator b : AnalyticsOperator.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

