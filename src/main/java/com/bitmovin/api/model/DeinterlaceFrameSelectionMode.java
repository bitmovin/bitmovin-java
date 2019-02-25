package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies which frames to deinterlace
 */
public enum DeinterlaceFrameSelectionMode {
  
  /**
   * Deinterlace all frames
   */
  ALL("ALL"),
  
  /**
   * Only deinterlace frames marked as interlaced. This option is only supported for deinterlace modes &#39;FRAME&#39; and &#39;FRAME_NOSPATIAL&#39;
   */
  INTERLACED("INTERLACED");

  private String value;

  DeinterlaceFrameSelectionMode(String value) {
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
  public static DeinterlaceFrameSelectionMode fromValue(String text) {
    for (DeinterlaceFrameSelectionMode b : DeinterlaceFrameSelectionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

