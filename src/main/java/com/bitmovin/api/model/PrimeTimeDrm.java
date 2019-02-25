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
 * PrimeTimeDrm
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class PrimeTimeDrm extends Drm {
  @JsonProperty("key")
  private String key;

  @JsonProperty("kid")
  private String kid;

  @JsonProperty("pssh")
  private String pssh;


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
   * 16 byte Key id, 32 hexadecimal characters
   * @return kid
  **/
  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }


  /**
   * Base 64 Encoded
   * @return pssh
  **/
  public String getPssh() {
    return pssh;
  }

  public void setPssh(String pssh) {
    this.pssh = pssh;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrimeTimeDrm primeTimeDrm = (PrimeTimeDrm) o;
    return Objects.equals(this.key, primeTimeDrm.key) &&
        Objects.equals(this.kid, primeTimeDrm.kid) &&
        Objects.equals(this.pssh, primeTimeDrm.pssh) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, kid, pssh, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrimeTimeDrm {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
    sb.append("    pssh: ").append(toIndentedString(pssh)).append("\n");
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

