package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ChannelLayout
 */
public enum ChannelLayout {
  
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
  CL_STEREO("STEREO");

  private String value;

  ChannelLayout(String value) {
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
  public static ChannelLayout fromValue(String text) {
    for (ChannelLayout b : ChannelLayout.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

