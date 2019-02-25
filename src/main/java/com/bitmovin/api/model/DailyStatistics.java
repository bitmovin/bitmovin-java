package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BillableEncodingFeatureMinutes;
import com.bitmovin.api.model.BillableEncodingMinutes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DailyStatistics
 */

public class DailyStatistics {
  @JsonProperty("date")
  private Date date;

  @JsonProperty("bytesEncoded")
  private Long bytesEncoded;

  @JsonProperty("timeEncoded")
  private Long timeEncoded;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;

  @JsonProperty("label")
  private Date label;

  @JsonProperty("billableEncodingMinutes")
  private List<BillableEncodingMinutes> billableEncodingMinutes;

  @JsonProperty("billableTransmuxingMinutes")
  private Double billableTransmuxingMinutes;

  @JsonProperty("billableFeatureMinutes")
  private List<BillableEncodingFeatureMinutes> billableFeatureMinutes;


  /**
   * Date for the shown data. Format: yyyy-MM-dd
   * @return date
  **/
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  /**
   * Bytes encoded.
   * @return bytesEncoded
  **/
  public Long getBytesEncoded() {
    return bytesEncoded;
  }

  public void setBytesEncoded(Long bytesEncoded) {
    this.bytesEncoded = bytesEncoded;
  }


  /**
   * Time in seconds encoded for this day.
   * @return timeEncoded
  **/
  public Long getTimeEncoded() {
    return timeEncoded;
  }

  public void setTimeEncoded(Long timeEncoded) {
    this.timeEncoded = timeEncoded;
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
   * Label identifier.
   * @return label
  **/
  public Date getLabel() {
    return label;
  }

  public void setLabel(Date label) {
    this.label = label;
  }

  /**
   * Billable minutes for each encoding configuration.
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
    DailyStatistics dailyStatistics = (DailyStatistics) o;
    return Objects.equals(this.date, dailyStatistics.date) &&
        Objects.equals(this.bytesEncoded, dailyStatistics.bytesEncoded) &&
        Objects.equals(this.timeEncoded, dailyStatistics.timeEncoded) &&
        Objects.equals(this.billableMinutes, dailyStatistics.billableMinutes) &&
        Objects.equals(this.label, dailyStatistics.label) &&
        Objects.equals(this.billableEncodingMinutes, dailyStatistics.billableEncodingMinutes) &&
        Objects.equals(this.billableTransmuxingMinutes, dailyStatistics.billableTransmuxingMinutes) &&
        Objects.equals(this.billableFeatureMinutes, dailyStatistics.billableFeatureMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, bytesEncoded, timeEncoded, billableMinutes, label, billableEncodingMinutes, billableTransmuxingMinutes, billableFeatureMinutes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailyStatistics {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    bytesEncoded: ").append(toIndentedString(bytesEncoded)).append("\n");
    sb.append("    timeEncoded: ").append(toIndentedString(timeEncoded)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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

