package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StreamConditionsMode
 */
public enum StreamConditionsMode {
  
  /**
   * The whole muxing will be omitted if one or more of its stream conditions are not fulfilled
   */
  DROP_MUXING("DROP_MUXING"),
  
  /**
   * Streams not fulfilling the stream conditions will be omitted from the muxing. The muxing will be omitted if there is no stream meeting the conditions.
   */
  DROP_STREAM("DROP_STREAM");

  private String value;

  StreamConditionsMode(String value) {
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
  public static StreamConditionsMode fromValue(String text) {
    for (StreamConditionsMode b : StreamConditionsMode.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

