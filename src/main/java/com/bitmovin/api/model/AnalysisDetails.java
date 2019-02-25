package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AudioStreamDetails;
import com.bitmovin.api.model.MetaStreamDetails;
import com.bitmovin.api.model.SubtitleStreamDetails;
import com.bitmovin.api.model.VideoStreamDetails;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AnalysisDetails
 */

public class AnalysisDetails {
  @JsonProperty("videoStreams")
  private List<VideoStreamDetails> videoStreams;

  @JsonProperty("audioStreams")
  private List<AudioStreamDetails> audioStreams;

  @JsonProperty("metaStreams")
  private List<MetaStreamDetails> metaStreams;

  @JsonProperty("subtitleStreams")
  private List<SubtitleStreamDetails> subtitleStreams;


  public AnalysisDetails addVideoStreamsItem(VideoStreamDetails videoStreamsItem) {
    if (this.videoStreams == null) {
      this.videoStreams = new ArrayList<>();
    }
    this.videoStreams.add(videoStreamsItem);
    return this;
  }

  /**
   * Get videoStreams
   * @return videoStreams
  **/
  public List<VideoStreamDetails> getVideoStreams() {
    return videoStreams;
  }

  public void setVideoStreams(List<VideoStreamDetails> videoStreams) {
    this.videoStreams = videoStreams;
  }


  public AnalysisDetails addAudioStreamsItem(AudioStreamDetails audioStreamsItem) {
    if (this.audioStreams == null) {
      this.audioStreams = new ArrayList<>();
    }
    this.audioStreams.add(audioStreamsItem);
    return this;
  }

  /**
   * Get audioStreams
   * @return audioStreams
  **/
  public List<AudioStreamDetails> getAudioStreams() {
    return audioStreams;
  }

  public void setAudioStreams(List<AudioStreamDetails> audioStreams) {
    this.audioStreams = audioStreams;
  }


  public AnalysisDetails addMetaStreamsItem(MetaStreamDetails metaStreamsItem) {
    if (this.metaStreams == null) {
      this.metaStreams = new ArrayList<>();
    }
    this.metaStreams.add(metaStreamsItem);
    return this;
  }

  /**
   * Get metaStreams
   * @return metaStreams
  **/
  public List<MetaStreamDetails> getMetaStreams() {
    return metaStreams;
  }

  public void setMetaStreams(List<MetaStreamDetails> metaStreams) {
    this.metaStreams = metaStreams;
  }


  public AnalysisDetails addSubtitleStreamsItem(SubtitleStreamDetails subtitleStreamsItem) {
    if (this.subtitleStreams == null) {
      this.subtitleStreams = new ArrayList<>();
    }
    this.subtitleStreams.add(subtitleStreamsItem);
    return this;
  }

  /**
   * Get subtitleStreams
   * @return subtitleStreams
  **/
  public List<SubtitleStreamDetails> getSubtitleStreams() {
    return subtitleStreams;
  }

  public void setSubtitleStreams(List<SubtitleStreamDetails> subtitleStreams) {
    this.subtitleStreams = subtitleStreams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalysisDetails analysisDetails = (AnalysisDetails) o;
    return Objects.equals(this.videoStreams, analysisDetails.videoStreams) &&
        Objects.equals(this.audioStreams, analysisDetails.audioStreams) &&
        Objects.equals(this.metaStreams, analysisDetails.metaStreams) &&
        Objects.equals(this.subtitleStreams, analysisDetails.subtitleStreams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(videoStreams, audioStreams, metaStreams, subtitleStreams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalysisDetails {\n");
    
    sb.append("    videoStreams: ").append(toIndentedString(videoStreams)).append("\n");
    sb.append("    audioStreams: ").append(toIndentedString(audioStreams)).append("\n");
    sb.append("    metaStreams: ").append(toIndentedString(metaStreams)).append("\n");
    sb.append("    subtitleStreams: ").append(toIndentedString(subtitleStreams)).append("\n");
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

