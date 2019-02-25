package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.Id3Tag;
import com.bitmovin.api.model.Id3TagPositionMode;
import com.bitmovin.api.model.Id3TagType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * FrameIdId3Tag
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class FrameIdId3Tag extends Id3Tag {
  @JsonProperty("bytes")
  private String bytes;

  @JsonProperty("frameId")
  private String frameId;


  /**
   * Base64 Encoded Data
   * @return bytes
  **/
  public String getBytes() {
    return bytes;
  }

  public void setBytes(String bytes) {
    this.bytes = bytes;
  }


  /**
   * 4 character long Frame ID
   * @return frameId
  **/
  public String getFrameId() {
    return frameId;
  }

  public void setFrameId(String frameId) {
    this.frameId = frameId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FrameIdId3Tag frameIdId3Tag = (FrameIdId3Tag) o;
    return Objects.equals(this.bytes, frameIdId3Tag.bytes) &&
        Objects.equals(this.frameId, frameIdId3Tag.frameId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytes, frameId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FrameIdId3Tag {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    bytes: ").append(toIndentedString(bytes)).append("\n");
    sb.append("    frameId: ").append(toIndentedString(frameId)).append("\n");
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

