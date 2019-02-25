package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets LiveEncodingStatus
 */
public enum LiveEncodingStatus {
  
  
  CONNECTED("CONNECTED"),
  
  
  DISCONNECTED("DISCONNECTED"),
  
  
  WAITING_FOR_FIRST_CONNECT("WAITING_FOR_FIRST_CONNECT"),
  
  
  ERROR("ERROR"),
  
  
  NOT_AVAILABLE("NOT_AVAILABLE"),
  
  
  FINISHED("FINISHED");

  private String value;

  LiveEncodingStatus(String value) {
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
  public static LiveEncodingStatus fromValue(String text) {
    for (LiveEncodingStatus b : LiveEncodingStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

