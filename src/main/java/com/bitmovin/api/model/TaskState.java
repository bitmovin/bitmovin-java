package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TaskState
 */
public enum TaskState {
  
  
  ENQUEUED("ENQUEUED"),
  
  
  ASSIGNED("ASSIGNED"),
  
  
  PREPARED("PREPARED"),
  
  
  INPROGRESS("INPROGRESS"),
  
  
  FINISHED("FINISHED"),
  
  
  ERROR("ERROR"),
  
  
  DEQUEUED("DEQUEUED");

  private String value;

  TaskState(String value) {
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
  public static TaskState fromValue(String text) {
    for (TaskState b : TaskState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

