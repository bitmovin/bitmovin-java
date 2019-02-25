package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DailyStatistics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DailyStatisticsPerLabel
 */

public class DailyStatisticsPerLabel {
  @JsonProperty("date")
  private Date date;

  @JsonProperty("labels")
  private List<DailyStatistics> labels = new ArrayList<DailyStatistics>();


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


  public DailyStatisticsPerLabel addLabelsItem(DailyStatistics labelsItem) {
    this.labels.add(labelsItem);
    return this;
  }

  /**
   * List of labels and their aggregated statistics
   * @return labels
  **/
  public List<DailyStatistics> getLabels() {
    return labels;
  }

  public void setLabels(List<DailyStatistics> labels) {
    this.labels = labels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailyStatisticsPerLabel dailyStatisticsPerLabel = (DailyStatisticsPerLabel) o;
    return Objects.equals(this.date, dailyStatisticsPerLabel.date) &&
        Objects.equals(this.labels, dailyStatisticsPerLabel.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, labels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailyStatisticsPerLabel {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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

