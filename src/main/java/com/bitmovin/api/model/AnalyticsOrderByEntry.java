package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsOrderByEntry
 */

public class AnalyticsOrderByEntry {
  @JsonProperty("name")
  private String name;

  @JsonProperty("order")
  private AnalyticsOrder order = null;


  /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  /**
   * Get order
   * @return order
  **/
  public AnalyticsOrder getOrder() {
    return order;
  }

  public void setOrder(AnalyticsOrder order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsOrderByEntry analyticsOrderByEntry = (AnalyticsOrderByEntry) o;
    return Objects.equals(this.name, analyticsOrderByEntry.name) &&
        Objects.equals(this.order, analyticsOrderByEntry.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, order);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsOrderByEntry {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

