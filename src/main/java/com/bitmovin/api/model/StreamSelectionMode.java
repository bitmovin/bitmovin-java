package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StreamSelectionMode
 */
public enum StreamSelectionMode {
  
  /**
   * Automatically select a stream that fits the codec
   */
  AUTO("AUTO"),
  
  /**
   * Use the stream specified by the position attribute
   */
  POSITION_ABSOLUTE("POSITION_ABSOLUTE"),
  
  /**
   * Use the stream specified by position but count only video streams
   */
  VIDEO_RELATIVE("VIDEO_RELATIVE"),
  
  /**
   * Use the stream specified by position but count only audio streams
   */
  AUDIO_RELATIVE("AUDIO_RELATIVE");

  private String value;

  StreamSelectionMode(String value) {
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
  public static StreamSelectionMode fromValue(String text) {
    for (StreamSelectionMode b : StreamSelectionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

