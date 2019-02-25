package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * altref noise reduction filter type
 */
public enum Vp9ArnrType {
  
  /**
   * altref noise reduction filter type
   */
  BACKWARD("BACKWARD"),
  
  /**
   * altref noise reduction filter type
   */
  FORWARD("FORWARD"),
  
  /**
   * altref noise reduction filter type
   */
  CENTERED("CENTERED");

  private String value;

  Vp9ArnrType(String value) {
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
  public static Vp9ArnrType fromValue(String text) {
    for (Vp9ArnrType b : Vp9ArnrType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

