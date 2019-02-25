package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The attribute that should be checked
 */
public enum ConditionAttribute {
  
  /**
   * Height of the input
   */
  HEIGHT("HEIGHT"),
  
  /**
   * Width of the input
   */
  WIDTH("WIDTH"),
  
  /**
   * Bitrate of the input
   */
  BITRATE("BITRATE"),
  
  /**
   * Frames per second of the input
   */
  FPS("FPS"),
  
  /**
   * Aspect ratio of the input (greater 1 &#x3D; landscape; smaller 1 &#x3D; portrait)
   */
  ASPECTRATIO("ASPECTRATIO"),
  
  /**
   * Input stream is present (boolean)
   */
  INPUTSTREAM("INPUTSTREAM"),
  
  /**
   * The language of the audio stream (string)
   */
  LANGUAGE("LANGUAGE"),
  
  /**
   * The channel format of the audio stream (string)
   */
  CHANNELFORMAT("CHANNELFORMAT"),
  
  /**
   * The channel layout of the audio stream (integer)
   */
  CHANNELLAYOUT("CHANNELLAYOUT"),
  
  /**
   * The total numbers of streams in the input file (integer)
   */
  STREAMCOUNT("STREAMCOUNT"),
  
  /**
   * The total numbers of audio streams in the input file (integer)
   */
  AUDIOSTREAMCOUNT("AUDIOSTREAMCOUNT"),
  
  /**
   * The total numbers of video streams in the input file (integer)
   */
  VIDEOSTREAMCOUNT("VIDEOSTREAMCOUNT"),
  
  /**
   * The duration of the input file (double)
   */
  DURATION("DURATION");

  private String value;

  ConditionAttribute(String value) {
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
  public static ConditionAttribute fromValue(String text) {
    for (ConditionAttribute b : ConditionAttribute.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

