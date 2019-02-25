package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AnalyticsOperator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalyticsFilter
 */

public class AnalyticsFilter {
  @JsonProperty("name")
  private String name;

  @JsonProperty("operator")
  private AnalyticsOperator operator = null;

  @JsonProperty("value")
  private String value;


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
   * Get operator
   * @return operator
  **/
  public AnalyticsOperator getOperator() {
    return operator;
  }

  public void setOperator(AnalyticsOperator operator) {
    this.operator = operator;
  }


  /**
   * The value to compare to the property specified by the name
   * @return value
  **/
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalyticsFilter analyticsFilter = (AnalyticsFilter) o;
    return Objects.equals(this.name, analyticsFilter.name) &&
        Objects.equals(this.operator, analyticsFilter.operator) &&
        Objects.equals(this.value, analyticsFilter.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, operator, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalyticsFilter {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

