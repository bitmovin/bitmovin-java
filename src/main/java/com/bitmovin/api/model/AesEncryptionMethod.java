package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Detailed encryption method
 */
public enum AesEncryptionMethod {
  
  /**
   * Detailed encryption method
   */
  SAMPLE_AES("SAMPLE_AES"),
  
  /**
   * Detailed encryption method
   */
  AES_128("AES_128");

  private String value;

  AesEncryptionMethod(String value) {
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
  public static AesEncryptionMethod fromValue(String text) {
    for (AesEncryptionMethod b : AesEncryptionMethod.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

