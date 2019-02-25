package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsFilter;
import com.bitmovin.api.model.AnalyticsInterval;
import com.bitmovin.api.model.AnalyticsOrderByEntry;
import com.bitmovin.api.model.AnalyticsQueryRequest;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsPercentileQueryRequest
 */

public class AnalyticsPercentileQueryRequest extends AnalyticsQueryRequest {
  @JsonProperty("percentile")
  private Long percentile;


  /**
   * The percentage (0-99) used for percentile queries.
   * @return percentile
  **/
  public Long getPercentile() {
    return percentile;
  }

  public void setPercentile(Long percentile) {
    this.percentile = percentile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsPercentileQueryRequest analyticsPercentileQueryRequest = (AnalyticsPercentileQueryRequest) o;
    return Objects.equals(this.percentile, analyticsPercentileQueryRequest.percentile) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(percentile, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsPercentileQueryRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    percentile: ").append(toIndentedString(percentile)).append("\n");
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

