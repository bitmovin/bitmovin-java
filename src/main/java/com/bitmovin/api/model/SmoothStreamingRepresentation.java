package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * SmoothStreamingRepresentation
 */

public class SmoothStreamingRepresentation extends BitmovinResource {
  @JsonProperty("encodingId")
  private String encodingId;

  @JsonProperty("muxingId")
  private String muxingId;

  @JsonProperty("mediaFile")
  private String mediaFile;

  @JsonProperty("language")
  private String language;

  @JsonProperty("trackName")
  private String trackName;


  /**
   * Id of the encoding
   * @return encodingId
  **/
  public String getEncodingId() {
    return encodingId;
  }

  public void setEncodingId(String encodingId) {
    this.encodingId = encodingId;
  }


  /**
   * Id of the muxing.
   * @return muxingId
  **/
  public String getMuxingId() {
    return muxingId;
  }

  public void setMuxingId(String muxingId) {
    this.muxingId = muxingId;
  }


  /**
   * The Smooth Streaming ismv or isma file that will be referenced in the manifest.
   * @return mediaFile
  **/
  public String getMediaFile() {
    return mediaFile;
  }

  public void setMediaFile(String mediaFile) {
    this.mediaFile = mediaFile;
  }


  /**
   * Language of the MP4 file
   * @return language
  **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  /**
   * Track where this MP4 shoudl be added
   * @return trackName
  **/
  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SmoothStreamingRepresentation smoothStreamingRepresentation = (SmoothStreamingRepresentation) o;
    return Objects.equals(this.encodingId, smoothStreamingRepresentation.encodingId) &&
        Objects.equals(this.muxingId, smoothStreamingRepresentation.muxingId) &&
        Objects.equals(this.mediaFile, smoothStreamingRepresentation.mediaFile) &&
        Objects.equals(this.language, smoothStreamingRepresentation.language) &&
        Objects.equals(this.trackName, smoothStreamingRepresentation.trackName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodingId, muxingId, mediaFile, language, trackName, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SmoothStreamingRepresentation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    encodingId: ").append(toIndentedString(encodingId)).append("\n");
    sb.append("    muxingId: ").append(toIndentedString(muxingId)).append("\n");
    sb.append("    mediaFile: ").append(toIndentedString(mediaFile)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    trackName: ").append(toIndentedString(trackName)).append("\n");
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

