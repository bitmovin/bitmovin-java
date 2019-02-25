package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enable adaptive quantization for sub-CTUs. This parameter specifies the minimum CU size at which QP can be adjusted.
 */
public enum QuantizationGroupSize {
  
  /**
   * 8x8
   */
  QGS_8x8("QGS_8x8"),
  
  /**
   * 16x16
   */
  QGS_16x16("QGS_16x16"),
  
  /**
   * 32x32
   */
  QGS_32x32("QGS_32x32"),
  
  /**
   * 64x64
   */
  QGS_64x64("QGS_64x64");

  private String value;

  QuantizationGroupSize(String value) {
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
  public static QuantizationGroupSize fromValue(String text) {
    for (QuantizationGroupSize b : QuantizationGroupSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

