package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The unit in which the audio volume should be changed
 */
public enum AudioVolumeUnit {
  
  /**
   * Change the audio volume in percent, e.g., volume 100 will leave the audio volume unchanged, volume 50 will halve the audio volume.
   */
  PERCENT("PERCENT"),
  
  /**
   * Change the audio volume in decibels. E.g., volume 4 will increase audio volume by 4 decibels.
   */
  DB("DB");

  private String value;

  AudioVolumeUnit(String value) {
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
  public static AudioVolumeUnit fromValue(String text) {
    for (AudioVolumeUnit b : AudioVolumeUnit.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

