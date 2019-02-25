package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StorageStatistics;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * OverallStatistics
 */

public class OverallStatistics {
  @JsonProperty("bytesStoredTotal")
  private Long bytesStoredTotal;

  @JsonProperty("bytesTransferredTotal")
  private Long bytesTransferredTotal;

  @JsonProperty("storages")
  private List<StorageStatistics> storages;


  /**
   * Get bytesStoredTotal
   * @return bytesStoredTotal
  **/
  public Long getBytesStoredTotal() {
    return bytesStoredTotal;
  }

  public void setBytesStoredTotal(Long bytesStoredTotal) {
    this.bytesStoredTotal = bytesStoredTotal;
  }


  /**
   * Get bytesTransferredTotal
   * @return bytesTransferredTotal
  **/
  public Long getBytesTransferredTotal() {
    return bytesTransferredTotal;
  }

  public void setBytesTransferredTotal(Long bytesTransferredTotal) {
    this.bytesTransferredTotal = bytesTransferredTotal;
  }


  public OverallStatistics addStoragesItem(StorageStatistics storagesItem) {
    if (this.storages == null) {
      this.storages = new ArrayList<>();
    }
    this.storages.add(storagesItem);
    return this;
  }

  /**
   * Get storages
   * @return storages
  **/
  public List<StorageStatistics> getStorages() {
    return storages;
  }

  public void setStorages(List<StorageStatistics> storages) {
    this.storages = storages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OverallStatistics overallStatistics = (OverallStatistics) o;
    return Objects.equals(this.bytesStoredTotal, overallStatistics.bytesStoredTotal) &&
        Objects.equals(this.bytesTransferredTotal, overallStatistics.bytesTransferredTotal) &&
        Objects.equals(this.storages, overallStatistics.storages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bytesStoredTotal, bytesTransferredTotal, storages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OverallStatistics {\n");
    
    sb.append("    bytesStoredTotal: ").append(toIndentedString(bytesStoredTotal)).append("\n");
    sb.append("    bytesTransferredTotal: ").append(toIndentedString(bytesTransferredTotal)).append("\n");
    sb.append("    storages: ").append(toIndentedString(storages)).append("\n");
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

