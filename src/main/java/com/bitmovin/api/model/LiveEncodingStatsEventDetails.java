package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.LiveEncodingEventName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * LiveEncodingStatsEventDetails
 */

public class LiveEncodingStatsEventDetails {
  @JsonProperty("eventName")
  private LiveEncodingEventName eventName = null;

  @JsonProperty("avDriftInSeconds")
  private Integer avDriftInSeconds;

  @JsonProperty("idleDurationInSeconds")
  private Integer idleDurationInSeconds;

  @JsonProperty("errorMessage")
  private String errorMessage;


  /**
   * Get eventName
   * @return eventName
  **/
  public LiveEncodingEventName getEventName() {
    return eventName;
  }

  public void setEventName(LiveEncodingEventName eventName) {
    this.eventName = eventName;
  }


  /**
   * The Audio/Video Drift in seconds. The drift was corrected by the RESYNCING event (occurs at event: RESYNCING)
   * @return avDriftInSeconds
  **/
  public Integer getAvDriftInSeconds() {
    return avDriftInSeconds;
  }

  public void setAvDriftInSeconds(Integer avDriftInSeconds) {
    this.avDriftInSeconds = avDriftInSeconds;
  }


  /**
   * The time the stream was in idle state in seconds (occurs at event: IDLE)
   * @return idleDurationInSeconds
  **/
  public Integer getIdleDurationInSeconds() {
    return idleDurationInSeconds;
  }

  public void setIdleDurationInSeconds(Integer idleDurationInSeconds) {
    this.idleDurationInSeconds = idleDurationInSeconds;
  }


  /**
   * An optional error message, when the event is in error state (occurs at event: ERROR)
   * @return errorMessage
  **/
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LiveEncodingStatsEventDetails liveEncodingStatsEventDetails = (LiveEncodingStatsEventDetails) o;
    return Objects.equals(this.eventName, liveEncodingStatsEventDetails.eventName) &&
        Objects.equals(this.avDriftInSeconds, liveEncodingStatsEventDetails.avDriftInSeconds) &&
        Objects.equals(this.idleDurationInSeconds, liveEncodingStatsEventDetails.idleDurationInSeconds) &&
        Objects.equals(this.errorMessage, liveEncodingStatsEventDetails.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, avDriftInSeconds, idleDurationInSeconds, errorMessage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LiveEncodingStatsEventDetails {\n");
    
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    avDriftInSeconds: ").append(toIndentedString(avDriftInSeconds)).append("\n");
    sb.append("    idleDurationInSeconds: ").append(toIndentedString(idleDurationInSeconds)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

