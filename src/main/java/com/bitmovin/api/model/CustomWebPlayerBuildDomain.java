package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CustomWebPlayerBuildDomain
 */

public class CustomWebPlayerBuildDomain extends BitmovinResource {
  @JsonProperty("domain")
  private String domain;


  /**
   * Domain where the player is allowed to play
   * @return domain
  **/
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomWebPlayerBuildDomain customWebPlayerBuildDomain = (CustomWebPlayerBuildDomain) o;
    return Objects.equals(this.domain, customWebPlayerBuildDomain.domain) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(domain, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomWebPlayerBuildDomain {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
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

