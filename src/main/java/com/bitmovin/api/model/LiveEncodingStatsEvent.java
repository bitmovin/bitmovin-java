package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.LiveEncodingStatsEventDetails;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveEncodingStatsEvent
 */

public class LiveEncodingStatsEvent {
  @JsonProperty("time")
  private Date time;

  @JsonProperty("details")
  private LiveEncodingStatsEventDetails details = null;


  /**
   * Timestamp of the event expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return time
  **/
  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }


  /**
   * Get details
   * @return details
  **/
  public LiveEncodingStatsEventDetails getDetails() {
    return details;
  }

  public void setDetails(LiveEncodingStatsEventDetails details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveEncodingStatsEvent liveEncodingStatsEvent = (LiveEncodingStatsEvent) o;
    return Objects.equals(this.time, liveEncodingStatsEvent.time) &&
        Objects.equals(this.details, liveEncodingStatsEvent.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, details);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveEncodingStatsEvent {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

