package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CustomPlayerBuildDetails
 */

public class CustomPlayerBuildDetails extends BitmovinResource {
  @JsonProperty("playerVersion")
  private String playerVersion;

  @JsonProperty("domains")
  private List<String> domains = new ArrayList<String>();


  /**
   * The player version that should be used for the custom player build. If not set the &#39;latest&#39; version is used. 
   * @return playerVersion
  **/
  public String getPlayerVersion() {
    return playerVersion;
  }

  public void setPlayerVersion(String playerVersion) {
    this.playerVersion = playerVersion;
  }


  public CustomPlayerBuildDetails addDomainsItem(String domainsItem) {
    this.domains.add(domainsItem);
    return this;
  }

  /**
   * The domains that the player is locked to. If not set the player will only work with &#39;localhost&#39;. Not more than 49 additional domains can be added. 
   * @return domains
  **/
  public List<String> getDomains() {
    return domains;
  }

  public void setDomains(List<String> domains) {
    this.domains = domains;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomPlayerBuildDetails customPlayerBuildDetails = (CustomPlayerBuildDetails) o;
    return Objects.equals(this.playerVersion, customPlayerBuildDetails.playerVersion) &&
        Objects.equals(this.domains, customPlayerBuildDetails.domains) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerVersion, domains, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomPlayerBuildDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    playerVersion: ").append(toIndentedString(playerVersion)).append("\n");
    sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
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

