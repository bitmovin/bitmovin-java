package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BasicMediaInfo;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * VttMediaInfo
 */

public class VttMediaInfo extends BasicMediaInfo {
  @JsonProperty("vttUrl")
  private String vttUrl;

  @JsonProperty("uri")
  private String uri;

  @JsonProperty("forced")
  private Boolean forced;


  /**
   * The URL of the referenced VTT file
   * @return vttUrl
  **/
  public String getVttUrl() {
    return vttUrl;
  }

  public void setVttUrl(String vttUrl) {
    this.vttUrl = vttUrl;
  }


  /**
   * The URI of the Rendition
   * @return uri
  **/
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  /**
   * A value of true indicates that the Rendition contains content which is considered essential to play.
   * @return forced
  **/
  public Boolean getForced() {
    return forced;
  }

  public void setForced(Boolean forced) {
    this.forced = forced;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VttMediaInfo vttMediaInfo = (VttMediaInfo) o;
    return Objects.equals(this.vttUrl, vttMediaInfo.vttUrl) &&
        Objects.equals(this.uri, vttMediaInfo.uri) &&
        Objects.equals(this.forced, vttMediaInfo.forced) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vttUrl, uri, forced, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VttMediaInfo {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    vttUrl: ").append(toIndentedString(vttUrl)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    forced: ").append(toIndentedString(forced)).append("\n");
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

