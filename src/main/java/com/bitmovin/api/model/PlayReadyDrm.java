package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Drm;
import com.bitmovin.api.model.DrmType;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.PlayReadyEncryptionMethod;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * PlayReadyDrm
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class PlayReadyDrm extends Drm {
  @JsonProperty("key")
  private String key;

  @JsonProperty("keySeed")
  private String keySeed;

  @JsonProperty("laUrl")
  private String laUrl;

  @JsonProperty("method")
  private PlayReadyEncryptionMethod method = null;

  @JsonProperty("kid")
  private String kid;


  /**
   * 16 byte encryption key, 32 hexadecimal characters. Either key or keySeed is required.
   * @return key
  **/
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  /**
   * Key seed to generate key. Either key or keySeed is required.
   * @return keySeed
  **/
  public String getKeySeed() {
    return keySeed;
  }

  public void setKeySeed(String keySeed) {
    this.keySeed = keySeed;
  }


  /**
   * URL of the license server
   * @return laUrl
  **/
  public String getLaUrl() {
    return laUrl;
  }

  public void setLaUrl(String laUrl) {
    this.laUrl = laUrl;
  }


  /**
   * Get method
   * @return method
  **/
  public PlayReadyEncryptionMethod getMethod() {
    return method;
  }

  public void setMethod(PlayReadyEncryptionMethod method) {
    this.method = method;
  }


  /**
   * Key identifier
   * @return kid
  **/
  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayReadyDrm playReadyDrm = (PlayReadyDrm) o;
    return Objects.equals(this.key, playReadyDrm.key) &&
        Objects.equals(this.keySeed, playReadyDrm.keySeed) &&
        Objects.equals(this.laUrl, playReadyDrm.laUrl) &&
        Objects.equals(this.method, playReadyDrm.method) &&
        Objects.equals(this.kid, playReadyDrm.kid) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, keySeed, laUrl, method, kid, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayReadyDrm {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    keySeed: ").append(toIndentedString(keySeed)).append("\n");
    sb.append("    laUrl: ").append(toIndentedString(laUrl)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
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

