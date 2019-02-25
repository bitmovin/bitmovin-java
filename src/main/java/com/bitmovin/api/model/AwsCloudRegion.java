package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AwsCloudRegion
 */
public enum AwsCloudRegion {
  
  
  US_EAST_1("US_EAST_1"),
  
  
  US_EAST_2("US_EAST_2"),
  
  
  US_WEST_1("US_WEST_1"),
  
  
  US_WEST_2("US_WEST_2"),
  
  
  EU_WEST_1("EU_WEST_1"),
  
  
  EU_CENTRAL_1("EU_CENTRAL_1"),
  
  
  AP_SOUTHEAST_1("AP_SOUTHEAST_1"),
  
  
  AP_SOUTHEAST_2("AP_SOUTHEAST_2"),
  
  
  AP_NORTHEAST_1("AP_NORTHEAST_1"),
  
  
  AP_NORTHEAST_2("AP_NORTHEAST_2"),
  
  
  AP_SOUTH_1("AP_SOUTH_1"),
  
  
  SA_EAST_1("SA_EAST_1");

  private String value;

  AwsCloudRegion(String value) {
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
  public static AwsCloudRegion fromValue(String text) {
    for (AwsCloudRegion b : AwsCloudRegion.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

