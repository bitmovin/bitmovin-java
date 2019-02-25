package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AdaptationSetRole
 */
public enum AdaptationSetRole {
  
  /**
   * Media content component that is an alternative to a main media content component of the same media component type
   */
  ALTERNATE("ALTERNATE"),
  
  /**
   * Caption
   */
  CAPTION("CAPTION"),
  
  /**
   * Media content component with commentary (typically audio, e.g. director&#39;s commentary)
   */
  COMMENTARY("COMMENTARY"),
  
  /**
   * Media content component which is presented in a different language from the original (e.g. dubbed audio, translated captions)
   */
  DUB("DUB"),
  
  /**
   * Main media component which is intended for presentation if no other information is provided
   */
  MAIN("MAIN"),
  
  /**
   * Subtitle
   */
  SUBTITLE("SUBTITLE"),
  
  /**
   * Media content component that is supplementary to a media content component of a different media component type
   */
  SUPPLEMENTARY("SUPPLEMENTARY");

  private String value;

  AdaptationSetRole(String value) {
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
  public static AdaptationSetRole fromValue(String text) {
    for (AdaptationSetRole b : AdaptationSetRole.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

