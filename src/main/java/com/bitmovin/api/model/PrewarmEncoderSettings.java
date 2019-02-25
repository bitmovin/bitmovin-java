package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.BitmovinResource;
import com.bitmovin.api.model.LogLevel;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * PrewarmEncoderSettings
 */

public class PrewarmEncoderSettings extends BitmovinResource {
  @JsonProperty("encoderVersion")
  private String encoderVersion;

  @JsonProperty("minPrewarmed")
  private Integer minPrewarmed;

  @JsonProperty("maxPrewarmed")
  private Integer maxPrewarmed;

  @JsonProperty("logLevel")
  private LogLevel logLevel = null;


  /**
   * Encoder Version to be prewarmed. Only one encoder of this version can be prewarmed per cluster.
   * @return encoderVersion
  **/
  public String getEncoderVersion() {
    return encoderVersion;
  }

  public void setEncoderVersion(String encoderVersion) {
    this.encoderVersion = encoderVersion;
  }


  /**
   * The minimum number of prewarmed encoders of this Version
   * @return minPrewarmed
  **/
  public Integer getMinPrewarmed() {
    return minPrewarmed;
  }

  public void setMinPrewarmed(Integer minPrewarmed) {
    this.minPrewarmed = minPrewarmed;
  }


  /**
   * The maximum number of concurrent prewarmed encoders of this Version
   * @return maxPrewarmed
  **/
  public Integer getMaxPrewarmed() {
    return maxPrewarmed;
  }

  public void setMaxPrewarmed(Integer maxPrewarmed) {
    this.maxPrewarmed = maxPrewarmed;
  }


  /**
   * Get logLevel
   * @return logLevel
  **/
  public LogLevel getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(LogLevel logLevel) {
    this.logLevel = logLevel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrewarmEncoderSettings prewarmEncoderSettings = (PrewarmEncoderSettings) o;
    return Objects.equals(this.encoderVersion, prewarmEncoderSettings.encoderVersion) &&
        Objects.equals(this.minPrewarmed, prewarmEncoderSettings.minPrewarmed) &&
        Objects.equals(this.maxPrewarmed, prewarmEncoderSettings.maxPrewarmed) &&
        Objects.equals(this.logLevel, prewarmEncoderSettings.logLevel) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encoderVersion, minPrewarmed, maxPrewarmed, logLevel, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrewarmEncoderSettings {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    encoderVersion: ").append(toIndentedString(encoderVersion)).append("\n");
    sb.append("    minPrewarmed: ").append(toIndentedString(minPrewarmed)).append("\n");
    sb.append("    maxPrewarmed: ").append(toIndentedString(maxPrewarmed)).append("\n");
    sb.append("    logLevel: ").append(toIndentedString(logLevel)).append("\n");
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

