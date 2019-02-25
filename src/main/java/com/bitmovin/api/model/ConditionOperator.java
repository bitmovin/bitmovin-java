package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The operator that should be used for the evaluation
 */
public enum ConditionOperator {
  
  /**
   * Equal
   */
  EQUAL("=="),
  
  /**
   * Not equal
   */
  NOT_EQUAL("!="),
  
  /**
   * Less than or equal
   */
  LESS_THAN_OR_EQUAL("<="),
  
  /**
   * Less then
   */
  LESS_THAN("<"),
  
  /**
   * Greater than
   */
  GREATER_THAN(">"),
  
  /**
   * Greater than or equal
   */
  GREATER_THAN_OR_EQUAL(">=");

  private String value;

  ConditionOperator(String value) {
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
  public static ConditionOperator fromValue(String text) {
    for (ConditionOperator b : ConditionOperator.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

