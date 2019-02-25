package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AesEncryptionMethod;
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
 * AesEncryptionDrm
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class AesEncryptionDrm extends Drm {
  @JsonProperty("key")
  private String key;

  @JsonProperty("iv")
  private String iv;

  @JsonProperty("keyFileUri")
  private String keyFileUri;

  @JsonProperty("method")
  private AesEncryptionMethod method = null;


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
   * Path relative to the output for referencing in the manifest. If this value is not set the key file will be written automatically to the output folder.
   * @return keyFileUri
  **/
  public String getKeyFileUri() {
    return keyFileUri;
  }

  public void setKeyFileUri(String keyFileUri) {
    this.keyFileUri = keyFileUri;
  }


  /**
   * Get method
   * @return method
  **/
  public AesEncryptionMethod getMethod() {
    return method;
  }

  public void setMethod(AesEncryptionMethod method) {
    this.method = method;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AesEncryptionDrm aesEncryptionDrm = (AesEncryptionDrm) o;
    return Objects.equals(this.key, aesEncryptionDrm.key) &&
        Objects.equals(this.iv, aesEncryptionDrm.iv) &&
        Objects.equals(this.keyFileUri, aesEncryptionDrm.keyFileUri) &&
        Objects.equals(this.method, aesEncryptionDrm.method) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, iv, keyFileUri, method, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AesEncryptionDrm {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    iv: ").append(toIndentedString(iv)).append("\n");
    sb.append("    keyFileUri: ").append(toIndentedString(keyFileUri)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
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

