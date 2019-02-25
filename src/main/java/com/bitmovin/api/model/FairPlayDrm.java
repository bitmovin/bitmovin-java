package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Drm;
import com.bitmovin.api.model.DrmType;
import com.bitmovin.api.model.EncodingOutput;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * FairPlayDrm
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class FairPlayDrm extends Drm {
  @JsonProperty("key")
  private String key;

  @JsonProperty("iv")
  private String iv;

  @JsonProperty("uri")
  private String uri;


  /**
   * 16 byte Encryption key, 32 hexadecimal characters
   * @return key
  **/
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  /**
   * 16 byte initialization vector
   * @return iv
  **/
  public String getIv() {
    return iv;
  }

  public void setIv(String iv) {
    this.iv = iv;
  }


  /**
   * Url of the licensing server
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
    FairPlayDrm fairPlayDrm = (FairPlayDrm) o;
    return Objects.equals(this.key, fairPlayDrm.key) &&
        Objects.equals(this.iv, fairPlayDrm.iv) &&
        Objects.equals(this.uri, fairPlayDrm.uri) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, iv, uri, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FairPlayDrm {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

