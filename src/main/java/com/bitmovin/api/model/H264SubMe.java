package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Subpixel motion estimation and mode decision
 */
public enum H264SubMe {
  
  /**
   * fullpel only (not recommended)
   */
  FULLPEL("FULLPEL"),
  
  /**
   * SAD mode decision, one qpel iteration
   */
  SAD("SAD"),
  
  /**
   * SATD mode decision
   */
  SATD("SATD"),
  
  /**
   * Progressively more qpel
   */
  QPEL3("QPEL3"),
  
  /**
   * Progressively more qpel
   */
  QPEL4("QPEL4"),
  
  /**
   * Progressively more qpel
   */
  QPEL5("QPEL5"),
  
  /**
   * RD mode decision for I/P+frames
   */
  RD_IP("RD_IP"),
  
  /**
   * RD mode decision for all frames
   */
  RD_ALL("RD_ALL"),
  
  /**
   * RD refinement for I/P+frames
   */
  RD_REF_IP("RD_REF_IP"),
  
  /**
   * RD refinement for all frames
   */
  RD_REF_ALL("RD_REF_ALL"),
  
  /**
   * QP+RD
   */
  QPRD("QPRD"),
  
  /**
   * Full RD: disable all early terminations
   */
  FULL_RD("FULL_RD");

  private String value;

  H264SubMe(String value) {
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
  public static H264SubMe fromValue(String text) {
    for (H264SubMe b : H264SubMe.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

