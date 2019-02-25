package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets LiveEncodingEventName
 */
public enum LiveEncodingEventName {
  
  /**
   * First connection of the ingest
   */
  FIRST_CONNECT("FIRST_CONNECT"),
  
  /**
   * Ingest has disconnected
   */
  DISCONNECT("DISCONNECT"),
  
  /**
   * Ingest has reconnected
   */
  RECONNECT("RECONNECT"),
  
  /**
   * Audio and video are out of sync and resyncing occurred. Usually happens after a RECONNECT event.
   */
  RESYNCING("RESYNCING"),
  
  /**
   * Ingest is connected but doesn&#39;t send any data
   */
  IDLE("IDLE"),
  
  /**
   * Error occurred, please see the errorMessage for further details
   */
  ERROR("ERROR");

  private String value;

  LiveEncodingEventName(String value) {
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
  public static LiveEncodingEventName fromValue(String text) {
    for (LiveEncodingEventName b : LiveEncodingEventName.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

