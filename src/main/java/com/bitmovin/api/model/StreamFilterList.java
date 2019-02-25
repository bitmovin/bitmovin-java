package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamFilter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StreamFilterList
 */

public class StreamFilterList {
  @JsonProperty("filters")
  private List<StreamFilter> filters = new ArrayList<StreamFilter>();


  public StreamFilterList addFiltersItem(StreamFilter filtersItem) {
    this.filters.add(filtersItem);
    return this;
  }

  /**
   * List of stream filters
   * @return filters
  **/
  public List<StreamFilter> getFilters() {
    return filters;
  }

  public void setFilters(List<StreamFilter> filters) {
    this.filters = filters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamFilterList streamFilterList = (StreamFilterList) o;
    return Objects.equals(this.filters, streamFilterList.filters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamFilterList {\n");
    
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
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

