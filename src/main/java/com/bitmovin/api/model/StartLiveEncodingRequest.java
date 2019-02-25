package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AutoRestartConfiguration;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.LiveDashManifest;
import com.bitmovin.api.model.LiveHlsManifest;
import com.bitmovin.api.model.ReuploadSettings;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StartLiveEncodingRequest
 */

public class StartLiveEncodingRequest {
  @JsonProperty("streamKey")
  private String streamKey;

  @JsonProperty("hlsManifests")
  private List<LiveHlsManifest> hlsManifests;

  @JsonProperty("dashManifests")
  private List<LiveDashManifest> dashManifests;

  @JsonProperty("liveEncodingMode")
  private EncodingMode liveEncodingMode = null;

  @JsonProperty("reuploadSettings")
  private ReuploadSettings reuploadSettings = null;

  @JsonProperty("autoRestartConfiguration")
  private AutoRestartConfiguration autoRestartConfiguration = null;


  /**
   * Key for the stream. (a-zA-Z, 3-20 characters)
   * @return streamKey
  **/
  public String getStreamKey() {
    return streamKey;
  }

  public void setStreamKey(String streamKey) {
    this.streamKey = streamKey;
  }


  public StartLiveEncodingRequest addHlsManifestsItem(LiveHlsManifest hlsManifestsItem) {
    if (this.hlsManifests == null) {
      this.hlsManifests = new ArrayList<>();
    }
    this.hlsManifests.add(hlsManifestsItem);
    return this;
  }

  /**
   * List of Hls manifests to use for this live encoding
   * @return hlsManifests
  **/
  public List<LiveHlsManifest> getHlsManifests() {
    return hlsManifests;
  }

  public void setHlsManifests(List<LiveHlsManifest> hlsManifests) {
    this.hlsManifests = hlsManifests;
  }


  public StartLiveEncodingRequest addDashManifestsItem(LiveDashManifest dashManifestsItem) {
    if (this.dashManifests == null) {
      this.dashManifests = new ArrayList<>();
    }
    this.dashManifests.add(dashManifestsItem);
    return this;
  }

  /**
   * List of Dash manifests to use for this live encoding
   * @return dashManifests
  **/
  public List<LiveDashManifest> getDashManifests() {
    return dashManifests;
  }

  public void setDashManifests(List<LiveDashManifest> dashManifests) {
    this.dashManifests = dashManifests;
  }


  /**
   * The pass mode of the encoding
   * @return liveEncodingMode
  **/
  public EncodingMode getLiveEncodingMode() {
    return liveEncodingMode;
  }

  public void setLiveEncodingMode(EncodingMode liveEncodingMode) {
    this.liveEncodingMode = liveEncodingMode;
  }


  /**
   * Reupload specific files during a live encoding. This can be helpful if an automatic life cycle policy is enabled on the output storage
   * @return reuploadSettings
  **/
  public ReuploadSettings getReuploadSettings() {
    return reuploadSettings;
  }

  public void setReuploadSettings(ReuploadSettings reuploadSettings) {
    this.reuploadSettings = reuploadSettings;
  }


  /**
   * Configuration for auto restarting the live encoding
   * @return autoRestartConfiguration
  **/
  public AutoRestartConfiguration getAutoRestartConfiguration() {
    return autoRestartConfiguration;
  }

  public void setAutoRestartConfiguration(AutoRestartConfiguration autoRestartConfiguration) {
    this.autoRestartConfiguration = autoRestartConfiguration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartLiveEncodingRequest startLiveEncodingRequest = (StartLiveEncodingRequest) o;
    return Objects.equals(this.streamKey, startLiveEncodingRequest.streamKey) &&
        Objects.equals(this.hlsManifests, startLiveEncodingRequest.hlsManifests) &&
        Objects.equals(this.dashManifests, startLiveEncodingRequest.dashManifests) &&
        Objects.equals(this.liveEncodingMode, startLiveEncodingRequest.liveEncodingMode) &&
        Objects.equals(this.reuploadSettings, startLiveEncodingRequest.reuploadSettings) &&
        Objects.equals(this.autoRestartConfiguration, startLiveEncodingRequest.autoRestartConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streamKey, hlsManifests, dashManifests, liveEncodingMode, reuploadSettings, autoRestartConfiguration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartLiveEncodingRequest {\n");
    
    sb.append("    streamKey: ").append(toIndentedString(streamKey)).append("\n");
    sb.append("    hlsManifests: ").append(toIndentedString(hlsManifests)).append("\n");
    sb.append("    dashManifests: ").append(toIndentedString(dashManifests)).append("\n");
    sb.append("    liveEncodingMode: ").append(toIndentedString(liveEncodingMode)).append("\n");
    sb.append("    reuploadSettings: ").append(toIndentedString(reuploadSettings)).append("\n");
    sb.append("    autoRestartConfiguration: ").append(toIndentedString(autoRestartConfiguration)).append("\n");
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

