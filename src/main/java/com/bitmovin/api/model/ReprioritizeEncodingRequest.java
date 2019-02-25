package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ReprioritizeEncodingRequest
 */

public class ReprioritizeEncodingRequest {
  @JsonProperty("priority")
  private Integer priority;


  /**
   * Priority of the Encoding
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReprioritizeEncodingRequest reprioritizeEncodingRequest = (ReprioritizeEncodingRequest) o;
    return Objects.equals(this.priority, reprioritizeEncodingRequest.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReprioritizeEncodingRequest {\n");
    
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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

