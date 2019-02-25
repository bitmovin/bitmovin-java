package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.DashRepresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * DashMp4Representation
 */

public class DashMp4Representation extends DashRepresentation {
  @JsonProperty("filePath")
  private String filePath;


  /**
   * Path to the MP4 file
   * @return filePath
  **/
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashMp4Representation dashMp4Representation = (DashMp4Representation) o;
    return Objects.equals(this.filePath, dashMp4Representation.filePath) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filePath, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashMp4Representation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
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

