package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets MediaInfoType
 */
public enum MediaInfoType {
  
  
  AUDIO("AUDIO"),
  
  
  VIDEO("VIDEO"),
  
  
  SUBTITLES("SUBTITLES"),
  
  
  CLOSED_CAPTIONS("CLOSED_CAPTIONS"),
  
  
  VTT("VTT");

  private String value;

  MediaInfoType(String value) {
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
  public static MediaInfoType fromValue(String text) {
    for (MediaInfoType b : MediaInfoType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

