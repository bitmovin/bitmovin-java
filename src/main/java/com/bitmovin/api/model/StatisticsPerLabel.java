package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BillableEncodingFeatureMinutes;
import com.bitmovin.api.model.BillableEncodingMinutes;
import com.bitmovin.api.model.Statistics;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StatisticsPerLabel
 */

public class StatisticsPerLabel extends Statistics {
  @JsonProperty("label")
  private String label;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;

  @JsonProperty("billableEncodingMinutes")
  private List<BillableEncodingMinutes> billableEncodingMinutes;

  @JsonProperty("billableTransmuxingMinutes")
  private Double billableTransmuxingMinutes;

  @JsonProperty("billableFeatureMinutes")
  private List<BillableEncodingFeatureMinutes> billableFeatureMinutes;


  /**
   * An optional error message, when the event is in error state (occurs at event: ERROR)
   * @return label
  **/
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  /**
   * The billable minutes.
   * @return billableMinutes
  **/
  public Double getBillableMinutes() {
    return billableMinutes;
  }

  public void setBillableMinutes(Double billableMinutes) {
    this.billableMinutes = billableMinutes;
  }

  /**
   * Billable minutes for each encoding configuration
   * @return billableEncodingMinutes
  **/
  public List<BillableEncodingMinutes> getBillableEncodingMinutes() {
    return billableEncodingMinutes;
  }


  /**
   * Billable minutes for muxings.
   * @return billableTransmuxingMinutes
  **/
  public Double getBillableTransmuxingMinutes() {
    return billableTransmuxingMinutes;
  }

  public void setBillableTransmuxingMinutes(Double billableTransmuxingMinutes) {
    this.billableTransmuxingMinutes = billableTransmuxingMinutes;
  }

  /**
   * Billable minutes for features
   * @return billableFeatureMinutes
  **/
  public List<BillableEncodingFeatureMinutes> getBillableFeatureMinutes() {
    return billableFeatureMinutes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticsPerLabel statisticsPerLabel = (StatisticsPerLabel) o;
    return Objects.equals(this.label, statisticsPerLabel.label) &&
        Objects.equals(this.billableMinutes, statisticsPerLabel.billableMinutes) &&
        Objects.equals(this.billableEncodingMinutes, statisticsPerLabel.billableEncodingMinutes) &&
        Objects.equals(this.billableTransmuxingMinutes, statisticsPerLabel.billableTransmuxingMinutes) &&
        Objects.equals(this.billableFeatureMinutes, statisticsPerLabel.billableFeatureMinutes) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, billableMinutes, billableEncodingMinutes, billableTransmuxingMinutes, billableFeatureMinutes, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatisticsPerLabel {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
    sb.append("    billableEncodingMinutes: ").append(toIndentedString(billableEncodingMinutes)).append("\n");
    sb.append("    billableTransmuxingMinutes: ").append(toIndentedString(billableTransmuxingMinutes)).append("\n");
    sb.append("    billableFeatureMinutes: ").append(toIndentedString(billableFeatureMinutes)).append("\n");
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

