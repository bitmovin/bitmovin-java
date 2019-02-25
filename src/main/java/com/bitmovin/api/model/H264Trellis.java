package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enables or disables Trellis quantization. NOTE: This requires cabac
 */
public enum H264Trellis {
  
  /**
   * Disabled
   */
  DISABLED("DISABLED"),
  
  /**
   * Enabled only on the final encode of a macro block
   */
  ENABLED_FINAL_MB("ENABLED_FINAL_MB"),
  
  /**
   * Enabled on all mode decisions
   */
  ENABLED_ALL("ENABLED_ALL");

  private String value;

  H264Trellis(String value) {
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
  public static H264Trellis fromValue(String text) {
    for (H264Trellis b : H264Trellis.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

