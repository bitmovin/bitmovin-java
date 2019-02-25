package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
 */
public enum Av1AdaptiveQuantMode {
  
  /**
   * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
   */
  OFF("OFF"),
  
  /**
   * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
   */
  VARIANCE("VARIANCE"),
  
  /**
   * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
   */
  COMPLEXITY("COMPLEXITY"),
  
  /**
   * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
   */
  CYCLIC_REFRESH("CYCLIC_REFRESH"),
  
  /**
   * AV1 has a segment based feature that allows the encoder to adaptively change quantization parameter for each segment within a frame
   */
  DELTA_QUANT("DELTA_QUANT");

  private String value;

  Av1AdaptiveQuantMode(String value) {
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
  public static Av1AdaptiveQuantMode fromValue(String text) {
    for (Av1AdaptiveQuantMode b : Av1AdaptiveQuantMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

