package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Partitions to consider. Analyzing more partition options improves quality at the cost of speed.
 */
public enum H264Partition {
  
  /**
   * Consider no macroblocks
   */
  NONE("NONE"),
  
  /**
   * Consider P-macroblocks with size 8x8, 16X8, 8X16
   */
  P8X8("P8X8"),
  
  /**
   * Consider P-macroblocks with size 4x4, 8X4, 4x8
   */
  P4X4("P4X4"),
  
  /**
   * Consider B-macroblocks with size 8x8, 16X8, 8X16
   */
  B8X8("B8X8"),
  
  /**
   * Consider I-macroblocks with size 8x8
   */
  I8X8("I8X8"),
  
  /**
   * Consider I-macroblocks with size 4x4
   */
  I4X4("I4X4"),
  
  /**
   * Consider all possible sizes of macroblocks
   */
  ALL("ALL");

  private String value;

  H264Partition(String value) {
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
  public static H264Partition fromValue(String text) {
    for (H264Partition b : H264Partition.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

