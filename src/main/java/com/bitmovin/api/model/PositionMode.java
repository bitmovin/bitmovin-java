package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PositionMode
 */
public enum PositionMode {
  
  /**
   * The custom tag will be inserted in the manifest at a certain keyframe id and segment cut. (https://bitmovin.com/encoding-documentation/bitmovin-api/#/reference/encoding/encodings/create-keyframes)
   */
  KEYFRAME("KEYFRAME"),
  
  /**
   * The custom tag will be inserted before the segment that is closest to that time (in seconds).
   */
  TIME("TIME"),
  
  /**
   * The custom tag will be inserted before the specified segment number.
   */
  SEGMENT("SEGMENT");

  private String value;

  PositionMode(String value) {
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
  public static PositionMode fromValue(String text) {
    for (PositionMode b : PositionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

