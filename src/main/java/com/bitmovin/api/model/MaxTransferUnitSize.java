package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets MaxTransferUnitSize
 */
public enum MaxTransferUnitSize {
  
  /**
   * maximum 4x4 TU
   */
  MTU_4x4("MTU_4x4"),
  
  /**
   * maximum 8x8 TU
   */
  MTU_8x8("MTU_8x8"),
  
  /**
   * maximum 16x16 TU
   */
  MTU_16x16("MTU_16x16"),
  
  /**
   * maximum 32x32 TU
   */
  MTU_32x32("MTU_32x32");

  private String value;

  MaxTransferUnitSize(String value) {
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
  public static MaxTransferUnitSize fromValue(String text) {
    for (MaxTransferUnitSize b : MaxTransferUnitSize.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

