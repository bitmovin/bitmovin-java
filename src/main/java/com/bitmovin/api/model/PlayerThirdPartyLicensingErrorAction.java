package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PlayerThirdPartyLicensingErrorAction
 */
public enum PlayerThirdPartyLicensingErrorAction {
  
  /**
   * Allow the licensing request if the Third Party Licensing server returns anything other than HTTP 2xx.
   */
  ALLOW("ALLOW"),
  
  /**
   * Deny the licensing request if the Third Party Licensing server returns anything other than HTTP 2xx.
   */
  DENY("DENY");

  private String value;

  PlayerThirdPartyLicensingErrorAction(String value) {
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
  public static PlayerThirdPartyLicensingErrorAction fromValue(String text) {
    for (PlayerThirdPartyLicensingErrorAction b : PlayerThirdPartyLicensingErrorAction.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

