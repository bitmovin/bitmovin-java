package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SmoothManifestContentProtection
 */

public class SmoothManifestContentProtection extends BitmovinResource {
  @JsonProperty("encodingId")
  private String encodingId;

  @JsonProperty("muxingId")
  private String muxingId;

  @JsonProperty("drmId")
  private String drmId;


  /**
   * Id of the encoding.
   * @return encodingId
  **/
  public String getEncodingId() {
    return encodingId;
  }

  public void setEncodingId(String encodingId) {
    this.encodingId = encodingId;
  }


  /**
   * Id of the muxing.
   * @return muxingId
  **/
  public String getMuxingId() {
    return muxingId;
  }

  public void setMuxingId(String muxingId) {
    this.muxingId = muxingId;
  }


  /**
   * Id of the drm.
   * @return drmId
  **/
  public String getDrmId() {
    return drmId;
  }

  public void setDrmId(String drmId) {
    this.drmId = drmId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmoothManifestContentProtection smoothManifestContentProtection = (SmoothManifestContentProtection) o;
    return Objects.equals(this.encodingId, smoothManifestContentProtection.encodingId) &&
        Objects.equals(this.muxingId, smoothManifestContentProtection.muxingId) &&
        Objects.equals(this.drmId, smoothManifestContentProtection.drmId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodingId, muxingId, drmId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmoothManifestContentProtection {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    encodingId: ").append(toIndentedString(encodingId)).append("\n");
    sb.append("    muxingId: ").append(toIndentedString(muxingId)).append("\n");
    sb.append("    drmId: ").append(toIndentedString(drmId)).append("\n");
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

