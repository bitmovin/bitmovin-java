package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Channel layout of this audio mix
 */
public enum AudioMixChannelLayout {
  
  /**
   * Channel layout of this audio mix
   */
  NONE("NONE"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_MONO("CL_MONO"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_STEREO("CL_STEREO"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_SURROUND("CL_SURROUND"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_QUAD("CL_QUAD"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_OCTAGONAL("CL_OCTAGONAL"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_HEXAGONAL("CL_HEXAGONAL"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_STEREO_DOWNMIX("CL_STEREO_DOWNMIX"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_2_1("CL_2_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_2_2("CL_2_2"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_3_1("CL_3_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_4_0("CL_4_0"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_4_1("CL_4_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_5_0("CL_5_0"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_5_1("CL_5_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_5_0_BACK("CL_5_0_BACK"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_5_1_BACK("CL_5_1_BACK"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_6_0("CL_6_0"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_6_0_FRONT("CL_6_0_FRONT"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_6_1("CL_6_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_6_1_BACK("CL_6_1_BACK"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_6_1_FRONT("CL_6_1_FRONT"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_7_0("CL_7_0"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_7_0_FRONT("CL_7_0_FRONT"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_7_1("CL_7_1"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_7_1_WIDE("CL_7_1_WIDE"),
  
  /**
   * Channel layout of this audio mix
   */
  CL_7_1_WIDE_BACK("CL_7_1_WIDE_BACK");

  private String value;

  AudioMixChannelLayout(String value) {
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
  public static AudioMixChannelLayout fromValue(String text) {
    for (AudioMixChannelLayout b : AudioMixChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

