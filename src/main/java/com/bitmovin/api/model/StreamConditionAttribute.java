package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The attribute that should be checked
 */
public enum StreamConditionAttribute {
  
  /**
   * Type of the stream available values: VIDEO, AUDIO
   */
  MEDIA_TYPE("MEDIA_TYPE"),
  
  /**
   * Specific stream id of encoding
   */
  STREAM_ID("STREAM_ID"),
  
  /**
   * Average bits read
   */
  BITS_READ_AVG("BITS_READ_AVG"),
  
  /**
   * Minimum bits read
   */
  BITS_READ_MIN("BITS_READ_MIN"),
  
  /**
   * Maximum bits read
   */
  BITS_READ_MAX("BITS_READ_MAX"),
  
  /**
   * Average samples read
   */
  SAMPLES_READ_AVG("SAMPLES_READ_AVG"),
  
  /**
   * Minimum samples read
   */
  SAMPLES_READ_MIN("SAMPLES_READ_MIN"),
  
  /**
   * Maximum samples read
   */
  SAMPLES_READ_MAX("SAMPLES_READ_MAX"),
  
  /**
   * Specify a width
   */
  WIDTH("WIDTH"),
  
  /**
   * Specify a height
   */
  HEIGHT("HEIGHT"),
  
  /**
   * Specify a codec
   */
  CODEC("CODEC");

  private String value;

  StreamConditionAttribute(String value) {
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
  public static StreamConditionAttribute fromValue(String text) {
    for (StreamConditionAttribute b : StreamConditionAttribute.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

