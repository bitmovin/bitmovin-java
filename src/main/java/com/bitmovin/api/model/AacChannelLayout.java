package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AacChannelLayout
 */
public enum AacChannelLayout {
  
  /**
   * No channel layout
   */
  NONE("NONE"),
  
  /**
   * Channel layout Mono
   */
  MONO("MONO"),
  
  /**
   * Channel layout Stereo
   */
  CL_STEREO("STEREO"),
  
  /**
   * Channel layout Surround
   */
  CL_SURROUND("SURROUND"),
  
  /**
   * Channel layout 4.0
   */
  CL_4_0("4.0"),
  
  /**
   * Channel layout 5.0 Back
   */
  CL_5_0_BACK("5.0_BACK"),
  
  /**
   * Channel layout 5.1 Back
   */
  CL_5_1_BACK("5.1_BACK"),
  
  /**
   * Channel layout 7.1
   */
  CL_7_1("7.1"),
  
  /**
   * Channel layout 7.1 Wide Back
   */
  CL_7_1_WIDE_BACK("7.1_WIDE_BACK");

  private String value;

  AacChannelLayout(String value) {
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
  public static AacChannelLayout fromValue(String text) {
    for (AacChannelLayout b : AacChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

