package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Message;
import com.bitmovin.api.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * CustomPlayerBuildStatus
 */

public class CustomPlayerBuildStatus {
  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("eta")
  private Integer eta;

  @JsonProperty("progress")
  private Integer progress;

  @JsonProperty("messages")
  private Message messages = null;

  @JsonProperty("subtasks")
  private String subtasks;


  /**
   * Status of the player build
   * @return status
  **/
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  /**
   * The estimated time span of the custom player build in seconds.
   * @return eta
  **/
  public Integer getEta() {
    return eta;
  }

  public void setEta(Integer eta) {
    this.eta = eta;
  }


  /**
   * The actual progress of the custom player build.
   * @return progress
  **/
  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }


  /**
   * Get messages
   * @return messages
  **/
  public Message getMessages() {
    return messages;
  }

  public void setMessages(Message messages) {
    this.messages = messages;
  }


  /**
   * Get subtasks
   * @return subtasks
  **/
  public String getSubtasks() {
    return subtasks;
  }

  public void setSubtasks(String subtasks) {
    this.subtasks = subtasks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomPlayerBuildStatus customPlayerBuildStatus = (CustomPlayerBuildStatus) o;
    return Objects.equals(this.status, customPlayerBuildStatus.status) &&
        Objects.equals(this.eta, customPlayerBuildStatus.eta) &&
        Objects.equals(this.progress, customPlayerBuildStatus.progress) &&
        Objects.equals(this.messages, customPlayerBuildStatus.messages) &&
        Objects.equals(this.subtasks, customPlayerBuildStatus.subtasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, eta, progress, messages, subtasks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomPlayerBuildStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    eta: ").append(toIndentedString(eta)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    subtasks: ").append(toIndentedString(subtasks)).append("\n");
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

