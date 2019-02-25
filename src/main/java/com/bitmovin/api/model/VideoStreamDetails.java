package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.StreamDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * VideoStreamDetails
 */

public class VideoStreamDetails extends StreamDetails {
  @JsonProperty("fps")
  private String fps;

  @JsonProperty("width")
  private Integer width;

  @JsonProperty("height")
  private Integer height;

  @JsonProperty("bitrate")
  private Integer bitrate;


  /**
   * Get fps
   * @return fps
  **/
  public String getFps() {
    return fps;
  }

  public void setFps(String fps) {
    this.fps = fps;
  }


  /**
   * Get width
   * @return width
  **/
  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }


  /**
   * Get height
   * @return height
  **/
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }


  /**
   * Get bitrate
   * @return bitrate
  **/
  public Integer getBitrate() {
    return bitrate;
  }

  public void setBitrate(Integer bitrate) {
    this.bitrate = bitrate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoStreamDetails videoStreamDetails = (VideoStreamDetails) o;
    return Objects.equals(this.fps, videoStreamDetails.fps) &&
        Objects.equals(this.width, videoStreamDetails.width) &&
        Objects.equals(this.height, videoStreamDetails.height) &&
        Objects.equals(this.bitrate, videoStreamDetails.bitrate) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fps, width, height, bitrate, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VideoStreamDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    fps: ").append(toIndentedString(fps)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    bitrate: ").append(toIndentedString(bitrate)).append("\n");
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

