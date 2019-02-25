package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BillableEncodingMinutesDetails
 */

public class BillableEncodingMinutesDetails {
  @JsonProperty("UNKNOWN")
  private Long UNKNOWN;

  @JsonProperty("AUDIO")
  private Long AUDIO;

  @JsonProperty("SD")
  private Long SD;

  @JsonProperty("HD")
  private Long HD;

  @JsonProperty("UHD")
  private Long UHD;


  /**
   * Only set if resolution information is not present.
   * @return UNKNOWN
  **/
  public Long getUNKNOWN() {
    return UNKNOWN;
  }

  public void setUNKNOWN(Long UNKNOWN) {
    this.UNKNOWN = UNKNOWN;
  }


  /**
   * Billable minutes for audio. Available if stream is an audio stream.
   * @return AUDIO
  **/
  public Long getAUDIO() {
    return AUDIO;
  }

  public void setAUDIO(Long AUDIO) {
    this.AUDIO = AUDIO;
  }


  /**
   * Billable minutes for SD resolutions.
   * @return SD
  **/
  public Long getSD() {
    return SD;
  }

  public void setSD(Long SD) {
    this.SD = SD;
  }


  /**
   * Billable minutes for HD resolutions.
   * @return HD
  **/
  public Long getHD() {
    return HD;
  }

  public void setHD(Long HD) {
    this.HD = HD;
  }


  /**
   * Billable minutes for UHD resolutions.
   * @return UHD
  **/
  public Long getUHD() {
    return UHD;
  }

  public void setUHD(Long UHD) {
    this.UHD = UHD;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillableEncodingMinutesDetails billableEncodingMinutesDetails = (BillableEncodingMinutesDetails) o;
    return Objects.equals(this.UNKNOWN, billableEncodingMinutesDetails.UNKNOWN) &&
        Objects.equals(this.AUDIO, billableEncodingMinutesDetails.AUDIO) &&
        Objects.equals(this.SD, billableEncodingMinutesDetails.SD) &&
        Objects.equals(this.HD, billableEncodingMinutesDetails.HD) &&
        Objects.equals(this.UHD, billableEncodingMinutesDetails.UHD);
  }

  @Override
  public int hashCode() {
    return Objects.hash(UNKNOWN, AUDIO, SD, HD, UHD);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillableEncodingMinutesDetails {\n");
    
    sb.append("    UNKNOWN: ").append(toIndentedString(UNKNOWN)).append("\n");
    sb.append("    AUDIO: ").append(toIndentedString(AUDIO)).append("\n");
    sb.append("    SD: ").append(toIndentedString(SD)).append("\n");
    sb.append("    HD: ").append(toIndentedString(HD)).append("\n");
    sb.append("    UHD: ").append(toIndentedString(UHD)).append("\n");
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

