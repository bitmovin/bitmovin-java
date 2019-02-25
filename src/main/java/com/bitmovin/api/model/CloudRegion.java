package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CloudRegion
 */
public enum CloudRegion {
  
  
  AWS_US_EAST_1("AWS_US_EAST_1"),
  
  
  AWS_US_EAST_2("AWS_US_EAST_2"),
  
  
  AWS_US_WEST_1("AWS_US_WEST_1"),
  
  
  AWS_US_WEST_2("AWS_US_WEST_2"),
  
  
  AWS_EU_WEST_1("AWS_EU_WEST_1"),
  
  
  AWS_EU_CENTRAL_1("AWS_EU_CENTRAL_1"),
  
  
  AWS_AP_SOUTHEAST_1("AWS_AP_SOUTHEAST_1"),
  
  
  AWS_AP_SOUTHEAST_2("AWS_AP_SOUTHEAST_2"),
  
  
  AWS_AP_NORTHEAST_1("AWS_AP_NORTHEAST_1"),
  
  
  AWS_AP_NORTHEAST_2("AWS_AP_NORTHEAST_2"),
  
  
  AWS_AP_SOUTH_1("AWS_AP_SOUTH_1"),
  
  
  AWS_SA_EAST_1("AWS_SA_EAST_1"),
  
  
  GOOGLE_US_CENTRAL_1("GOOGLE_US_CENTRAL_1"),
  
  
  GOOGLE_US_EAST_1("GOOGLE_US_EAST_1"),
  
  
  GOOGLE_ASIA_EAST_1("GOOGLE_ASIA_EAST_1"),
  
  
  GOOGLE_EUROPE_WEST_1("GOOGLE_EUROPE_WEST_1"),
  
  
  GOOGLE_US_WEST_1("GOOGLE_US_WEST_1"),
  
  
  AZURE_EUROPE_WEST("AZURE_EUROPE_WEST"),
  
  
  AZURE_US_WEST2("AZURE_US_WEST2"),
  
  
  AZURE_US_EAST("AZURE_US_EAST"),
  
  
  AZURE_AUSTRALIA_SOUTHEAST("AZURE_AUSTRALIA_SOUTHEAST"),
  
  
  NORTH_AMERICA("NORTH_AMERICA"),
  
  
  SOUTH_AMERICA("SOUTH_AMERICA"),
  
  
  EUROPE("EUROPE"),
  
  
  AFRICA("AFRICA"),
  
  
  ASIA("ASIA"),
  
  
  AUSTRALIA("AUSTRALIA"),
  
  
  AWS("AWS"),
  
  
  GOOGLE("GOOGLE"),
  
  
  KUBERNETES("KUBERNETES"),
  
  
  EXTERNAL("EXTERNAL"),
  
  
  AUTO("AUTO");

  private String value;

  CloudRegion(String value) {
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
  public static CloudRegion fromValue(String text) {
    for (CloudRegion b : CloudRegion.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

