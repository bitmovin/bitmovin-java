package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import com.bitmovin.api.model.Message;
import com.bitmovin.api.model.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Subtask
 */

public class Subtask extends BitmovinResponse {
  @JsonProperty("status")
  private Status status = null;

  @JsonProperty("progress")
  private Integer progress;

  @JsonProperty("name")
  private String name;

  @JsonProperty("messages")
  private List<Message> messages;

  @JsonProperty("createdAt")
  private Date createdAt;

  @JsonProperty("updatedAt")
  private Date updatedAt;

  @JsonProperty("startedAt")
  private Date startedAt;

  @JsonProperty("queuedAt")
  private Date queuedAt;

  @JsonProperty("runningAt")
  private Date runningAt;

  @JsonProperty("finishedAt")
  private Date finishedAt;

  @JsonProperty("errorAt")
  private Date errorAt;


  /**
   * Current status
   * @return status
  **/
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  /**
   * Progress in percent
   * @return progress
  **/
  public Integer getProgress() {
    return progress;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }


  /**
   * Name of the subtask
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Subtask addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Task specific messages
   * @return messages
  **/
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }


  /**
   * Timestamp when the subtask was created, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return createdAt
  **/
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }


  /**
   * Timestamp when the subtask was last updated, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return updatedAt
  **/
  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }


  /**
   * Timestamp when the subtask was started, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return startedAt
  **/
  public Date getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(Date startedAt) {
    this.startedAt = startedAt;
  }


  /**
   * Timestamp when the subtask status changed to &#39;QUEUED&#39;, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return queuedAt
  **/
  public Date getQueuedAt() {
    return queuedAt;
  }

  public void setQueuedAt(Date queuedAt) {
    this.queuedAt = queuedAt;
  }


  /**
   * Timestamp when the subtask status changed to to &#39;RUNNING&#39;, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return runningAt
  **/
  public Date getRunningAt() {
    return runningAt;
  }

  public void setRunningAt(Date runningAt) {
    this.runningAt = runningAt;
  }


  /**
   * Timestamp when the subtask status changed to &#39;FINISHED&#39;, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return finishedAt
  **/
  public Date getFinishedAt() {
    return finishedAt;
  }

  public void setFinishedAt(Date finishedAt) {
    this.finishedAt = finishedAt;
  }


  /**
   * Timestamp when the subtask status changed to &#39;ERROR&#39;, expressed in UTC: YYYY-MM-DDThh:mm:ssZ 
   * @return errorAt
  **/
  public Date getErrorAt() {
    return errorAt;
  }

  public void setErrorAt(Date errorAt) {
    this.errorAt = errorAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subtask subtask = (Subtask) o;
    return Objects.equals(this.status, subtask.status) &&
        Objects.equals(this.progress, subtask.progress) &&
        Objects.equals(this.name, subtask.name) &&
        Objects.equals(this.messages, subtask.messages) &&
        Objects.equals(this.createdAt, subtask.createdAt) &&
        Objects.equals(this.updatedAt, subtask.updatedAt) &&
        Objects.equals(this.startedAt, subtask.startedAt) &&
        Objects.equals(this.queuedAt, subtask.queuedAt) &&
        Objects.equals(this.runningAt, subtask.runningAt) &&
        Objects.equals(this.finishedAt, subtask.finishedAt) &&
        Objects.equals(this.errorAt, subtask.errorAt) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, progress, name, messages, createdAt, updatedAt, startedAt, queuedAt, runningAt, finishedAt, errorAt, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subtask {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    startedAt: ").append(toIndentedString(startedAt)).append("\n");
    sb.append("    queuedAt: ").append(toIndentedString(queuedAt)).append("\n");
    sb.append("    runningAt: ").append(toIndentedString(runningAt)).append("\n");
    sb.append("    finishedAt: ").append(toIndentedString(finishedAt)).append("\n");
    sb.append("    errorAt: ").append(toIndentedString(errorAt)).append("\n");
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

