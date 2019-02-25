package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets OutputType
 */
public enum OutputType {
  
  
  AKAMAI_NETSTORAGE("AKAMAI_NETSTORAGE"),
  
  
  AZURE("AZURE"),
  
  
  GENERIC_S3("GENERIC_S3"),
  
  
  GCS("GCS"),
  
  
  FTP("FTP"),
  
  
  LOCAL("LOCAL"),
  
  
  S3("S3"),
  
  
  S3_ROLE_BASED("S3_ROLE_BASED"),
  
  
  SFTP("SFTP");

  private String value;

  OutputType(String value) {
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
  public static OutputType fromValue(String text) {
    for (OutputType b : OutputType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

