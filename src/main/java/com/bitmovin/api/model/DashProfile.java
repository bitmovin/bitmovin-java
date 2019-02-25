package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets DashProfile
 */
public enum DashProfile {
  
  /**
   * LIVE can only use fMP4 muxing
   */
  LIVE("LIVE"),
  
  /**
   * ON_DEMAND can only use MP4 muxing
   */
  ON_DEMAND("ON_DEMAND");

  private String value;

  DashProfile(String value) {
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
  public static DashProfile fromValue(String text) {
    for (DashProfile b : DashProfile.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

