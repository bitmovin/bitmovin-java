package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Determines the algorithm used for scaling
 */
public enum ScalingAlgorithm {
  
  /**
   * Determines the algorithm used for scaling
   */
  FAST_BILINEAR("FAST_BILINEAR"),
  
  /**
   * Determines the algorithm used for scaling
   */
  BILINEAR("BILINEAR"),
  
  /**
   * Determines the algorithm used for scaling
   */
  BICUBIC("BICUBIC"),
  
  /**
   * Determines the algorithm used for scaling
   */
  EXPERIMENTAL("EXPERIMENTAL"),
  
  /**
   * Determines the algorithm used for scaling
   */
  NEAREST_NEIGHBOR("NEAREST_NEIGHBOR"),
  
  /**
   * Determines the algorithm used for scaling
   */
  AVERAGING_AREA("AVERAGING_AREA"),
  
  /**
   * Determines the algorithm used for scaling
   */
  BICUBIC_LUMA_BILINEAR_CHROMA("BICUBIC_LUMA_BILINEAR_CHROMA"),
  
  /**
   * Determines the algorithm used for scaling
   */
  GAUSS("GAUSS"),
  
  /**
   * Determines the algorithm used for scaling
   */
  SINC("SINC"),
  
  /**
   * Determines the algorithm used for scaling
   */
  LANCZOS("LANCZOS"),
  
  /**
   * Determines the algorithm used for scaling
   */
  SPLINE("SPLINE");

  private String value;

  ScalingAlgorithm(String value) {
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
  public static ScalingAlgorithm fromValue(String text) {
    for (ScalingAlgorithm b : ScalingAlgorithm.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

