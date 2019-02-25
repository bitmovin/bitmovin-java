package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * How to interleave the input frames
 */
public enum InterlaceMode {
  
  /**
   * Use the top field from odd frames and bottom field from even frames
   */
  TOP("TOP"),
  
  /**
   * Use the bottom field from odd frames and top field from even frames
   */
  BOTTOM("BOTTOM"),
  
  /**
   * Drop all even frames
   */
  DROP_EVEN("DROP_EVEN"),
  
  /**
   * Drop all odd frames
   */
  DROP_ODD("DROP_ODD"),
  
  /**
   * Double the height of all frames by inserting alternating black lines
   */
  PAD("PAD"),
  
  /**
   * Double the frame rate. Extra frames use the second field of the next frame, alternating with the first field of the previous frame
   */
  INTERLACE_X2("INTERLACE_X2"),
  
  /**
   * Move odd frames into the upper field and even frames into the lower field
   */
  MERGE("MERGE"),
  
  /**
   * Double the height of all frames by inserting the lines of the next frame as second field
   */
  MERGE_X2("MERGE_X2");

  private String value;

  InterlaceMode(String value) {
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
  public static InterlaceMode fromValue(String text) {
    for (InterlaceMode b : InterlaceMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

