package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BillableEncodingFeatureMinutes
 */

public class BillableEncodingFeatureMinutes {
  @JsonProperty("featureType")
  private String featureType;

  @JsonProperty("encodedMinutes")
  private Double encodedMinutes;

  @JsonProperty("featureMultiplier")
  private Double featureMultiplier;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;


  /**
   * The name of the feature.
   * @return featureType
  **/
  public String getFeatureType() {
    return featureType;
  }

  public void setFeatureType(String featureType) {
    this.featureType = featureType;
  }


  /**
   * Encoded minutes related to this feature.
   * @return encodedMinutes
  **/
  public Double getEncodedMinutes() {
    return encodedMinutes;
  }

  public void setEncodedMinutes(Double encodedMinutes) {
    this.encodedMinutes = encodedMinutes;
  }


  /**
   * The multiplier used for this feature.
   * @return featureMultiplier
  **/
  public Double getFeatureMultiplier() {
    return featureMultiplier;
  }

  public void setFeatureMultiplier(Double featureMultiplier) {
    this.featureMultiplier = featureMultiplier;
  }


  /**
   * The billable minutes related to this feature.
   * @return billableMinutes
  **/
  public Double getBillableMinutes() {
    return billableMinutes;
  }

  public void setBillableMinutes(Double billableMinutes) {
    this.billableMinutes = billableMinutes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillableEncodingFeatureMinutes billableEncodingFeatureMinutes = (BillableEncodingFeatureMinutes) o;
    return Objects.equals(this.featureType, billableEncodingFeatureMinutes.featureType) &&
        Objects.equals(this.encodedMinutes, billableEncodingFeatureMinutes.encodedMinutes) &&
        Objects.equals(this.featureMultiplier, billableEncodingFeatureMinutes.featureMultiplier) &&
        Objects.equals(this.billableMinutes, billableEncodingFeatureMinutes.billableMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(featureType, encodedMinutes, featureMultiplier, billableMinutes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillableEncodingFeatureMinutes {\n");
    
    sb.append("    featureType: ").append(toIndentedString(featureType)).append("\n");
    sb.append("    encodedMinutes: ").append(toIndentedString(encodedMinutes)).append("\n");
    sb.append("    featureMultiplier: ").append(toIndentedString(featureMultiplier)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
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

