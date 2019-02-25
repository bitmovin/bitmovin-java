package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets VideoFormat
 */
public enum VideoFormat {
  
  
  UNDEFINED("UNDEFINED"),
  
  
  COMPONENT("COMPONENT"),
  
  
  PAL("PAL"),
  
  
  NTSC("NTSC"),
  
  
  SECAM("SECAM"),
  
  
  MAC("MAC");

  private String value;

  VideoFormat(String value) {
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
  public static VideoFormat fromValue(String text) {
    for (VideoFormat b : VideoFormat.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

