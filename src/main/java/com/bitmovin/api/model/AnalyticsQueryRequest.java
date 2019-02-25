package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsFilter;
import com.bitmovin.api.model.AnalyticsInterval;
import com.bitmovin.api.model.AnalyticsOrderByEntry;
import com.bitmovin.api.model.AnalyticsQueryTimeframe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsQueryRequest
 */

public class AnalyticsQueryRequest extends AnalyticsQueryTimeframe {
  @JsonProperty("licenseKey")
  private String licenseKey;

  @JsonProperty("filters")
  private List<AnalyticsFilter> filters;

  @JsonProperty("orderBy")
  private List<AnalyticsOrderByEntry> orderBy;

  @JsonProperty("dimension")
  private String dimension;

  @JsonProperty("interval")
  private List<AnalyticsInterval> interval;

  @JsonProperty("groupBy")
  private List<String> groupBy;

  @JsonProperty("limit")
  private Long limit;

  @JsonProperty("offset")
  private Long offset;


  /**
   * Analytics license key
   * @return licenseKey
  **/
  public String getLicenseKey() {
    return licenseKey;
  }

  public void setLicenseKey(String licenseKey) {
    this.licenseKey = licenseKey;
  }


  public AnalyticsQueryRequest addFiltersItem(AnalyticsFilter filtersItem) {
    if (this.filters == null) {
      this.filters = new ArrayList<>();
    }
    this.filters.add(filtersItem);
    return this;
  }

  /**
   * Get filters
   * @return filters
  **/
  public List<AnalyticsFilter> getFilters() {
    return filters;
  }

  public void setFilters(List<AnalyticsFilter> filters) {
    this.filters = filters;
  }


  public AnalyticsQueryRequest addOrderByItem(AnalyticsOrderByEntry orderByItem) {
    if (this.orderBy == null) {
      this.orderBy = new ArrayList<>();
    }
    this.orderBy.add(orderByItem);
    return this;
  }

  /**
   * Get orderBy
   * @return orderBy
  **/
  public List<AnalyticsOrderByEntry> getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(List<AnalyticsOrderByEntry> orderBy) {
    this.orderBy = orderBy;
  }


  /**
   * Get dimension
   * @return dimension
  **/
  public String getDimension() {
    return dimension;
  }

  public void setDimension(String dimension) {
    this.dimension = dimension;
  }


  public AnalyticsQueryRequest addIntervalItem(AnalyticsInterval intervalItem) {
    if (this.interval == null) {
      this.interval = new ArrayList<>();
    }
    this.interval.add(intervalItem);
    return this;
  }

  /**
   * Get interval
   * @return interval
  **/
  public List<AnalyticsInterval> getInterval() {
    return interval;
  }

  public void setInterval(List<AnalyticsInterval> interval) {
    this.interval = interval;
  }


  public AnalyticsQueryRequest addGroupByItem(String groupByItem) {
    if (this.groupBy == null) {
      this.groupBy = new ArrayList<>();
    }
    this.groupBy.add(groupByItem);
    return this;
  }

  /**
   * Get groupBy
   * @return groupBy
  **/
  public List<String> getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(List<String> groupBy) {
    this.groupBy = groupBy;
  }


  /**
   * Maximum number of rows returned (max. 150)
   * @return limit
  **/
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }


  /**
   * Offset of data
   * @return offset
  **/
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsQueryRequest analyticsQueryRequest = (AnalyticsQueryRequest) o;
    return Objects.equals(this.licenseKey, analyticsQueryRequest.licenseKey) &&
        Objects.equals(this.filters, analyticsQueryRequest.filters) &&
        Objects.equals(this.orderBy, analyticsQueryRequest.orderBy) &&
        Objects.equals(this.dimension, analyticsQueryRequest.dimension) &&
        Objects.equals(this.interval, analyticsQueryRequest.interval) &&
        Objects.equals(this.groupBy, analyticsQueryRequest.groupBy) &&
        Objects.equals(this.limit, analyticsQueryRequest.limit) &&
        Objects.equals(this.offset, analyticsQueryRequest.offset) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenseKey, filters, orderBy, dimension, interval, groupBy, limit, offset, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsQueryRequest {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    licenseKey: ").append(toIndentedString(licenseKey)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    orderBy: ").append(toIndentedString(orderBy)).append("\n");
    sb.append("    dimension: ").append(toIndentedString(dimension)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    groupBy: ").append(toIndentedString(groupBy)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
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

