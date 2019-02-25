package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets GoogleCloudRegion
 */
public enum GoogleCloudRegion {
  
  
  US_CENTRAL_1("US_CENTRAL_1"),
  
  
  US_EAST_1("US_EAST_1"),
  
  
  ASIA_EAST_1("ASIA_EAST_1"),
  
  
  EUROPE_WEST_1("EUROPE_WEST_1"),
  
  
  US_WEST_1("US_WEST_1");

  private String value;

  GoogleCloudRegion(String value) {
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
  public static GoogleCloudRegion fromValue(String text) {
    for (GoogleCloudRegion b : GoogleCloudRegion.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

