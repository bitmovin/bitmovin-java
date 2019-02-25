package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Ac3ChannelLayout
 */
public enum Ac3ChannelLayout {
  
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
   * Channel layout Quad
   */
  CL_QUAD("QUAD"),
  
  /**
   * Channel layout 2.1
   */
  CL_2_1("2.1"),
  
  /**
   * Channel layout 2.2
   */
  CL_2_2("2.2"),
  
  /**
   * Channel layout 3.1
   */
  CL_3_1("3.1"),
  
  /**
   * Channel layout 4.0
   */
  CL_4_0("4.0"),
  
  /**
   * Channel layout 4.1
   */
  CL_4_1("4.1"),
  
  /**
   * Channel layout 5.0
   */
  CL_5_0("5.0"),
  
  /**
   * Channel layout 5.0 Back
   */
  CL_5_0_BACK("5.0_BACK"),
  
  /**
   * Channel layout 5.1
   */
  CL_5_1("5.1"),
  
  /**
   * Channel layout 5.1 Back
   */
  CL_5_1_BACK("5.1_BACK");

  private String value;

  Ac3ChannelLayout(String value) {
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
  public static Ac3ChannelLayout fromValue(String text) {
    for (Ac3ChannelLayout b : Ac3ChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

