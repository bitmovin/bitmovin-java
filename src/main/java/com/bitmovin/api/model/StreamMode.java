package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StreamMode
 */
public enum StreamMode {
  
  /**
   * Standard encoding. This is used to configure renditions that must show up in the output, i.e. will get encoded exactly as configured.
   */
  STANDARD("STANDARD"),
  
  /**
   * Template for Per-Title encoding. This is used to define encoding settings for a given resolution when Per-Title encoding is enabled. Additionally, it allows to define which resolutions should be considered by Per-Title encoding.
   */
  PER_TITLE_TEMPLATE("PER_TITLE_TEMPLATE"),
  
  /**
   * Same as PER_TITLE_TEMPLATE, but it will be ensured that the configured resolution will be present in the Per-Title result.
   */
  PER_TITLE_TEMPLATE_FIXED_RESOLUTION("PER_TITLE_TEMPLATE_FIXED_RESOLUTION"),
  
  /**
   * Same as PER_TITLE_TEMPLATE, but it will be ensured that the configured resolution and bitrate range will be present in the Per-Title result.
   */
  PER_TITLE_TEMPLATE_FIXED_RESOLUTION_AND_BITRATE("PER_TITLE_TEMPLATE_FIXED_RESOLUTION_AND_BITRATE"),
  
  /**
   * Once the Per-Title encoding is done, the generated streams will have this mode set.
   */
  PER_TITLE_RESULT("PER_TITLE_RESULT");

  private String value;

  StreamMode(String value) {
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
  public static StreamMode fromValue(String text) {
    for (StreamMode b : StreamMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

