package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.ResponseStatus;
import com.bitmovin.api.model.ResultWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ResponseEnvelope
 */

public class ResponseEnvelope<T> {
  @JsonProperty("requestId")
  private String requestId;

  @JsonProperty("status")
  private ResponseStatus status = null;

  @JsonProperty("data")
  private ResultWrapper<T> data = null;

  @JsonProperty("more")
  private Object more = null;

  /**
   * Unique correlation id
   * @return requestId
  **/
  public String getRequestId() {
    return requestId;
  }

  /**
   * Response status information
   * @return status
  **/
  public ResponseStatus getStatus() {
    return status;
  }

  /**
   * Response information
   * @return data
  **/
  public ResultWrapper<T> getData() {
    return data;
  }


  /**
   * Additional endpoint specific information
   * @return more
  **/
  public Object getMore() {
    return more;
  }

  public void setMore(Object more) {
    this.more = more;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseEnvelope responseEnvelope = (ResponseEnvelope) o;
    return Objects.equals(this.requestId, responseEnvelope.requestId) &&
        Objects.equals(this.status, responseEnvelope.status) &&
        Objects.equals(this.data, responseEnvelope.data) &&
        Objects.equals(this.more, responseEnvelope.more);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, status, data, more);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseEnvelope {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    more: ").append(toIndentedString(more)).append("\n");
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

