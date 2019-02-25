package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BroadcastTsInputStreamConfiguration;
import com.bitmovin.api.model.RaiUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BroadcastTsVideoInputStreamConfiguration
 */

public class BroadcastTsVideoInputStreamConfiguration extends BroadcastTsInputStreamConfiguration {
  @JsonProperty("insertAccessUnitDelimiterInAvc")
  private Boolean insertAccessUnitDelimiterInAvc;

  @JsonProperty("maxDecodeDelay")
  private Integer maxDecodeDelay;


  /**
   * If true, add access unit delimiters (AUD) to AVC stream if AUD is missing from input elementary stream.
   * @return insertAccessUnitDelimiterInAvc
  **/
  public Boolean getInsertAccessUnitDelimiterInAvc() {
    return insertAccessUnitDelimiterInAvc;
  }

  public void setInsertAccessUnitDelimiterInAvc(Boolean insertAccessUnitDelimiterInAvc) {
    this.insertAccessUnitDelimiterInAvc = insertAccessUnitDelimiterInAvc;
  }


  /**
   * Maximum Decoder Delay in 90 KHz cycles. When non-zero, the difference between the PCR and the DTS for each picture as it is inserted into the output transport stream is limited to this number of 90 KHz cycles. Values below 1000 are treated as 0 and ignored. Valid Range [0, 1000-900000]
   * minimum: 1000
   * maximum: 900000
   * @return maxDecodeDelay
  **/
  public Integer getMaxDecodeDelay() {
    return maxDecodeDelay;
  }

  public void setMaxDecodeDelay(Integer maxDecodeDelay) {
    this.maxDecodeDelay = maxDecodeDelay;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastTsVideoInputStreamConfiguration broadcastTsVideoInputStreamConfiguration = (BroadcastTsVideoInputStreamConfiguration) o;
    return Objects.equals(this.insertAccessUnitDelimiterInAvc, broadcastTsVideoInputStreamConfiguration.insertAccessUnitDelimiterInAvc) &&
        Objects.equals(this.maxDecodeDelay, broadcastTsVideoInputStreamConfiguration.maxDecodeDelay) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(insertAccessUnitDelimiterInAvc, maxDecodeDelay, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BroadcastTsVideoInputStreamConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    insertAccessUnitDelimiterInAvc: ").append(toIndentedString(insertAccessUnitDelimiterInAvc)).append("\n");
    sb.append("    maxDecodeDelay: ").append(toIndentedString(maxDecodeDelay)).append("\n");
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

