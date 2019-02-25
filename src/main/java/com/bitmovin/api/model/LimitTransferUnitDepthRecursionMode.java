package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enables early exit from transfer unit depth recursion, for inter coded blocks.
 */
public enum LimitTransferUnitDepthRecursionMode {
  
  /**
   * Disable early exit from transfer unit dept recursion
   */
  DISABLED("DISABLED"),
  
  /**
   * Decides to recurse to next higher depth based on cost comparison of full size transfer unit and split transfer unit.
   */
  LEVEL_1("LEVEL_1"),
  
  /**
   * Based on first split sub TUs depth, limits recursion of other split sub TUs.
   */
  LEVEL_2("LEVEL_2"),
  
  /**
   * Based on the average depth of the co-located and the neighbor CUs TU depth, limits recursion of the current CU.
   */
  LEVEL_3("LEVEL_3"),
  
  /**
   * Uses the depth of the co-located CUs TU depth to limit the 1st sub TU depth. The 1st sub TU depth is taken as the limiting depth for the other sub TUs.
   */
  LEVEL_4("LEVEL_4");

  private String value;

  LimitTransferUnitDepthRecursionMode(String value) {
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
  public static LimitTransferUnitDepthRecursionMode fromValue(String text) {
    for (LimitTransferUnitDepthRecursionMode b : LimitTransferUnitDepthRecursionMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

