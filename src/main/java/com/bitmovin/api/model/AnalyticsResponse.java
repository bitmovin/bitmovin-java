package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsColumnLabel;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsResponse
 */

public class AnalyticsResponse {
  @JsonProperty("rows")
  private List<Object> rows;

  @JsonProperty("rowCount")
  private Long rowCount;

  @JsonProperty("columnLabels")
  private List<AnalyticsColumnLabel> columnLabels;


  public AnalyticsResponse addRowsItem(Object rowsItem) {
    if (this.rows == null) {
      this.rows = new ArrayList<>();
    }
    this.rows.add(rowsItem);
    return this;
  }

  /**
   * Get rows
   * @return rows
  **/
  public List<Object> getRows() {
    return rows;
  }

  public void setRows(List<Object> rows) {
    this.rows = rows;
  }


  /**
   * Number of rows returned
   * @return rowCount
  **/
  public Long getRowCount() {
    return rowCount;
  }

  public void setRowCount(Long rowCount) {
    this.rowCount = rowCount;
  }


  public AnalyticsResponse addColumnLabelsItem(AnalyticsColumnLabel columnLabelsItem) {
    if (this.columnLabels == null) {
      this.columnLabels = new ArrayList<>();
    }
    this.columnLabels.add(columnLabelsItem);
    return this;
  }

  /**
   * Get columnLabels
   * @return columnLabels
  **/
  public List<AnalyticsColumnLabel> getColumnLabels() {
    return columnLabels;
  }

  public void setColumnLabels(List<AnalyticsColumnLabel> columnLabels) {
    this.columnLabels = columnLabels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsResponse analyticsResponse = (AnalyticsResponse) o;
    return Objects.equals(this.rows, analyticsResponse.rows) &&
        Objects.equals(this.rowCount, analyticsResponse.rowCount) &&
        Objects.equals(this.columnLabels, analyticsResponse.columnLabels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rows, rowCount, columnLabels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsResponse {\n");
    
    sb.append("    rows: ").append(toIndentedString(rows)).append("\n");
    sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
    sb.append("    columnLabels: ").append(toIndentedString(columnLabels)).append("\n");
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

