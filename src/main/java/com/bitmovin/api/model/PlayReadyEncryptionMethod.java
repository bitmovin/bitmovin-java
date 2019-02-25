package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Encryption method
 */
public enum PlayReadyEncryptionMethod {
  
  /**
   * Encryption method
   */
  MPEG_CENC("MPEG_CENC"),
  
  /**
   * Encryption method
   */
  PIFF_CTR("PIFF_CTR");

  private String value;

  PlayReadyEncryptionMethod(String value) {
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
  public static PlayReadyEncryptionMethod fromValue(String text) {
    for (PlayReadyEncryptionMethod b : PlayReadyEncryptionMethod.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

