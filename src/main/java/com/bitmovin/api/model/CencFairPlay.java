package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CencFairPlay
 */

public class CencFairPlay {
  @JsonProperty("iv")
  private String iv;

  @JsonProperty("uri")
  private String uri;


  /**
   * Initialization vector as hexadecimal string
   * @return iv
  **/
  public String getIv() {
    return iv;
  }

  public void setIv(String iv) {
    this.iv = iv;
  }


  /**
   * URL of the licensing server
   * @return uri
  **/
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CencFairPlay cencFairPlay = (CencFairPlay) o;
    return Objects.equals(this.iv, cencFairPlay.iv) &&
        Objects.equals(this.uri, cencFairPlay.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iv, uri);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CencFairPlay {\n");
    
    sb.append("    iv: ").append(toIndentedString(iv)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

