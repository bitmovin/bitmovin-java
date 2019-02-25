package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import com.bitmovin.api.model.NotificationStates;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * NotificationStateEntry
 */

public class NotificationStateEntry extends BitmovinResponse {
  @JsonProperty("state")
  private NotificationStates state = null;

  @JsonProperty("muted")
  private Boolean muted;

  @JsonProperty("notificationId")
  private String notificationId;

  @JsonProperty("resourceId")
  private String resourceId;

  @JsonProperty("triggeredAt")
  private Date triggeredAt;


  /**
   * Get state
   * @return state
  **/
  public NotificationStates getState() {
    return state;
  }

  public void setState(NotificationStates state) {
    this.state = state;
  }


  /**
   * Indicate if notification was sent
   * @return muted
  **/
  public Boolean getMuted() {
    return muted;
  }

  public void setMuted(Boolean muted) {
    this.muted = muted;
  }


  /**
   * The notification this state belongs to
   * @return notificationId
  **/
  public String getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(String notificationId) {
    this.notificationId = notificationId;
  }


  /**
   * Indicate if triggered for specific resource
   * @return resourceId
  **/
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }


  /**
   * Get triggeredAt
   * @return triggeredAt
  **/
  public Date getTriggeredAt() {
    return triggeredAt;
  }

  public void setTriggeredAt(Date triggeredAt) {
    this.triggeredAt = triggeredAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationStateEntry notificationStateEntry = (NotificationStateEntry) o;
    return Objects.equals(this.state, notificationStateEntry.state) &&
        Objects.equals(this.muted, notificationStateEntry.muted) &&
        Objects.equals(this.notificationId, notificationStateEntry.notificationId) &&
        Objects.equals(this.resourceId, notificationStateEntry.resourceId) &&
        Objects.equals(this.triggeredAt, notificationStateEntry.triggeredAt) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, muted, notificationId, resourceId, triggeredAt, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationStateEntry {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    muted: ").append(toIndentedString(muted)).append("\n");
    sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    triggeredAt: ").append(toIndentedString(triggeredAt)).append("\n");
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

