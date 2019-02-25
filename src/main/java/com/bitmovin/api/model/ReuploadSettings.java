package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * ReuploadSettings
 */

public class ReuploadSettings {
  @JsonProperty("dashManifestInterval")
  private Double dashManifestInterval;

  @JsonProperty("hlsManifestInterval")
  private Double hlsManifestInterval;

  @JsonProperty("muxingInitFileInterval")
  private Double muxingInitFileInterval;


  /**
   * Interval in seconds to reupload the DASH manifest (minimum value: 30)
   * minimum: 30
   * @return dashManifestInterval
  **/
  public Double getDashManifestInterval() {
    return dashManifestInterval;
  }

  public void setDashManifestInterval(Double dashManifestInterval) {
    this.dashManifestInterval = dashManifestInterval;
  }


  /**
   * Interval in seconds to reupload the HLS master file. This is currently not used, as the master file will always be uploaded when one of the playlist files has changed (minimum value: 30)
   * minimum: 30
   * @return hlsManifestInterval
  **/
  public Double getHlsManifestInterval() {
    return hlsManifestInterval;
  }

  public void setHlsManifestInterval(Double hlsManifestInterval) {
    this.hlsManifestInterval = hlsManifestInterval;
  }


  /**
   * The interval in seconds to reupload the init file for segmented muxings (e.g. fMP4, WebM) (minimum value: 30)
   * minimum: 30
   * @return muxingInitFileInterval
  **/
  public Double getMuxingInitFileInterval() {
    return muxingInitFileInterval;
  }

  public void setMuxingInitFileInterval(Double muxingInitFileInterval) {
    this.muxingInitFileInterval = muxingInitFileInterval;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReuploadSettings reuploadSettings = (ReuploadSettings) o;
    return Objects.equals(this.dashManifestInterval, reuploadSettings.dashManifestInterval) &&
        Objects.equals(this.hlsManifestInterval, reuploadSettings.hlsManifestInterval) &&
        Objects.equals(this.muxingInitFileInterval, reuploadSettings.muxingInitFileInterval);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dashManifestInterval, hlsManifestInterval, muxingInitFileInterval);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReuploadSettings {\n");
    
    sb.append("    dashManifestInterval: ").append(toIndentedString(dashManifestInterval)).append("\n");
    sb.append("    hlsManifestInterval: ").append(toIndentedString(hlsManifestInterval)).append("\n");
    sb.append("    muxingInitFileInterval: ").append(toIndentedString(muxingInitFileInterval)).append("\n");
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

