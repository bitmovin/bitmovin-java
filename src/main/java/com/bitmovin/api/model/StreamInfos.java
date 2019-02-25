package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamInfosDetails;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StreamInfos
 */

public class StreamInfos {
  @JsonProperty("time")
  private Date time;

  @JsonProperty("streamInfos")
  private List<StreamInfosDetails> streamInfos;


  /**
   * Timestamp of the event expressed in UTC: YYYY-MM-DDThh:mm:ssZ
   * @return time
  **/
  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }


  public StreamInfos addStreamInfosItem(StreamInfosDetails streamInfosItem) {
    if (this.streamInfos == null) {
      this.streamInfos = new ArrayList<>();
    }
    this.streamInfos.add(streamInfosItem);
    return this;
  }

  /**
   * Details about billable minutes for each resolution category
   * @return streamInfos
  **/
  public List<StreamInfosDetails> getStreamInfos() {
    return streamInfos;
  }

  public void setStreamInfos(List<StreamInfosDetails> streamInfos) {
    this.streamInfos = streamInfos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamInfos streamInfos = (StreamInfos) o;
    return Objects.equals(this.time, streamInfos.time) &&
        Objects.equals(this.streamInfos, streamInfos.streamInfos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, streamInfos);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamInfos {\n");
    
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    streamInfos: ").append(toIndentedString(streamInfos)).append("\n");
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

