package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AudioStream;
import com.bitmovin.api.model.MediaStream;
import com.bitmovin.api.model.SubtitleStream;
import com.bitmovin.api.model.VideoStream;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * EncodingStreamInputDetails
 */

public class EncodingStreamInputDetails {
  @JsonProperty("formatName")
  private String formatName;

  @JsonProperty("startTime")
  private Double startTime;

  @JsonProperty("duration")
  private Double duration;

  @JsonProperty("size")
  private Long size;

  @JsonProperty("bitrate")
  private Long bitrate;

  @JsonProperty("tags")
  private List<String> tags;

  @JsonProperty("videoStreams")
  private List<VideoStream> videoStreams;

  @JsonProperty("audioStreams")
  private List<AudioStream> audioStreams;

  @JsonProperty("metaStreams")
  private List<MediaStream> metaStreams;

  @JsonProperty("subtitleStreams")
  private List<SubtitleStream> subtitleStreams;

  /**
   * Format name
   * @return formatName
  **/
  public String getFormatName() {
    return formatName;
  }

  /**
   * The start time in seconds
   * @return startTime
  **/
  public Double getStartTime() {
    return startTime;
  }

  /**
   * Duration in seconds
   * @return duration
  **/
  public Double getDuration() {
    return duration;
  }

  /**
   * Input file size in bytes
   * @return size
  **/
  public Long getSize() {
    return size;
  }

  /**
   * Bitrate in bps
   * @return bitrate
  **/
  public Long getBitrate() {
    return bitrate;
  }


  public EncodingStreamInputDetails addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Additional metadata saved in the input file
   * @return tags
  **/
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * Video streams in the input file
   * @return videoStreams
  **/
  public List<VideoStream> getVideoStreams() {
    return videoStreams;
  }

  /**
   * Audio stream in the input file
   * @return audioStreams
  **/
  public List<AudioStream> getAudioStreams() {
    return audioStreams;
  }

  /**
   * Meta data streams in the input file
   * @return metaStreams
  **/
  public List<MediaStream> getMetaStreams() {
    return metaStreams;
  }

  /**
   * Subtitle streams in the input file
   * @return subtitleStreams
  **/
  public List<SubtitleStream> getSubtitleStreams() {
    return subtitleStreams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncodingStreamInputDetails encodingStreamInputDetails = (EncodingStreamInputDetails) o;
    return Objects.equals(this.formatName, encodingStreamInputDetails.formatName) &&
        Objects.equals(this.startTime, encodingStreamInputDetails.startTime) &&
        Objects.equals(this.duration, encodingStreamInputDetails.duration) &&
        Objects.equals(this.size, encodingStreamInputDetails.size) &&
        Objects.equals(this.bitrate, encodingStreamInputDetails.bitrate) &&
        Objects.equals(this.tags, encodingStreamInputDetails.tags) &&
        Objects.equals(this.videoStreams, encodingStreamInputDetails.videoStreams) &&
        Objects.equals(this.audioStreams, encodingStreamInputDetails.audioStreams) &&
        Objects.equals(this.metaStreams, encodingStreamInputDetails.metaStreams) &&
        Objects.equals(this.subtitleStreams, encodingStreamInputDetails.subtitleStreams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formatName, startTime, duration, size, bitrate, tags, videoStreams, audioStreams, metaStreams, subtitleStreams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncodingStreamInputDetails {\n");
    
    sb.append("    formatName: ").append(toIndentedString(formatName)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    bitrate: ").append(toIndentedString(bitrate)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

