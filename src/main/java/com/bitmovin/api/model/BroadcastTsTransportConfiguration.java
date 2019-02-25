package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * BroadcastTsTransportConfiguration
 */

public class BroadcastTsTransportConfiguration {
  @JsonProperty("muxrate")
  private Double muxrate;

  @JsonProperty("stopOnError")
  private Boolean stopOnError;

  @JsonProperty("preventEmptyAdaptionFieldsInVideo")
  private Boolean preventEmptyAdaptionFieldsInVideo;

  @JsonProperty("patRepetitionRatePerSec")
  private Double patRepetitionRatePerSec;

  @JsonProperty("pmtRepetitionRatePerSec")
  private Double pmtRepetitionRatePerSec;


  /**
   * Output rate in bps. The value zero implies to use minimal rate. The minimal rate leaves approximately 15kbps of null packets in the stream.
   * minimum: 0
   * maximum: 1000000000
   * @return muxrate
  **/
  public Double getMuxrate() {
    return muxrate;
  }

  public void setMuxrate(Double muxrate) {
    this.muxrate = muxrate;
  }


  /**
   * Stop mux on errors. If true, implies halt multiplexing when any error is encountered. If false, errors are ignored and multiplexing continues. Note that the recovery from an error will usually result in an illegal transport stream and artifacts on a decoder.
   * @return stopOnError
  **/
  public Boolean getStopOnError() {
    return stopOnError;
  }

  public void setStopOnError(Boolean stopOnError) {
    this.stopOnError = stopOnError;
  }


  /**
   * If true, prevents adaptation fields with length field equal to zero in video, i.e., zero-length AF. Please note that this condition can only occur when pesAlign for the input stream is set to true.
   * @return preventEmptyAdaptionFieldsInVideo
  **/
  public Boolean getPreventEmptyAdaptionFieldsInVideo() {
    return preventEmptyAdaptionFieldsInVideo;
  }

  public void setPreventEmptyAdaptionFieldsInVideo(Boolean preventEmptyAdaptionFieldsInVideo) {
    this.preventEmptyAdaptionFieldsInVideo = preventEmptyAdaptionFieldsInVideo;
  }


  /**
   * Program Association Table (PAT) repetition rate per second. Number of PATs per second.
   * minimum: 0.001
   * maximum: 1000
   * @return patRepetitionRatePerSec
  **/
  public Double getPatRepetitionRatePerSec() {
    return patRepetitionRatePerSec;
  }

  public void setPatRepetitionRatePerSec(Double patRepetitionRatePerSec) {
    this.patRepetitionRatePerSec = patRepetitionRatePerSec;
  }


  /**
   * Program Map Table (PMT) repetition rate per second. Number of PMTs for each program per second.
   * minimum: 0.001
   * maximum: 1000
   * @return pmtRepetitionRatePerSec
  **/
  public Double getPmtRepetitionRatePerSec() {
    return pmtRepetitionRatePerSec;
  }

  public void setPmtRepetitionRatePerSec(Double pmtRepetitionRatePerSec) {
    this.pmtRepetitionRatePerSec = pmtRepetitionRatePerSec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BroadcastTsTransportConfiguration broadcastTsTransportConfiguration = (BroadcastTsTransportConfiguration) o;
    return Objects.equals(this.muxrate, broadcastTsTransportConfiguration.muxrate) &&
        Objects.equals(this.stopOnError, broadcastTsTransportConfiguration.stopOnError) &&
        Objects.equals(this.preventEmptyAdaptionFieldsInVideo, broadcastTsTransportConfiguration.preventEmptyAdaptionFieldsInVideo) &&
        Objects.equals(this.patRepetitionRatePerSec, broadcastTsTransportConfiguration.patRepetitionRatePerSec) &&
        Objects.equals(this.pmtRepetitionRatePerSec, broadcastTsTransportConfiguration.pmtRepetitionRatePerSec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(muxrate, stopOnError, preventEmptyAdaptionFieldsInVideo, patRepetitionRatePerSec, pmtRepetitionRatePerSec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BroadcastTsTransportConfiguration {\n");
    
    sb.append("    muxrate: ").append(toIndentedString(muxrate)).append("\n");
    sb.append("    stopOnError: ").append(toIndentedString(stopOnError)).append("\n");
    sb.append("    preventEmptyAdaptionFieldsInVideo: ").append(toIndentedString(preventEmptyAdaptionFieldsInVideo)).append("\n");
    sb.append("    patRepetitionRatePerSec: ").append(toIndentedString(patRepetitionRatePerSec)).append("\n");
    sb.append("    pmtRepetitionRatePerSec: ").append(toIndentedString(pmtRepetitionRatePerSec)).append("\n");
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

