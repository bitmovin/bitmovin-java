package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets MinCodingUnitSize
 */
public enum MinCodingUnitSize {
  
  /**
   * minimum 8x8 CU
   */
  MCU_8x8("MCU_8x8"),
  
  /**
   * minimum 16x16 CU
   */
  MCU_16x16("MCU_16x16"),
  
  /**
   * minimum 32x32 CU
   */
  MCU_32x32("MCU_32x32");

  private String value;

  MinCodingUnitSize(String value) {
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
  public static MinCodingUnitSize fromValue(String text) {
    for (MinCodingUnitSize b : MinCodingUnitSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

