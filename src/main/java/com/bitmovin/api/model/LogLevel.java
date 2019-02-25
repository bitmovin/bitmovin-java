package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets LogLevel
 */
public enum LogLevel {
  
  
  TRACE("TRACE"),
  
  
  DEBUG("DEBUG"),
  
  
  INFO("INFO"),
  
  
  WARN("WARN"),
  
  
  ERROR("ERROR"),
  
  
  FATAL("FATAL"),
  
  
  OFF("OFF");

  private String value;

  LogLevel(String value) {
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
  public static LogLevel fromValue(String text) {
    for (LogLevel b : LogLevel.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

