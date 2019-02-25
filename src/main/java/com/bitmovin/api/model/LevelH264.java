package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
 */
public enum LevelH264 {
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L1("1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L1b("1b"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L1_1("1.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L1_2("1.2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L1_3("1.3"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L2("2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L2_1("2.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L2_2("2.2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L3("3"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L3_1("3.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L3_2("3.2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L4("4"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L4_1("4.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L4_2("4.2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L5("5"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L5_1("5.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/H.264/MPEG-4_AVC#Levels
   */
  L5_2("5.2");

  private String value;

  LevelH264(String value) {
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
  public static LevelH264 fromValue(String text) {
    for (LevelH264 b : LevelH264.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

