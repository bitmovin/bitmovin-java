package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EmailNotification;
import com.bitmovin.api.model.StreamCondition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EmailNotificationWithStreamConditions
 */

public class EmailNotificationWithStreamConditions extends EmailNotification {
  @JsonProperty("conditions")
  private List<StreamCondition> conditions;


  public EmailNotificationWithStreamConditions addConditionsItem(StreamCondition conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * Get conditions
   * @return conditions
  **/
  public List<StreamCondition> getConditions() {
    return conditions;
  }

  public void setConditions(List<StreamCondition> conditions) {
    this.conditions = conditions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailNotificationWithStreamConditions emailNotificationWithStreamConditions = (EmailNotificationWithStreamConditions) o;
    return Objects.equals(this.conditions, emailNotificationWithStreamConditions.conditions) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditions, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailNotificationWithStreamConditions {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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

