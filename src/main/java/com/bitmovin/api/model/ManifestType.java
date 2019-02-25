package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ManifestType
 */
public enum ManifestType {
  
  /**
   * MPEG-DASH manifest
   */
  DASH("DASH"),
  
  /**
   * Apple HTTP Live Streaming manifest
   */
  HLS("HLS"),
  
  /**
   * Microsoft Smooth Streaming manifest
   */
  SMOOTH_STREAMING("SMOOTH_STREAMING");

  private String value;

  ManifestType(String value) {
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
  public static ManifestType fromValue(String text) {
    for (ManifestType b : ManifestType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

