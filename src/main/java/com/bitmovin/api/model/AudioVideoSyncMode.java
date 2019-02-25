package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AudioVideoSyncMode
 */
public enum AudioVideoSyncMode {
  
  /**
   * Default audio video sync handling
   */
  STANDARD("STANDARD"),
  
  /**
   * Adds a sync at the start of the file. Useful if the source file was cut out of already encoded content.
   */
  RESYNC_AT_START("RESYNC_AT_START");

  private String value;

  AudioVideoSyncMode(String value) {
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
  public static AudioVideoSyncMode fromValue(String text) {
    for (AudioVideoSyncMode b : AudioVideoSyncMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

