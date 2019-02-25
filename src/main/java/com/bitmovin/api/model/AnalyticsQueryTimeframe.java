package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsQueryTimeframe
 */

public class AnalyticsQueryTimeframe {
  @JsonProperty("start")
  private Date start;

  @JsonProperty("end")
  private Date end;


  /**
   * Start of timeframe which is queried
   * @return start
  **/
  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }


  /**
   * End of timeframe which is queried
   * @return end
  **/
  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsQueryTimeframe analyticsQueryTimeframe = (AnalyticsQueryTimeframe) o;
    return Objects.equals(this.start, analyticsQueryTimeframe.start) &&
        Objects.equals(this.end, analyticsQueryTimeframe.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsQueryTimeframe {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

