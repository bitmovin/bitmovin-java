package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.MuxingInformationAudioTrack;
import com.bitmovin.api.model.MuxingInformationVideoTrack;
import com.bitmovin.api.model.ProgressiveMuxingInformation;
import com.bitmovin.api.model.ProgressiveTsMuxingInformationByteRanges;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ProgressiveTsMuxingInformation
 */

public class ProgressiveTsMuxingInformation extends ProgressiveMuxingInformation {
  @JsonProperty("byteRanges")
  private List<ProgressiveTsMuxingInformationByteRanges> byteRanges;

  /**
   * Byte ranges for the segments within the TS file
   * @return byteRanges
  **/
  public List<ProgressiveTsMuxingInformationByteRanges> getByteRanges() {
    return byteRanges;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProgressiveTsMuxingInformation progressiveTsMuxingInformation = (ProgressiveTsMuxingInformation) o;
    return Objects.equals(this.byteRanges, progressiveTsMuxingInformation.byteRanges) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(byteRanges, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProgressiveTsMuxingInformation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    byteRanges: ").append(toIndentedString(byteRanges)).append("\n");
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

