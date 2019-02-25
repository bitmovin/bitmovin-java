package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.FilterType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * FilterTypeResponse
 */

public class FilterTypeResponse {
  @JsonProperty("type")
  private FilterType type = null;


  /**
   * The type of the filter
   * @return type
  **/
  public FilterType getType() {
    return type;
  }

  public void setType(FilterType type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterTypeResponse filterTypeResponse = (FilterTypeResponse) o;
    return Objects.equals(this.type, filterTypeResponse.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterTypeResponse {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

