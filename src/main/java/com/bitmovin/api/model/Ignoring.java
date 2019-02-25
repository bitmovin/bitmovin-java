package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.IgnoredBy;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Ignoring
 */

public class Ignoring {
  @JsonProperty("ignoredBy")
  private IgnoredBy ignoredBy = null;

  @JsonProperty("ignoredByDescription")
  private String ignoredByDescription;

  /**
   * Get ignoredBy
   * @return ignoredBy
  **/
  public IgnoredBy getIgnoredBy() {
    return ignoredBy;
  }

  /**
   * Describes why ignoredBy has been set to its current value.
   * @return ignoredByDescription
  **/
  public String getIgnoredByDescription() {
    return ignoredByDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ignoring ignoring = (Ignoring) o;
    return Objects.equals(this.ignoredBy, ignoring.ignoredBy) &&
        Objects.equals(this.ignoredByDescription, ignoring.ignoredByDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ignoredBy, ignoredByDescription);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ignoring {\n");
    
    sb.append("    ignoredBy: ").append(toIndentedString(ignoredBy)).append("\n");
    sb.append("    ignoredByDescription: ").append(toIndentedString(ignoredByDescription)).append("\n");
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

