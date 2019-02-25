package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets DecodingErrorMode
 */
public enum DecodingErrorMode {
  
  /**
   * Encoding will fail, if there are errors during decoding of this stream
   */
  FAIL_ON_ERROR("FAIL_ON_ERROR"),
  
  /**
   * If a frame is undecodable, other frames will be duplicated to compensate for the lost frame. The encoding will not fail, but there will be warnings about which frames could not be decoded.
   */
  DUPLICATE_FRAMES("DUPLICATE_FRAMES");

  private String value;

  DecodingErrorMode(String value) {
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
  public static DecodingErrorMode fromValue(String text) {
    for (DecodingErrorMode b : DecodingErrorMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

