package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets LimitReferences
 */
public enum LimitReferences {
  
  /**
   * Disables limiting references
   */
  DISABLED("DISABLED"),
  
  /**
   * Will limit the references analyzed at the current depth based on the references used to code the 4 sub-blocks at the next depth.
   */
  DEPTH("DEPTH"),
  
  /**
   * The rectangular and asymmetrical partitions will only use references selected by the 2Nx2N motion search.
   */
  CU("CU"),
  
  /**
   * The 2Nx2N motion search at each depth will only use references from the split CUs and the rect/amp motion searches at that depth will only use the reference(s) selected by 2Nx2N.
   */
  DEPTH_AND_CU("DEPTH_AND_CU");

  private String value;

  LimitReferences(String value) {
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
  public static LimitReferences fromValue(String text) {
    for (LimitReferences b : LimitReferences.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

