package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * RtmpIngestPoint
 */

public class RtmpIngestPoint {
  @JsonProperty("applicationName")
  private String applicationName;

  @JsonProperty("streamKey")
  private String streamKey;


  /**
   * The name of the application where the ingest is streamed to. This has to be unique for each ingest point
   * @return applicationName
  **/
  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }


  /**
   * The stream key for the backup input
   * @return streamKey
  **/
  public String getStreamKey() {
    return streamKey;
  }

  public void setStreamKey(String streamKey) {
    this.streamKey = streamKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RtmpIngestPoint rtmpIngestPoint = (RtmpIngestPoint) o;
    return Objects.equals(this.applicationName, rtmpIngestPoint.applicationName) &&
        Objects.equals(this.streamKey, rtmpIngestPoint.streamKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationName, streamKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RtmpIngestPoint {\n");
    
    sb.append("    applicationName: ").append(toIndentedString(applicationName)).append("\n");
    sb.append("    streamKey: ").append(toIndentedString(streamKey)).append("\n");
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

