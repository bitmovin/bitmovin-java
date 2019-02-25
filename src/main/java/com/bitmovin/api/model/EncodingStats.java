package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BillableEncodingFeatureMinutes;
import com.bitmovin.api.model.BillableEncodingMinutes;
import com.bitmovin.api.model.StatisticsPerMuxing;
import com.bitmovin.api.model.StatisticsPerStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingStats
 */

public class EncodingStats {
  @JsonProperty("date")
  private Date date;

  @JsonProperty("encodingId")
  private String encodingId;

  @JsonProperty("bytesEncoded")
  private Long bytesEncoded;

  @JsonProperty("timeEncoded")
  private Long timeEncoded;

  @JsonProperty("downloadedSize")
  private Long downloadedSize;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;

  @JsonProperty("billableEncodingMinutes")
  private List<BillableEncodingMinutes> billableEncodingMinutes;

  @JsonProperty("billableTransmuxingMinutes")
  private Double billableTransmuxingMinutes;

  @JsonProperty("billableFeatureMinutes")
  private Double billableFeatureMinutes;

  @JsonProperty("streams")
  private List<StatisticsPerStream> streams = new ArrayList<StatisticsPerStream>();

  @JsonProperty("muxings")
  private List<StatisticsPerMuxing> muxings = new ArrayList<StatisticsPerMuxing>();

  @JsonProperty("features")
  private List<BillableEncodingFeatureMinutes> features;


  /**
   * Date, format. yyyy-MM-dd
   * @return date
  **/
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  /**
   * The id of the encoding
   * @return encodingId
  **/
  public String getEncodingId() {
    return encodingId;
  }

  public void setEncodingId(String encodingId) {
    this.encodingId = encodingId;
  }


  /**
   * Total bytes encoded
   * @return bytesEncoded
  **/
  public Long getBytesEncoded() {
    return bytesEncoded;
  }

  public void setBytesEncoded(Long bytesEncoded) {
    this.bytesEncoded = bytesEncoded;
  }


  /**
   * Total time encoded
   * @return timeEncoded
  **/
  public Long getTimeEncoded() {
    return timeEncoded;
  }

  public void setTimeEncoded(Long timeEncoded) {
    this.timeEncoded = timeEncoded;
  }


  /**
   * Downloaded size of the input file
   * @return downloadedSize
  **/
  public Long getDownloadedSize() {
    return downloadedSize;
  }

  public void setDownloadedSize(Long downloadedSize) {
    this.downloadedSize = downloadedSize;
  }


  /**
   * Billable minutes
   * @return billableMinutes
  **/
  public Double getBillableMinutes() {
    return billableMinutes;
  }

  public void setBillableMinutes(Double billableMinutes) {
    this.billableMinutes = billableMinutes;
  }


  public EncodingStats addBillableEncodingMinutesItem(BillableEncodingMinutes billableEncodingMinutesItem) {
    if (this.billableEncodingMinutes == null) {
      this.billableEncodingMinutes = new ArrayList<>();
    }
    this.billableEncodingMinutes.add(billableEncodingMinutesItem);
    return this;
  }

  /**
   * Detailed statistics per stream
   * @return billableEncodingMinutes
  **/
  public List<BillableEncodingMinutes> getBillableEncodingMinutes() {
    return billableEncodingMinutes;
  }

  public void setBillableEncodingMinutes(List<BillableEncodingMinutes> billableEncodingMinutes) {
    this.billableEncodingMinutes = billableEncodingMinutes;
  }


  /**
   * Billable transmuxing minutes
   * @return billableTransmuxingMinutes
  **/
  public Double getBillableTransmuxingMinutes() {
    return billableTransmuxingMinutes;
  }

  public void setBillableTransmuxingMinutes(Double billableTransmuxingMinutes) {
    this.billableTransmuxingMinutes = billableTransmuxingMinutes;
  }


  /**
   * Billable feature minutes
   * @return billableFeatureMinutes
  **/
  public Double getBillableFeatureMinutes() {
    return billableFeatureMinutes;
  }

  public void setBillableFeatureMinutes(Double billableFeatureMinutes) {
    this.billableFeatureMinutes = billableFeatureMinutes;
  }


  public EncodingStats addStreamsItem(StatisticsPerStream streamsItem) {
    this.streams.add(streamsItem);
    return this;
  }

  /**
   * Detailed statistics per stream
   * @return streams
  **/
  public List<StatisticsPerStream> getStreams() {
    return streams;
  }

  public void setStreams(List<StatisticsPerStream> streams) {
    this.streams = streams;
  }


  public EncodingStats addMuxingsItem(StatisticsPerMuxing muxingsItem) {
    this.muxings.add(muxingsItem);
    return this;
  }

  /**
   * Detailed statistics per muxing
   * @return muxings
  **/
  public List<StatisticsPerMuxing> getMuxings() {
    return muxings;
  }

  public void setMuxings(List<StatisticsPerMuxing> muxings) {
    this.muxings = muxings;
  }


  public EncodingStats addFeaturesItem(BillableEncodingFeatureMinutes featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Detailed statistics per feature
   * @return features
  **/
  public List<BillableEncodingFeatureMinutes> getFeatures() {
    return features;
  }

  public void setFeatures(List<BillableEncodingFeatureMinutes> features) {
    this.features = features;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingStats encodingStats = (EncodingStats) o;
    return Objects.equals(this.date, encodingStats.date) &&
        Objects.equals(this.encodingId, encodingStats.encodingId) &&
        Objects.equals(this.bytesEncoded, encodingStats.bytesEncoded) &&
        Objects.equals(this.timeEncoded, encodingStats.timeEncoded) &&
        Objects.equals(this.downloadedSize, encodingStats.downloadedSize) &&
        Objects.equals(this.billableMinutes, encodingStats.billableMinutes) &&
        Objects.equals(this.billableEncodingMinutes, encodingStats.billableEncodingMinutes) &&
        Objects.equals(this.billableTransmuxingMinutes, encodingStats.billableTransmuxingMinutes) &&
        Objects.equals(this.billableFeatureMinutes, encodingStats.billableFeatureMinutes) &&
        Objects.equals(this.streams, encodingStats.streams) &&
        Objects.equals(this.muxings, encodingStats.muxings) &&
        Objects.equals(this.features, encodingStats.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, encodingId, bytesEncoded, timeEncoded, downloadedSize, billableMinutes, billableEncodingMinutes, billableTransmuxingMinutes, billableFeatureMinutes, streams, muxings, features);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingStats {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    encodingId: ").append(toIndentedString(encodingId)).append("\n");
    sb.append("    bytesEncoded: ").append(toIndentedString(bytesEncoded)).append("\n");
    sb.append("    timeEncoded: ").append(toIndentedString(timeEncoded)).append("\n");
    sb.append("    downloadedSize: ").append(toIndentedString(downloadedSize)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
    sb.append("    billableEncodingMinutes: ").append(toIndentedString(billableEncodingMinutes)).append("\n");
    sb.append("    billableTransmuxingMinutes: ").append(toIndentedString(billableTransmuxingMinutes)).append("\n");
    sb.append("    billableFeatureMinutes: ").append(toIndentedString(billableFeatureMinutes)).append("\n");
    sb.append("    streams: ").append(toIndentedString(streams)).append("\n");
    sb.append("    muxings: ").append(toIndentedString(muxings)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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

