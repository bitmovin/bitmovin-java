package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * TimeCode
 */

public class TimeCode {
  @JsonProperty("timeCodeStart")
  private String timeCodeStart;


  /**
   * Specify start timecode for writing.
   * @return timeCodeStart
  **/
  public String getTimeCodeStart() {
    return timeCodeStart;
  }

  public void setTimeCodeStart(String timeCodeStart) {
    this.timeCodeStart = timeCodeStart;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeCode timeCode = (TimeCode) o;
    return Objects.equals(this.timeCodeStart, timeCode.timeCodeStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeCodeStart);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeCode {\n");
    
    sb.append("    timeCodeStart: ").append(toIndentedString(timeCodeStart)).append("\n");
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

