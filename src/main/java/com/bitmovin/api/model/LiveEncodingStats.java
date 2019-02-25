package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.LiveEncodingStatsEvent;
import com.bitmovin.api.model.LiveEncodingStatus;
import com.bitmovin.api.model.StreamInfos;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveEncodingStats
 */

public class LiveEncodingStats {
  @JsonProperty("status")
  private LiveEncodingStatus status = null;

  @JsonProperty("events")
  private List<LiveEncodingStatsEvent> events;

  @JsonProperty("statistics")
  private List<StreamInfos> statistics;


  /**
   * Get status
   * @return status
  **/
  public LiveEncodingStatus getStatus() {
    return status;
  }

  public void setStatus(LiveEncodingStatus status) {
    this.status = status;
  }


  public LiveEncodingStats addEventsItem(LiveEncodingStatsEvent eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<>();
    }
    this.events.add(eventsItem);
    return this;
  }

  /**
   * List of events
   * @return events
  **/
  public List<LiveEncodingStatsEvent> getEvents() {
    return events;
  }

  public void setEvents(List<LiveEncodingStatsEvent> events) {
    this.events = events;
  }


  public LiveEncodingStats addStatisticsItem(StreamInfos statisticsItem) {
    if (this.statistics == null) {
      this.statistics = new ArrayList<>();
    }
    this.statistics.add(statisticsItem);
    return this;
  }

  /**
   * List of statistics
   * @return statistics
  **/
  public List<StreamInfos> getStatistics() {
    return statistics;
  }

  public void setStatistics(List<StreamInfos> statistics) {
    this.statistics = statistics;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveEncodingStats liveEncodingStats = (LiveEncodingStats) o;
    return Objects.equals(this.status, liveEncodingStats.status) &&
        Objects.equals(this.events, liveEncodingStats.events) &&
        Objects.equals(this.statistics, liveEncodingStats.statistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, events, statistics);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveEncodingStats {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
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

