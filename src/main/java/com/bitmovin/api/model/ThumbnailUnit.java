package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ThumbnailUnit
 */
public enum ThumbnailUnit {
  
  /**
   * Unit of positions is in seconds
   */
  SECONDS("SECONDS"),
  
  /**
   * Unit of positions is in percent
   */
  PERCENTS("PERCENTS");

  private String value;

  ThumbnailUnit(String value) {
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
  public static ThumbnailUnit fromValue(String text) {
    for (ThumbnailUnit b : ThumbnailUnit.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

