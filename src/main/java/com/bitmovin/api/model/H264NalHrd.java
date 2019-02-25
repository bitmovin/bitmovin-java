package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Signal hypothetical reference decoder (HRD) information (requires bufsize to be set)
 */
public enum H264NalHrd {
  
  /**
   * Do not signal HRD information
   */
  NONE("NONE"),
  
  /**
   * Signal HRD for variable bitrate
   */
  VBR("VBR"),
  
  /**
   * Signal HRD for constant bitrate (Not possible with fragmented or progressive MP4 muxings)
   */
  CBR("CBR");

  private String value;

  H264NalHrd(String value) {
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
  public static H264NalHrd fromValue(String text) {
    for (H264NalHrd b : H264NalHrd.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

