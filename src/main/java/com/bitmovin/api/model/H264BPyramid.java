package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Keep some B-frames as references
 */
public enum H264BPyramid {
  
  /**
   * Do not keep b-frame references
   */
  NONE("NONE"),
  
  /**
   * Use a strictly hierarchical pyramid
   */
  STRICT("STRICT"),
  
  /**
   * Non-strict, recommended (increases decoding picture buffer)
   */
  NORMAL("NORMAL");

  private String value;

  H264BPyramid(String value) {
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
  public static H264BPyramid fromValue(String text) {
    for (H264BPyramid b : H264BPyramid.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

