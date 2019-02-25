package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the method how fields are converted to frames
 */
public enum DeinterlaceMode {
  
  /**
   * Generate one frame for each frame
   */
  FRAME("FRAME"),
  
  /**
   * Generate one frame for each field
   */
  FIELD("FIELD"),
  
  /**
   * Like FRAME, but skip the spatial interlacing check
   */
  FRAME_NOSPATIAL("FRAME_NOSPATIAL"),
  
  /**
   * Like FIELD, but skip the spatial interlacing check
   */
  FIELD_NOSPATIAL("FIELD_NOSPATIAL");

  private String value;

  DeinterlaceMode(String value) {
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
  public static DeinterlaceMode fromValue(String text) {
    for (DeinterlaceMode b : DeinterlaceMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

