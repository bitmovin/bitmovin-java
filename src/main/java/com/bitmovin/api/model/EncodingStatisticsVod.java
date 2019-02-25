package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingStatistics;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingStatisticsVod
 */

public class EncodingStatisticsVod extends EncodingStatistics {
  @JsonProperty("timeEnqueued")
  private Long timeEnqueued;

  @JsonProperty("realTimeFactor")
  private Double realTimeFactor;


  /**
   * Time in seconds encoded for this encoding.
   * @return timeEnqueued
  **/
  public Long getTimeEnqueued() {
    return timeEnqueued;
  }

  public void setTimeEnqueued(Long timeEnqueued) {
    this.timeEnqueued = timeEnqueued;
  }


  /**
   * The realtime factor.
   * @return realTimeFactor
  **/
  public Double getRealTimeFactor() {
    return realTimeFactor;
  }

  public void setRealTimeFactor(Double realTimeFactor) {
    this.realTimeFactor = realTimeFactor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingStatisticsVod encodingStatisticsVod = (EncodingStatisticsVod) o;
    return Objects.equals(this.timeEnqueued, encodingStatisticsVod.timeEnqueued) &&
        Objects.equals(this.realTimeFactor, encodingStatisticsVod.realTimeFactor) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeEnqueued, realTimeFactor, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingStatisticsVod {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    timeEnqueued: ").append(toIndentedString(timeEnqueued)).append("\n");
    sb.append("    realTimeFactor: ").append(toIndentedString(realTimeFactor)).append("\n");
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

