package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
 */
public enum LevelH265 {
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L1("1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L2("2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L2_1("2.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L3("3"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L3_1("3.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L4("4"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L4_1("4.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L5("5"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L5_1("5.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L5_2("5.2"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L6("6"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L6_1("6.1"),
  
  /**
   * Specified set of constraints that indicate a degree of required decoder performance for a profile, see: https://en.wikipedia.org/wiki/High_Efficiency_Video_Coding_tiers_and_levels
   */
  L6_2("6.2");

  private String value;

  LevelH265(String value) {
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
  public static LevelH265 fromValue(String text) {
    for (LevelH265 b : LevelH265.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

