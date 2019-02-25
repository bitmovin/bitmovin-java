package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AclEntry;
import com.bitmovin.api.model.Output;
import com.bitmovin.api.model.OutputType;
import com.bitmovin.api.model.TransferVersion;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SftpOutput
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class SftpOutput extends Output {
  @JsonProperty("host")
  private String host;

  @JsonProperty("port")
  private Integer port;

  @JsonProperty("passive")
  private Boolean passive;

  @JsonProperty("username")
  private String username;

  @JsonProperty("password")
  private String password;

  @JsonProperty("transferVersion")
  private TransferVersion transferVersion = null;

  @JsonProperty("maxConcurrentConnections")
  private Integer maxConcurrentConnections;


  /**
   * Host Url or IP of the SFTP server
   * @return host
  **/
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  /**
   * Port to use, standard for SFTP: 22
   * @return port
  **/
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }


  /**
   * Use passive mode. Default is true.
   * @return passive
  **/
  public Boolean getPassive() {
    return passive;
  }

  public void setPassive(Boolean passive) {
    this.passive = passive;
  }


  /**
   * Your SFTP Username
   * @return username
  **/
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  /**
   * Your SFTP password
   * @return password
  **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * Controls which transfer version should be used
   * @return transferVersion
  **/
  public TransferVersion getTransferVersion() {
    return transferVersion;
  }

  public void setTransferVersion(TransferVersion transferVersion) {
    this.transferVersion = transferVersion;
  }


  /**
   * Restrict maximum concurrent connections. Requires at least version 1.1.0.
   * @return maxConcurrentConnections
  **/
  public Integer getMaxConcurrentConnections() {
    return maxConcurrentConnections;
  }

  public void setMaxConcurrentConnections(Integer maxConcurrentConnections) {
    this.maxConcurrentConnections = maxConcurrentConnections;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SftpOutput sftpOutput = (SftpOutput) o;
    return Objects.equals(this.host, sftpOutput.host) &&
        Objects.equals(this.port, sftpOutput.port) &&
        Objects.equals(this.passive, sftpOutput.passive) &&
        Objects.equals(this.username, sftpOutput.username) &&
        Objects.equals(this.password, sftpOutput.password) &&
        Objects.equals(this.transferVersion, sftpOutput.transferVersion) &&
        Objects.equals(this.maxConcurrentConnections, sftpOutput.maxConcurrentConnections) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host, port, passive, username, password, transferVersion, maxConcurrentConnections, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SftpOutput {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    passive: ").append(toIndentedString(passive)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    transferVersion: ").append(toIndentedString(transferVersion)).append("\n");
    sb.append("    maxConcurrentConnections: ").append(toIndentedString(maxConcurrentConnections)).append("\n");
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

