package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingStatistics
 */

public class EncodingStatistics {
  @JsonProperty("date")
  private Date date;

  @JsonProperty("bytesEncoded")
  private Long bytesEncoded;

  @JsonProperty("timeEncoded")
  private Long timeEncoded;


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
   * Bytes encoded for this encoding.
   * @return bytesEncoded
  **/
  public Long getBytesEncoded() {
    return bytesEncoded;
  }

  public void setBytesEncoded(Long bytesEncoded) {
    this.bytesEncoded = bytesEncoded;
  }


  /**
   * Time in seconds encoded for this encoding.
   * @return timeEncoded
  **/
  public Long getTimeEncoded() {
    return timeEncoded;
  }

  public void setTimeEncoded(Long timeEncoded) {
    this.timeEncoded = timeEncoded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingStatistics encodingStatistics = (EncodingStatistics) o;
    return Objects.equals(this.date, encodingStatistics.date) &&
        Objects.equals(this.bytesEncoded, encodingStatistics.bytesEncoded) &&
        Objects.equals(this.timeEncoded, encodingStatistics.timeEncoded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, bytesEncoded, timeEncoded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingStatistics {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    bytesEncoded: ").append(toIndentedString(bytesEncoded)).append("\n");
    sb.append("    timeEncoded: ").append(toIndentedString(timeEncoded)).append("\n");
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

