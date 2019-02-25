package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.MuxingType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StatisticsPerMuxing
 */

public class StatisticsPerMuxing {
  @JsonProperty("streamId")
  private String streamId;

  @JsonProperty("muxingId")
  private String muxingId;

  @JsonProperty("multiplicator")
  private Double multiplicator;

  @JsonProperty("encodedBytes")
  private Long encodedBytes;

  @JsonProperty("billableMinutes")
  private Double billableMinutes;

  @JsonProperty("muxingType")
  private MuxingType muxingType = null;


  /**
   * ID of the stream
   * @return streamId
  **/
  public String getStreamId() {
    return streamId;
  }

  public void setStreamId(String streamId) {
    this.streamId = streamId;
  }


  /**
   * ID of the muxing
   * @return muxingId
  **/
  public String getMuxingId() {
    return muxingId;
  }

  public void setMuxingId(String muxingId) {
    this.muxingId = muxingId;
  }


  /**
   * Multiplier for the encoded minutes. Depends on muxing type.
   * @return multiplicator
  **/
  public Double getMultiplicator() {
    return multiplicator;
  }

  public void setMultiplicator(Double multiplicator) {
    this.multiplicator = multiplicator;
  }


  /**
   * Encoded bytes.
   * @return encodedBytes
  **/
  public Long getEncodedBytes() {
    return encodedBytes;
  }

  public void setEncodedBytes(Long encodedBytes) {
    this.encodedBytes = encodedBytes;
  }


  /**
   * Resulting minutes you will be charged for.
   * @return billableMinutes
  **/
  public Double getBillableMinutes() {
    return billableMinutes;
  }

  public void setBillableMinutes(Double billableMinutes) {
    this.billableMinutes = billableMinutes;
  }


  /**
   * Get muxingType
   * @return muxingType
  **/
  public MuxingType getMuxingType() {
    return muxingType;
  }

  public void setMuxingType(MuxingType muxingType) {
    this.muxingType = muxingType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticsPerMuxing statisticsPerMuxing = (StatisticsPerMuxing) o;
    return Objects.equals(this.streamId, statisticsPerMuxing.streamId) &&
        Objects.equals(this.muxingId, statisticsPerMuxing.muxingId) &&
        Objects.equals(this.multiplicator, statisticsPerMuxing.multiplicator) &&
        Objects.equals(this.encodedBytes, statisticsPerMuxing.encodedBytes) &&
        Objects.equals(this.billableMinutes, statisticsPerMuxing.billableMinutes) &&
        Objects.equals(this.muxingType, statisticsPerMuxing.muxingType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streamId, muxingId, multiplicator, encodedBytes, billableMinutes, muxingType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatisticsPerMuxing {\n");
    
    sb.append("    streamId: ").append(toIndentedString(streamId)).append("\n");
    sb.append("    muxingId: ").append(toIndentedString(muxingId)).append("\n");
    sb.append("    multiplicator: ").append(toIndentedString(multiplicator)).append("\n");
    sb.append("    encodedBytes: ").append(toIndentedString(encodedBytes)).append("\n");
    sb.append("    billableMinutes: ").append(toIndentedString(billableMinutes)).append("\n");
    sb.append("    muxingType: ").append(toIndentedString(muxingType)).append("\n");
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

