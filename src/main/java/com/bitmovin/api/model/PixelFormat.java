package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The pixel format to be set
 */
public enum PixelFormat {
  
  /**
   * The pixel format to be set
   */
  YUV410P("YUV410P"),
  
  /**
   * The pixel format to be set
   */
  YUV411P("YUV411P"),
  
  /**
   * The pixel format to be set
   */
  YUV420P("YUV420P"),
  
  /**
   * The pixel format to be set
   */
  YUV422P("YUV422P"),
  
  /**
   * The pixel format to be set
   */
  YUV440P("YUV440P"),
  
  /**
   * The pixel format to be set
   */
  YUV444P("YUV444P"),
  
  /**
   * The pixel format to be set
   */
  YUVJ411P("YUVJ411P"),
  
  /**
   * The pixel format to be set
   */
  YUVJ420P("YUVJ420P"),
  
  /**
   * The pixel format to be set
   */
  YUVJ422P("YUVJ422P"),
  
  /**
   * The pixel format to be set
   */
  YUVJ440P("YUVJ440P"),
  
  /**
   * The pixel format to be set
   */
  YUVJ444P("YUVJ444P"),
  
  /**
   * The pixel format to be set
   */
  YUV420P10LE("YUV420P10LE"),
  
  /**
   * The pixel format to be set
   */
  YUV422P10LE("YUV422P10LE"),
  
  /**
   * The pixel format to be set
   */
  YUV440P10LE("YUV440P10LE"),
  
  /**
   * The pixel format to be set
   */
  YUV444P10LE("YUV444P10LE"),
  
  /**
   * The pixel format to be set
   */
  YUV420P12LE("YUV420P12LE"),
  
  /**
   * The pixel format to be set
   */
  YUV422P12LE("YUV422P12LE"),
  
  /**
   * The pixel format to be set
   */
  YUV440P12LE("YUV440P12LE"),
  
  /**
   * The pixel format to be set
   */
  YUV444P12LE("YUV444P12LE"),
  
  /**
   * The pixel format to be set
   */
  YUV420P10BE("YUV420P10BE"),
  
  /**
   * The pixel format to be set
   */
  YUV422P10BE("YUV422P10BE"),
  
  /**
   * The pixel format to be set
   */
  YUV440P10BE("YUV440P10BE"),
  
  /**
   * The pixel format to be set
   */
  YUV444P10BE("YUV444P10BE"),
  
  /**
   * The pixel format to be set
   */
  YUV420P12BE("YUV420P12BE"),
  
  /**
   * The pixel format to be set
   */
  YUV422P12BE("YUV422P12BE"),
  
  /**
   * The pixel format to be set
   */
  YUV440P12BE("YUV440P12BE"),
  
  /**
   * The pixel format to be set
   */
  YUV444P12BE("YUV444P12BE");

  private String value;

  PixelFormat(String value) {
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
  public static PixelFormat fromValue(String text) {
    for (PixelFormat b : PixelFormat.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

