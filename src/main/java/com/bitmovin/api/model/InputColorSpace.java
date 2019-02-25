package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
 */
public enum InputColorSpace {
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  UNSPECIFIED("UNSPECIFIED"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  RGB("RGB"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  BT709("BT709"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  FCC("FCC"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  BT470BG("BT470BG"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  SMPTE170M("SMPTE170M"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  SMPTE240M("SMPTE240M"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  YCGCO("YCGCO"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  YCOCG("YCOCG"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  BT2020_NCL("BT2020_NCL"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  BT2020_CL("BT2020_CL"),
  
  /**
   * Override the color space detected in the input file. If not set the input color space will be automatically detected if possible.
   */
  SMPTE2085("SMPTE2085");

  private String value;

  InputColorSpace(String value) {
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
  public static InputColorSpace fromValue(String text) {
    for (InputColorSpace b : InputColorSpace.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

