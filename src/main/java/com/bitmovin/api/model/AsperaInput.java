package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Input;
import com.bitmovin.api.model.InputType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AsperaInput
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class AsperaInput extends Input {
  @JsonProperty("minBandwidth")
  private String minBandwidth;

  @JsonProperty("maxBandwidth")
  private String maxBandwidth;

  @JsonProperty("host")
  private String host;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @JsonProperty("token")
  private String token;


  /**
   * Minimal download bandwidth. Examples: 100k, 100m, 100g
   * @return minBandwidth
  **/
  public String getMinBandwidth() {
    return minBandwidth;
  }

  public void setMinBandwidth(String minBandwidth) {
    this.minBandwidth = minBandwidth;
  }


  /**
   * Maximal download bandwidth. Examples: 100k, 100m, 100g
   * @return maxBandwidth
  **/
  public String getMaxBandwidth() {
    return maxBandwidth;
  }

  public void setMaxBandwidth(String maxBandwidth) {
    this.maxBandwidth = maxBandwidth;
  }


  /**
   * Host to use for Aspera transfers
   * @return host
  **/
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  /**
   * Username to log into Aspera host (either password and user must be set or token)
   * @return username
  **/
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  /**
   * corresponding password (either password and user must be set or token)
   * @return password
  **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * Token used for authentication (either password and user must be set or token)
   * @return token
  **/
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsperaInput asperaInput = (AsperaInput) o;
    return Objects.equals(this.minBandwidth, asperaInput.minBandwidth) &&
        Objects.equals(this.maxBandwidth, asperaInput.maxBandwidth) &&
        Objects.equals(this.host, asperaInput.host) &&
        Objects.equals(this.username, asperaInput.username) &&
        Objects.equals(this.password, asperaInput.password) &&
        Objects.equals(this.token, asperaInput.token) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minBandwidth, maxBandwidth, host, username, password, token, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsperaInput {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    minBandwidth: ").append(toIndentedString(minBandwidth)).append("\n");
    sb.append("    maxBandwidth: ").append(toIndentedString(maxBandwidth)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

