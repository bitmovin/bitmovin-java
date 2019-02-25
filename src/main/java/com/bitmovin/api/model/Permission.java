package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Permission to assign.
 */
public enum Permission {
  
  /**
   * Permission to call http GET on the defined resource.
   */
  GET("GET"),
  
  /**
   * Permission to call http DELETE on the defined resource.
   */
  DELETE("DELETE"),
  
  /**
   * Permission to call http POST on the defined resource.
   */
  POST("POST"),
  
  /**
   * Permission to call http PUT on the defined resource.
   */
  PUT("PUT"),
  
  /**
   * Permission to call http PATCH on the defined resource.
   */
  PATCH("PATCH");

  private String value;

  Permission(String value) {
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
  public static Permission fromValue(String text) {
    for (Permission b : Permission.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

