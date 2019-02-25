package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ChromaLocation
 */
public enum ChromaLocation {
  
  /**
   * Unspecified ChromaLocation
   */
  UNSPECIFIED("UNSPECIFIED"),
  
  /**
   * Left ChromaLocation
   */
  LEFT("LEFT"),
  
  /**
   * Center ChromaLocation
   */
  CENTER("CENTER"),
  
  /**
   * Topleft ChromaLocation
   */
  TOPLEFT("TOPLEFT"),
  
  /**
   * Top ChromaLocation
   */
  TOP("TOP"),
  
  /**
   * Bottomleft ChromaLocation
   */
  BOTTOMLEFT("BOTTOMLEFT"),
  
  /**
   * Bottom ChromaLocation
   */
  BOTTOM("BOTTOM");

  private String value;

  ChromaLocation(String value) {
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
  public static ChromaLocation fromValue(String text) {
    for (ChromaLocation b : ChromaLocation.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

