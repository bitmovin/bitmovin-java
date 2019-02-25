package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets HlsVersion
 */
public enum HlsVersion {
  
  /**
   * HLS version 3
   */
  HLS_V3("3"),
  
  /**
   * HLS version 4
   */
  HLS_V4("4"),
  
  /**
   * HLS version 5
   */
  HLS_V5("5"),
  
  /**
   * HLS version 6
   */
  HLS_V6("6"),
  
  /**
   * HLS version 7
   */
  HLS_V7("7"),
  
  /**
   * HLS version 8
   */
  HLS_V8("8");

  private String value;

  HlsVersion(String value) {
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
  public static HlsVersion fromValue(String text) {
    for (HlsVersion b : HlsVersion.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

