package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Scheduling
 */

public class Scheduling {
  @JsonProperty("priority")
  private Integer priority;

  @JsonProperty("prewarmedInstancePoolIds")
  private List<String> prewarmedInstancePoolIds;


  /**
   * Specify the priority of this encoding (0 - 100). Higher numbers mean higher priority. Default is 50.
   * minimum: 0
   * maximum: 100
   * @return priority
  **/
  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }


  public Scheduling addPrewarmedInstancePoolIdsItem(String prewarmedInstancePoolIdsItem) {
    if (this.prewarmedInstancePoolIds == null) {
      this.prewarmedInstancePoolIds = new ArrayList<>();
    }
    this.prewarmedInstancePoolIds.add(prewarmedInstancePoolIdsItem);
    return this;
  }

  /**
   * List of prewarmed Instance pools. If set, prewarmed instances from pools with these IDs will be used for the Encoding if available. The pool IDs will be tried in the order in which they are passed.
   * @return prewarmedInstancePoolIds
  **/
  public List<String> getPrewarmedInstancePoolIds() {
    return prewarmedInstancePoolIds;
  }

  public void setPrewarmedInstancePoolIds(List<String> prewarmedInstancePoolIds) {
    this.prewarmedInstancePoolIds = prewarmedInstancePoolIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scheduling scheduling = (Scheduling) o;
    return Objects.equals(this.priority, scheduling.priority) &&
        Objects.equals(this.prewarmedInstancePoolIds, scheduling.prewarmedInstancePoolIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, prewarmedInstancePoolIds);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scheduling {\n");
    
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    prewarmedInstancePoolIds: ").append(toIndentedString(prewarmedInstancePoolIds)).append("\n");
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

