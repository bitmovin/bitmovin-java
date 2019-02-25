package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingOutput;
import com.bitmovin.api.model.Manifest;
import com.bitmovin.api.model.ManifestType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SmoothStreamingManifest
 */

public class SmoothStreamingManifest extends Manifest {
  @JsonProperty("serverManifestName")
  private String serverManifestName;

  @JsonProperty("clientManifestName")
  private String clientManifestName;


  /**
   * Filename of the server manifest
   * @return serverManifestName
  **/
  public String getServerManifestName() {
    return serverManifestName;
  }

  public void setServerManifestName(String serverManifestName) {
    this.serverManifestName = serverManifestName;
  }


  /**
   * Filename of the client manifest
   * @return clientManifestName
  **/
  public String getClientManifestName() {
    return clientManifestName;
  }

  public void setClientManifestName(String clientManifestName) {
    this.clientManifestName = clientManifestName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmoothStreamingManifest smoothStreamingManifest = (SmoothStreamingManifest) o;
    return Objects.equals(this.serverManifestName, smoothStreamingManifest.serverManifestName) &&
        Objects.equals(this.clientManifestName, smoothStreamingManifest.clientManifestName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverManifestName, clientManifestName, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmoothStreamingManifest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    serverManifestName: ").append(toIndentedString(serverManifestName)).append("\n");
    sb.append("    clientManifestName: ").append(toIndentedString(clientManifestName)).append("\n");
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

