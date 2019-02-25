package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets IvSize
 */
public enum IvSize {
  
  /**
   * Define initialization vector to have a size of 8 bytes
   */
  IV_8_BYTES("8_BYTES"),
  
  /**
   * Define initialization vector to have a size of 16 bytes
   */
  IV_16_BYTES("16_BYTES");

  private String value;

  IvSize(String value) {
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
  public static IvSize fromValue(String text) {
    for (IvSize b : IvSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

