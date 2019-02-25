package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of the drm
 */
public enum DrmType {
  
  /**
   * The type of the drm
   */
  WIDEVINE("WIDEVINE"),
  
  /**
   * The type of the drm
   */
  PLAYREADY("PLAYREADY"),
  
  /**
   * The type of the drm
   */
  PRIMETIME("PRIMETIME"),
  
  /**
   * The type of the drm
   */
  FAIRPLAY("FAIRPLAY"),
  
  /**
   * The type of the drm
   */
  MARLIN("MARLIN"),
  
  /**
   * The type of the drm
   */
  CLEARKEY("CLEARKEY"),
  
  /**
   * The type of the drm
   */
  AES("AES"),
  
  /**
   * The type of the drm
   */
  CENC("CENC");

  private String value;

  DrmType(String value) {
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
  public static DrmType fromValue(String text) {
    for (DrmType b : DrmType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

