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
 * ZixiInput
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class ZixiInput extends Input {
  @JsonProperty("host")
  private String host;

  @JsonProperty("port")
  private Integer port;

  @JsonProperty("stream")
  private String stream;

  @JsonProperty("password")
  private String password;

  @JsonProperty("latency")
  private Integer latency;

  @JsonProperty("minBitrate")
  private Integer minBitrate;

  @JsonProperty("decryptionType")
  private String decryptionType;

  @JsonProperty("decryptionKey")
  private String decryptionKey;


  /**
   * Get host
   * @return host
  **/
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  /**
   * Get port
   * @return port
  **/
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }


  /**
   * Get stream
   * @return stream
  **/
  public String getStream() {
    return stream;
  }

  public void setStream(String stream) {
    this.stream = stream;
  }


  /**
   * Get password
   * @return password
  **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * Get latency
   * @return latency
  **/
  public Integer getLatency() {
    return latency;
  }

  public void setLatency(Integer latency) {
    this.latency = latency;
  }


  /**
   * Get minBitrate
   * @return minBitrate
  **/
  public Integer getMinBitrate() {
    return minBitrate;
  }

  public void setMinBitrate(Integer minBitrate) {
    this.minBitrate = minBitrate;
  }


  /**
   * Get decryptionType
   * @return decryptionType
  **/
  public String getDecryptionType() {
    return decryptionType;
  }

  public void setDecryptionType(String decryptionType) {
    this.decryptionType = decryptionType;
  }


  /**
   * Get decryptionKey
   * @return decryptionKey
  **/
  public String getDecryptionKey() {
    return decryptionKey;
  }

  public void setDecryptionKey(String decryptionKey) {
    this.decryptionKey = decryptionKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZixiInput zixiInput = (ZixiInput) o;
    return Objects.equals(this.host, zixiInput.host) &&
        Objects.equals(this.port, zixiInput.port) &&
        Objects.equals(this.stream, zixiInput.stream) &&
        Objects.equals(this.password, zixiInput.password) &&
        Objects.equals(this.latency, zixiInput.latency) &&
        Objects.equals(this.minBitrate, zixiInput.minBitrate) &&
        Objects.equals(this.decryptionType, zixiInput.decryptionType) &&
        Objects.equals(this.decryptionKey, zixiInput.decryptionKey) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port, stream, password, latency, minBitrate, decryptionType, decryptionKey, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZixiInput {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    stream: ").append(toIndentedString(stream)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    latency: ").append(toIndentedString(latency)).append("\n");
    sb.append("    minBitrate: ").append(toIndentedString(minBitrate)).append("\n");
    sb.append("    decryptionType: ").append(toIndentedString(decryptionType)).append("\n");
    sb.append("    decryptionKey: ").append(toIndentedString(decryptionKey)).append("\n");
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

