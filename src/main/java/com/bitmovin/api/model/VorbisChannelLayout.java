package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets VorbisChannelLayout
 */
public enum VorbisChannelLayout {
  
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
   * Channel Layout 2.1
   */
  CL_2_1("2.1"),
  
  /**
   * Channel Layout 2.2
   */
  CL_2_2("2.2"),
  
  /**
   * Channel Layout 3.1
   */
  CL_3_1("3.1"),
  
  /**
   * Channel Layout 4.0
   */
  CL_4_0("4.0"),
  
  /**
   * Channel Layout 5.1
   */
  CL_5_1("5.1"),
  
  /**
   * Channel Layout 5.1 Back
   */
  CL_5_1_BACK("5.1_BACK");

  private String value;

  VorbisChannelLayout(String value) {
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
  public static VorbisChannelLayout fromValue(String text) {
    for (VorbisChannelLayout b : VorbisChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

