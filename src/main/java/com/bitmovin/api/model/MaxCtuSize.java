package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Set the maximal CTU (Coding Tree Unit) size
 */
public enum MaxCtuSize {
  
  /**
   * Set the maximal CTU (Coding Tree Unit) size
   */
  S16("16"),
  
  /**
   * Set the maximal CTU (Coding Tree Unit) size
   */
  S32("32"),
  
  /**
   * Set the maximal CTU (Coding Tree Unit) size
   */
  S64("64");

  private String value;

  MaxCtuSize(String value) {
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
  public static MaxCtuSize fromValue(String text) {
    for (MaxCtuSize b : MaxCtuSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

