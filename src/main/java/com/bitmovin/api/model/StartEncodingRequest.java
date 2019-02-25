package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.ManifestResource;
import com.bitmovin.api.model.PerTitle;
import com.bitmovin.api.model.Scheduling;
import com.bitmovin.api.model.Trimming;
import com.bitmovin.api.model.Tweaks;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * StartEncodingRequest
 */

public class StartEncodingRequest {
  @JsonProperty("trimming")
  private Trimming trimming = null;

  @JsonProperty("scheduling")
  private Scheduling scheduling = null;

  @JsonProperty("tweaks")
  private Tweaks tweaks = null;

  @JsonProperty("handleVariableInputFps")
  private Boolean handleVariableInputFps;

  @JsonProperty("encodingMode")
  private EncodingMode encodingMode = null;

  @JsonProperty("previewDashManifests")
  private List<ManifestResource> previewDashManifests;

  @JsonProperty("previewHlsManifests")
  private List<ManifestResource> previewHlsManifests;

  @JsonProperty("vodDashManifests")
  private List<ManifestResource> vodDashManifests;

  @JsonProperty("vodHlsManifests")
  private List<ManifestResource> vodHlsManifests;

  @JsonProperty("perTitle")
  private PerTitle perTitle = null;


  /**
   * Allows to encode only part of the input. Defines start (offset) and duration of the desired section.
   * @return trimming
  **/
  public Trimming getTrimming() {
    return trimming;
  }

  public void setTrimming(Trimming trimming) {
    this.trimming = trimming;
  }


  /**
   * Set scheduling parameters of the encoding.
   * @return scheduling
  **/
  public Scheduling getScheduling() {
    return scheduling;
  }

  public void setScheduling(Scheduling scheduling) {
    this.scheduling = scheduling;
  }


  /**
   * Set special tweaks for your encoding job.
   * @return tweaks
  **/
  public Tweaks getTweaks() {
    return tweaks;
  }

  public void setTweaks(Tweaks tweaks) {
    this.tweaks = tweaks;
  }


  /**
   * Enable frame dropping/duplication to handle variable frames per seconds of video input streams
   * @return handleVariableInputFps
  **/
  public Boolean getHandleVariableInputFps() {
    return handleVariableInputFps;
  }

  public void setHandleVariableInputFps(Boolean handleVariableInputFps) {
    this.handleVariableInputFps = handleVariableInputFps;
  }


  /**
   * The pass mode of the encoding
   * @return encodingMode
  **/
  public EncodingMode getEncodingMode() {
    return encodingMode;
  }

  public void setEncodingMode(EncodingMode encodingMode) {
    this.encodingMode = encodingMode;
  }


  public StartEncodingRequest addPreviewDashManifestsItem(ManifestResource previewDashManifestsItem) {
    if (this.previewDashManifests == null) {
      this.previewDashManifests = new ArrayList<>();
    }
    this.previewDashManifests.add(previewDashManifestsItem);
    return this;
  }

  /**
   * List of preview DASH manifests to be created
   * @return previewDashManifests
  **/
  public List<ManifestResource> getPreviewDashManifests() {
    return previewDashManifests;
  }

  public void setPreviewDashManifests(List<ManifestResource> previewDashManifests) {
    this.previewDashManifests = previewDashManifests;
  }


  public StartEncodingRequest addPreviewHlsManifestsItem(ManifestResource previewHlsManifestsItem) {
    if (this.previewHlsManifests == null) {
      this.previewHlsManifests = new ArrayList<>();
    }
    this.previewHlsManifests.add(previewHlsManifestsItem);
    return this;
  }

  /**
   * List of preview HLS manifests to be created
   * @return previewHlsManifests
  **/
  public List<ManifestResource> getPreviewHlsManifests() {
    return previewHlsManifests;
  }

  public void setPreviewHlsManifests(List<ManifestResource> previewHlsManifests) {
    this.previewHlsManifests = previewHlsManifests;
  }


  public StartEncodingRequest addVodDashManifestsItem(ManifestResource vodDashManifestsItem) {
    if (this.vodDashManifests == null) {
      this.vodDashManifests = new ArrayList<>();
    }
    this.vodDashManifests.add(vodDashManifestsItem);
    return this;
  }

  /**
   * List of VoD DASH manifests to be created after encoding finished successfully
   * @return vodDashManifests
  **/
  public List<ManifestResource> getVodDashManifests() {
    return vodDashManifests;
  }

  public void setVodDashManifests(List<ManifestResource> vodDashManifests) {
    this.vodDashManifests = vodDashManifests;
  }


  public StartEncodingRequest addVodHlsManifestsItem(ManifestResource vodHlsManifestsItem) {
    if (this.vodHlsManifests == null) {
      this.vodHlsManifests = new ArrayList<>();
    }
    this.vodHlsManifests.add(vodHlsManifestsItem);
    return this;
  }

  /**
   * List of VoD HLS manifests to be created after encoding finished successfully
   * @return vodHlsManifests
  **/
  public List<ManifestResource> getVodHlsManifests() {
    return vodHlsManifests;
  }

  public void setVodHlsManifests(List<ManifestResource> vodHlsManifests) {
    this.vodHlsManifests = vodHlsManifests;
  }


  /**
   * Per-Title settings
   * @return perTitle
  **/
  public PerTitle getPerTitle() {
    return perTitle;
  }

  public void setPerTitle(PerTitle perTitle) {
    this.perTitle = perTitle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartEncodingRequest startEncodingRequest = (StartEncodingRequest) o;
    return Objects.equals(this.trimming, startEncodingRequest.trimming) &&
        Objects.equals(this.scheduling, startEncodingRequest.scheduling) &&
        Objects.equals(this.tweaks, startEncodingRequest.tweaks) &&
        Objects.equals(this.handleVariableInputFps, startEncodingRequest.handleVariableInputFps) &&
        Objects.equals(this.encodingMode, startEncodingRequest.encodingMode) &&
        Objects.equals(this.previewDashManifests, startEncodingRequest.previewDashManifests) &&
        Objects.equals(this.previewHlsManifests, startEncodingRequest.previewHlsManifests) &&
        Objects.equals(this.vodDashManifests, startEncodingRequest.vodDashManifests) &&
        Objects.equals(this.vodHlsManifests, startEncodingRequest.vodHlsManifests) &&
        Objects.equals(this.perTitle, startEncodingRequest.perTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trimming, scheduling, tweaks, handleVariableInputFps, encodingMode, previewDashManifests, previewHlsManifests, vodDashManifests, vodHlsManifests, perTitle);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartEncodingRequest {\n");
    
    sb.append("    trimming: ").append(toIndentedString(trimming)).append("\n");
    sb.append("    scheduling: ").append(toIndentedString(scheduling)).append("\n");
    sb.append("    tweaks: ").append(toIndentedString(tweaks)).append("\n");
    sb.append("    handleVariableInputFps: ").append(toIndentedString(handleVariableInputFps)).append("\n");
    sb.append("    encodingMode: ").append(toIndentedString(encodingMode)).append("\n");
    sb.append("    previewDashManifests: ").append(toIndentedString(previewDashManifests)).append("\n");
    sb.append("    previewHlsManifests: ").append(toIndentedString(previewHlsManifests)).append("\n");
    sb.append("    vodDashManifests: ").append(toIndentedString(vodDashManifests)).append("\n");
    sb.append("    vodHlsManifests: ").append(toIndentedString(vodHlsManifests)).append("\n");
    sb.append("    perTitle: ").append(toIndentedString(perTitle)).append("\n");
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

