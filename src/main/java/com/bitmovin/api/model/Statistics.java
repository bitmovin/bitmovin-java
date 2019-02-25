package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Statistics
 */

public class Statistics {
  @JsonProperty("bytesEncodedTotal")
  private Long bytesEncodedTotal;

  @JsonProperty("timeEncodedTotal")
  private Long timeEncodedTotal;


  /**
   * Bytes encoded total.
   * @return bytesEncodedTotal
  **/
  public Long getBytesEncodedTotal() {
    return bytesEncodedTotal;
  }

  public void setBytesEncodedTotal(Long bytesEncodedTotal) {
    this.bytesEncodedTotal = bytesEncodedTotal;
  }


  /**
   * Time in seconds encoded for all contained daily statistics.
   * @return timeEncodedTotal
  **/
  public Long getTimeEncodedTotal() {
    return timeEncodedTotal;
  }

  public void setTimeEncodedTotal(Long timeEncodedTotal) {
    this.timeEncodedTotal = timeEncodedTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics statistics = (Statistics) o;
    return Objects.equals(this.bytesEncodedTotal, statistics.bytesEncodedTotal) &&
        Objects.equals(this.timeEncodedTotal, statistics.timeEncodedTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytesEncodedTotal, timeEncodedTotal);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Statistics {\n");
    
    sb.append("    bytesEncodedTotal: ").append(toIndentedString(bytesEncodedTotal)).append("\n");
    sb.append("    timeEncodedTotal: ").append(toIndentedString(timeEncodedTotal)).append("\n");
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

