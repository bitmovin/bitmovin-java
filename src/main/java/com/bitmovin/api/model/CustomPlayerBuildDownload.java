package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Custom player download information
 */

public class CustomPlayerBuildDownload {
  @JsonProperty("downloadLink")
  private String downloadLink;

  @JsonProperty("expiresAt")
  private Date expiresAt;


  /**
   * The link to download the custom built player
   * @return downloadLink
  **/
  public String getDownloadLink() {
    return downloadLink;
  }

  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
  }


  /**
   * Until this date the download link is valid and can be downloaded.
   * @return expiresAt
  **/
  public Date getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(Date expiresAt) {
    this.expiresAt = expiresAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomPlayerBuildDownload customPlayerBuildDownload = (CustomPlayerBuildDownload) o;
    return Objects.equals(this.downloadLink, customPlayerBuildDownload.downloadLink) &&
        Objects.equals(this.expiresAt, customPlayerBuildDownload.expiresAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downloadLink, expiresAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomPlayerBuildDownload {\n");
    
    sb.append("    downloadLink: ").append(toIndentedString(downloadLink)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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

