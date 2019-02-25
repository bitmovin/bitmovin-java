package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * PlayerVersion
 */

public class PlayerVersion extends BitmovinResponse {
  @JsonProperty("version")
  private String version;

  @JsonProperty("cdnUrl")
  private String cdnUrl;

  @JsonProperty("downloadUrl")
  private String downloadUrl;

  @JsonProperty("createdAt")
  private Date createdAt;

  /**
   * Version of the Player
   * @return version
  **/
  public String getVersion() {
    return version;
  }

  /**
   * URL of the specified player
   * @return cdnUrl
  **/
  public String getCdnUrl() {
    return cdnUrl;
  }

  /**
   * Download URL of the specified player package
   * @return downloadUrl
  **/
  public String getDownloadUrl() {
    return downloadUrl;
  }

  /**
   * Creation timestamp expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return createdAt
  **/
  public Date getCreatedAt() {
    return createdAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerVersion playerVersion = (PlayerVersion) o;
    return Objects.equals(this.version, playerVersion.version) &&
        Objects.equals(this.cdnUrl, playerVersion.cdnUrl) &&
        Objects.equals(this.downloadUrl, playerVersion.downloadUrl) &&
        Objects.equals(this.createdAt, playerVersion.createdAt) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, cdnUrl, downloadUrl, createdAt, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerVersion {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    cdnUrl: ").append(toIndentedString(cdnUrl)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

