package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.FolderEntryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * FolderEntry
 */

public class FolderEntry {
  @JsonProperty("type")
  private FolderEntryType type = null;

  @JsonProperty("path")
  private String path;


  /**
   * Get type
   * @return type
  **/
  public FolderEntryType getType() {
    return type;
  }

  public void setType(FolderEntryType type) {
    this.type = type;
  }


  /**
   * Get path
   * @return path
  **/
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FolderEntry folderEntry = (FolderEntry) o;
    return Objects.equals(this.type, folderEntry.type) &&
        Objects.equals(this.path, folderEntry.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, path);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FolderEntry {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

