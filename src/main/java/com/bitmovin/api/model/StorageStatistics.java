package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StorageStatistics
 */

public class StorageStatistics {
  @JsonProperty("bytesStored")
  private Long bytesStored;

  @JsonProperty("bytesTransferred")
  private Long bytesTransferred;

  @JsonProperty("storage")
  private String storage;


  /**
   * Get bytesStored
   * @return bytesStored
  **/
  public Long getBytesStored() {
    return bytesStored;
  }

  public void setBytesStored(Long bytesStored) {
    this.bytesStored = bytesStored;
  }


  /**
   * Get bytesTransferred
   * @return bytesTransferred
  **/
  public Long getBytesTransferred() {
    return bytesTransferred;
  }

  public void setBytesTransferred(Long bytesTransferred) {
    this.bytesTransferred = bytesTransferred;
  }


  /**
   * Get storage
   * @return storage
  **/
  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StorageStatistics storageStatistics = (StorageStatistics) o;
    return Objects.equals(this.bytesStored, storageStatistics.bytesStored) &&
        Objects.equals(this.bytesTransferred, storageStatistics.bytesTransferred) &&
        Objects.equals(this.storage, storageStatistics.storage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytesStored, bytesTransferred, storage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StorageStatistics {\n");
    
    sb.append("    bytesStored: ").append(toIndentedString(bytesStored)).append("\n");
    sb.append("    bytesTransferred: ").append(toIndentedString(bytesTransferred)).append("\n");
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
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

