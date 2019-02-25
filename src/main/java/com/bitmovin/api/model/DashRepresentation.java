package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashRepresentation
 */

public class DashRepresentation extends BitmovinResponse {
  @JsonProperty("encodingId")
  private String encodingId;

  @JsonProperty("muxingId")
  private String muxingId;


  /**
   * UUID of an encoding
   * @return encodingId
  **/
  public String getEncodingId() {
    return encodingId;
  }

  public void setEncodingId(String encodingId) {
    this.encodingId = encodingId;
  }


  /**
   * UUID of a muxing
   * @return muxingId
  **/
  public String getMuxingId() {
    return muxingId;
  }

  public void setMuxingId(String muxingId) {
    this.muxingId = muxingId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashRepresentation dashRepresentation = (DashRepresentation) o;
    return Objects.equals(this.encodingId, dashRepresentation.encodingId) &&
        Objects.equals(this.muxingId, dashRepresentation.muxingId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodingId, muxingId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    encodingId: ").append(toIndentedString(encodingId)).append("\n");
    sb.append("    muxingId: ").append(toIndentedString(muxingId)).append("\n");
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

