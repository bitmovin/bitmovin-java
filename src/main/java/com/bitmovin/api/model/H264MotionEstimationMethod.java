package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Integer pixel motion estimation method
 */
public enum H264MotionEstimationMethod {
  
  /**
   * diamond search, radius 1 (fast)
   */
  DIA("DIA"),
  
  /**
   * hexagonal search, radius 2
   */
  HEX("HEX"),
  
  /**
   * uneven multi-hexagon search
   */
  UMH("UMH"),
  
  /**
   * exhaustive search
   */
  ESA("ESA"),
  
  /**
   * hadamard exhaustive search (slow)
   */
  TESA("TESA");

  private String value;

  H264MotionEstimationMethod(String value) {
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
  public static H264MotionEstimationMethod fromValue(String text) {
    for (H264MotionEstimationMethod b : H264MotionEstimationMethod.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

