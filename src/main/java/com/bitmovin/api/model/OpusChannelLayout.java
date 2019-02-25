package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets OpusChannelLayout
 */
public enum OpusChannelLayout {
  
  /**
   * No channel Layout
   */
  NONE("NONE"),
  
  /**
   * Channel Layout Mono
   */
  MONO("MONO"),
  
  /**
   * Channel Layout Stereo
   */
  CL_STEREO("STEREO"),
  
  /**
   * Channel Layout Surround
   */
  CL_SURROUND("SURROUND"),
  
  /**
   * Channel Layout Quad
   */
  CL_QUAD("QUAD"),
  
  /**
   * Channel Layout 4.1
   */
  CL_4_1("4.1"),
  
  /**
   * Channel Layout 5.0 Back
   */
  CL_5_0_BACK("5.0_BACK"),
  
  /**
   * Channel Layout 5.1 Back
   */
  XCL_5_1_BACK("5.1_BACK"),
  
  /**
   * Channel Layout 6.1
   */
  CL_6_1("6.1"),
  
  /**
   * Channel Layout 7.1
   */
  CL_7_1("7.1");

  private String value;

  OpusChannelLayout(String value) {
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
  public static OpusChannelLayout fromValue(String text) {
    for (OpusChannelLayout b : OpusChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

