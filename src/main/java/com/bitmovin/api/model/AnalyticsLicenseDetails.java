package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsLicenseDomain;
import com.bitmovin.api.model.BitmovinResource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsLicenseDetails
 */

public class AnalyticsLicenseDetails extends BitmovinResource {
  @JsonProperty("licenseKey")
  private String licenseKey;

  @JsonProperty("maxDatapoints")
  private Long maxDatapoints;

  @JsonProperty("datapoints")
  private Long datapoints;

  @JsonProperty("domains")
  private List<AnalyticsLicenseDomain> domains = new ArrayList<AnalyticsLicenseDomain>();


  /**
   * License Key
   * @return licenseKey
  **/
  public String getLicenseKey() {
    return licenseKey;
  }

  public void setLicenseKey(String licenseKey) {
    this.licenseKey = licenseKey;
  }


  /**
   * Maximum number of datapoints
   * @return maxDatapoints
  **/
  public Long getMaxDatapoints() {
    return maxDatapoints;
  }

  public void setMaxDatapoints(Long maxDatapoints) {
    this.maxDatapoints = maxDatapoints;
  }


  /**
   * Number of datapoints recorded
   * @return datapoints
  **/
  public Long getDatapoints() {
    return datapoints;
  }

  public void setDatapoints(Long datapoints) {
    this.datapoints = datapoints;
  }


  public AnalyticsLicenseDetails addDomainsItem(AnalyticsLicenseDomain domainsItem) {
    this.domains.add(domainsItem);
    return this;
  }

  /**
   * Whitelisted domains
   * @return domains
  **/
  public List<AnalyticsLicenseDomain> getDomains() {
    return domains;
  }

  public void setDomains(List<AnalyticsLicenseDomain> domains) {
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
    AnalyticsLicenseDetails analyticsLicenseDetails = (AnalyticsLicenseDetails) o;
    return Objects.equals(this.licenseKey, analyticsLicenseDetails.licenseKey) &&
        Objects.equals(this.maxDatapoints, analyticsLicenseDetails.maxDatapoints) &&
        Objects.equals(this.datapoints, analyticsLicenseDetails.datapoints) &&
        Objects.equals(this.domains, analyticsLicenseDetails.domains) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenseKey, maxDatapoints, datapoints, domains, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsLicenseDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    licenseKey: ").append(toIndentedString(licenseKey)).append("\n");
    sb.append("    maxDatapoints: ").append(toIndentedString(maxDatapoints)).append("\n");
    sb.append("    datapoints: ").append(toIndentedString(datapoints)).append("\n");
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

