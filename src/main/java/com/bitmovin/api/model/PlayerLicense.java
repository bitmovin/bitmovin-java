package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import com.bitmovin.api.model.Domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * PlayerLicense
 */

public class PlayerLicense extends BitmovinResponse {
  @JsonProperty("name")
  private String name;

  @JsonProperty("createdAt")
  private Date createdAt;

  @JsonProperty("licenseKey")
  private String licenseKey;

  @JsonProperty("impressions")
  private Integer impressions;

  @JsonProperty("maxImpressions")
  private Integer maxImpressions;

  @JsonProperty("thirdPartyLicensingEnabled")
  private Boolean thirdPartyLicensingEnabled;

  @JsonProperty("domains")
  private List<Domain> domains = new ArrayList<Domain>();

  /**
   * Name of the resource
   * @return name
  **/
  public String getName() {
    return name;
  }

  /**
   * Creation timestamp expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return createdAt
  **/
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * License Key
   * @return licenseKey
  **/
  public String getLicenseKey() {
    return licenseKey;
  }

  /**
   * Number of impressions recorded
   * @return impressions
  **/
  public Integer getImpressions() {
    return impressions;
  }

  /**
   * Maximum number of impressions
   * @return maxImpressions
  **/
  public Integer getMaxImpressions() {
    return maxImpressions;
  }

  /**
   * Flag if third party licensing is enabled
   * @return thirdPartyLicensingEnabled
  **/
  public Boolean getThirdPartyLicensingEnabled() {
    return thirdPartyLicensingEnabled;
  }

  /**
   * Whitelisted domains
   * @return domains
  **/
  public List<Domain> getDomains() {
    return domains;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerLicense playerLicense = (PlayerLicense) o;
    return Objects.equals(this.name, playerLicense.name) &&
        Objects.equals(this.createdAt, playerLicense.createdAt) &&
        Objects.equals(this.licenseKey, playerLicense.licenseKey) &&
        Objects.equals(this.impressions, playerLicense.impressions) &&
        Objects.equals(this.maxImpressions, playerLicense.maxImpressions) &&
        Objects.equals(this.thirdPartyLicensingEnabled, playerLicense.thirdPartyLicensingEnabled) &&
        Objects.equals(this.domains, playerLicense.domains) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, createdAt, licenseKey, impressions, maxImpressions, thirdPartyLicensingEnabled, domains, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerLicense {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    licenseKey: ").append(toIndentedString(licenseKey)).append("\n");
    sb.append("    impressions: ").append(toIndentedString(impressions)).append("\n");
    sb.append("    maxImpressions: ").append(toIndentedString(maxImpressions)).append("\n");
    sb.append("    thirdPartyLicensingEnabled: ").append(toIndentedString(thirdPartyLicensingEnabled)).append("\n");
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

