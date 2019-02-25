package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The color space to be applied
 */
public enum ColorSpace {
  
  /**
   * The color space to be applied
   */
  UNSPECIFIED("UNSPECIFIED"),
  
  /**
   * The color space to be applied
   */
  RGB("RGB"),
  
  /**
   * The color space to be applied
   */
  BT709("BT709"),
  
  /**
   * The color space to be applied
   */
  FCC("FCC"),
  
  /**
   * The color space to be applied
   */
  BT470BG("BT470BG"),
  
  /**
   * The color space to be applied
   */
  SMPTE170M("SMPTE170M"),
  
  /**
   * The color space to be applied
   */
  SMPTE240M("SMPTE240M"),
  
  /**
   * The color space to be applied
   */
  YCGCO("YCGCO"),
  
  /**
   * The color space to be applied
   */
  YCOCG("YCOCG"),
  
  /**
   * The color space to be applied
   */
  BT2020_NCL("BT2020_NCL"),
  
  /**
   * The color space to be applied
   */
  BT2020_CL("BT2020_CL"),
  
  /**
   * The color space to be applied
   */
  SMPTE2085("SMPTE2085");

  private String value;

  ColorSpace(String value) {
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
  public static ColorSpace fromValue(String text) {
    for (ColorSpace b : ColorSpace.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

