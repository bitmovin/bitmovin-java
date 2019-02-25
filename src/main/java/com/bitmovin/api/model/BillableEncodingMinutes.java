package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BillableEncodingMinutesDetails;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.PsnrPerStreamMode;
import com.bitmovin.api.model.StatisticsPerTitleStream;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BillableEncodingMinutes
 */

public class BillableEncodingMinutes {
  @JsonProperty("encodingMode")
  private EncodingMode encodingMode = null;

  @JsonProperty("codec")
  private CodecConfigType codec = null;

  @JsonProperty("perTitleResultStream")
  private StatisticsPerTitleStream perTitleResultStream = null;

  @JsonProperty("psnrMode")
  private PsnrPerStreamMode psnrMode = null;

  @JsonProperty("billableMinutesDetails")
  private List<BillableEncodingMinutesDetails> billableMinutesDetails = new ArrayList<BillableEncodingMinutesDetails>();


  /**
   * Get encodingMode
   * @return encodingMode
  **/
  public EncodingMode getEncodingMode() {
    return encodingMode;
  }

  public void setEncodingMode(EncodingMode encodingMode) {
    this.encodingMode = encodingMode;
  }


  /**
   * Get codec
   * @return codec
  **/
  public CodecConfigType getCodec() {
    return codec;
  }

  public void setCodec(CodecConfigType codec) {
    this.codec = codec;
  }


  /**
   * Get perTitleResultStream
   * @return perTitleResultStream
  **/
  public StatisticsPerTitleStream getPerTitleResultStream() {
    return perTitleResultStream;
  }

  public void setPerTitleResultStream(StatisticsPerTitleStream perTitleResultStream) {
    this.perTitleResultStream = perTitleResultStream;
  }


  /**
   * Get psnrMode
   * @return psnrMode
  **/
  public PsnrPerStreamMode getPsnrMode() {
    return psnrMode;
  }

  public void setPsnrMode(PsnrPerStreamMode psnrMode) {
    this.psnrMode = psnrMode;
  }

  /**
   * Details about billable minutes for each resolution category
   * @return billableMinutesDetails
  **/
  public List<BillableEncodingMinutesDetails> getBillableMinutesDetails() {
    return billableMinutesDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillableEncodingMinutes billableEncodingMinutes = (BillableEncodingMinutes) o;
    return Objects.equals(this.encodingMode, billableEncodingMinutes.encodingMode) &&
        Objects.equals(this.codec, billableEncodingMinutes.codec) &&
        Objects.equals(this.perTitleResultStream, billableEncodingMinutes.perTitleResultStream) &&
        Objects.equals(this.psnrMode, billableEncodingMinutes.psnrMode) &&
        Objects.equals(this.billableMinutesDetails, billableEncodingMinutes.billableMinutesDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodingMode, codec, perTitleResultStream, psnrMode, billableMinutesDetails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillableEncodingMinutes {\n");
    
    sb.append("    encodingMode: ").append(toIndentedString(encodingMode)).append("\n");
    sb.append("    codec: ").append(toIndentedString(codec)).append("\n");
    sb.append("    perTitleResultStream: ").append(toIndentedString(perTitleResultStream)).append("\n");
    sb.append("    psnrMode: ").append(toIndentedString(psnrMode)).append("\n");
    sb.append("    billableMinutesDetails: ").append(toIndentedString(billableMinutesDetails)).append("\n");
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

