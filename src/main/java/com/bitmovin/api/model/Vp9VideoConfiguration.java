package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.ColorConfig;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.PixelFormat;
import com.bitmovin.api.model.VideoConfiguration;
import com.bitmovin.api.model.Vp9AqMode;
import com.bitmovin.api.model.Vp9ArnrType;
import com.bitmovin.api.model.Vp9Quality;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Vp9VideoConfiguration
 */

public class Vp9VideoConfiguration extends VideoConfiguration {
  @JsonProperty("crf")
  private Integer crf;

  @JsonProperty("lagInFrames")
  private Integer lagInFrames;

  @JsonProperty("tileColumns")
  private Integer tileColumns;

  @JsonProperty("tileRows")
  private Integer tileRows;

  @JsonProperty("frameParallel")
  private Boolean frameParallel;

  @JsonProperty("maxIntraRate")
  private Long maxIntraRate;

  @JsonProperty("qpMin")
  private Integer qpMin;

  @JsonProperty("qpMax")
  private Integer qpMax;

  @JsonProperty("rateUndershootPct")
  private Integer rateUndershootPct;

  @JsonProperty("rateOvershootPct")
  private Integer rateOvershootPct;

  @JsonProperty("noiseSensitivity")
  private Boolean noiseSensitivity;

  @JsonProperty("sharpness")
  private Integer sharpness;

  @JsonProperty("minGop")
  private Integer minGop;

  @JsonProperty("maxGop")
  private Integer maxGop;

  @JsonProperty("minKeyframeInterval")
  private Double minKeyframeInterval;

  @JsonProperty("maxKeyframeInterval")
  private Double maxKeyframeInterval;

  @JsonProperty("quality")
  private Vp9Quality quality = null;

  @JsonProperty("lossless")
  private Boolean lossless;

  @JsonProperty("staticThresh")
  private Integer staticThresh;

  @JsonProperty("aqMode")
  private Vp9AqMode aqMode = null;

  @JsonProperty("arnrMaxFrames")
  private Integer arnrMaxFrames;

  @JsonProperty("arnrStrength")
  private Integer arnrStrength;

  @JsonProperty("arnrType")
  private Vp9ArnrType arnrType = null;


  /**
   * Sets the constant rate factor for quality-based variable bitrate. Either bitrate or crf is required.
   * minimum: 0
   * maximum: 63
   * @return crf
  **/
  public Integer getCrf() {
    return crf;
  }

  public void setCrf(Integer crf) {
    this.crf = crf;
  }


  /**
   * Number of frames to look ahead for alternate reference frame selection.
   * minimum: 0
   * maximum: 25
   * @return lagInFrames
  **/
  public Integer getLagInFrames() {
    return lagInFrames;
  }

  public void setLagInFrames(Integer lagInFrames) {
    this.lagInFrames = lagInFrames;
  }


  /**
   * Number of tile columns to use, log2.
   * minimum: 0
   * maximum: 6
   * @return tileColumns
  **/
  public Integer getTileColumns() {
    return tileColumns;
  }

  public void setTileColumns(Integer tileColumns) {
    this.tileColumns = tileColumns;
  }


  /**
   * Number of tile rows to use, log2.
   * minimum: 0
   * maximum: 2
   * @return tileRows
  **/
  public Integer getTileRows() {
    return tileRows;
  }

  public void setTileRows(Integer tileRows) {
    this.tileRows = tileRows;
  }


  /**
   * Enable frame parallel decodability features
   * @return frameParallel
  **/
  public Boolean getFrameParallel() {
    return frameParallel;
  }

  public void setFrameParallel(Boolean frameParallel) {
    this.frameParallel = frameParallel;
  }


  /**
   * Maximum I-frame bitrate (percentage) 0&#x3D;unlimited
   * @return maxIntraRate
  **/
  public Long getMaxIntraRate() {
    return maxIntraRate;
  }

  public void setMaxIntraRate(Long maxIntraRate) {
    this.maxIntraRate = maxIntraRate;
  }


  /**
   * Sets the minimum of quantization factor.
   * minimum: 0
   * maximum: 63
   * @return qpMin
  **/
  public Integer getQpMin() {
    return qpMin;
  }

  public void setQpMin(Integer qpMin) {
    this.qpMin = qpMin;
  }


  /**
   * Sets the maximum of quantization factor.
   * minimum: 0
   * maximum: 63
   * @return qpMax
  **/
  public Integer getQpMax() {
    return qpMax;
  }

  public void setQpMax(Integer qpMax) {
    this.qpMax = qpMax;
  }


  /**
   * Datarate undershoot (min) target (percentage).
   * minimum: 0
   * maximum: 100
   * @return rateUndershootPct
  **/
  public Integer getRateUndershootPct() {
    return rateUndershootPct;
  }

  public void setRateUndershootPct(Integer rateUndershootPct) {
    this.rateUndershootPct = rateUndershootPct;
  }


  /**
   * Datarate overshoot (max) target (percentage).
   * minimum: 0
   * maximum: 100
   * @return rateOvershootPct
  **/
  public Integer getRateOvershootPct() {
    return rateOvershootPct;
  }

  public void setRateOvershootPct(Integer rateOvershootPct) {
    this.rateOvershootPct = rateOvershootPct;
  }


  /**
   * Enable noise sensitivity on Y channel
   * @return noiseSensitivity
  **/
  public Boolean getNoiseSensitivity() {
    return noiseSensitivity;
  }

  public void setNoiseSensitivity(Boolean noiseSensitivity) {
    this.noiseSensitivity = noiseSensitivity;
  }


  /**
   * Loop filter sharpness.
   * minimum: 0
   * maximum: 7
   * @return sharpness
  **/
  public Integer getSharpness() {
    return sharpness;
  }

  public void setSharpness(Integer sharpness) {
    this.sharpness = sharpness;
  }


  /**
   * Minimum GOP length, the minimum distance between I-frames.
   * @return minGop
  **/
  public Integer getMinGop() {
    return minGop;
  }

  public void setMinGop(Integer minGop) {
    this.minGop = minGop;
  }


  /**
   * Maximum GOP length, the maximum distance between I-frames
   * @return maxGop
  **/
  public Integer getMaxGop() {
    return maxGop;
  }

  public void setMaxGop(Integer maxGop) {
    this.maxGop = maxGop;
  }


  /**
   * Minimum interval in seconds between key frames
   * @return minKeyframeInterval
  **/
  public Double getMinKeyframeInterval() {
    return minKeyframeInterval;
  }

  public void setMinKeyframeInterval(Double minKeyframeInterval) {
    this.minKeyframeInterval = minKeyframeInterval;
  }


  /**
   * Maximum interval in seconds between key frames
   * @return maxKeyframeInterval
  **/
  public Double getMaxKeyframeInterval() {
    return maxKeyframeInterval;
  }

  public void setMaxKeyframeInterval(Double maxKeyframeInterval) {
    this.maxKeyframeInterval = maxKeyframeInterval;
  }


  /**
   * Get quality
   * @return quality
  **/
  public Vp9Quality getQuality() {
    return quality;
  }

  public void setQuality(Vp9Quality quality) {
    this.quality = quality;
  }


  /**
   * Lossless mode
   * @return lossless
  **/
  public Boolean getLossless() {
    return lossless;
  }

  public void setLossless(Boolean lossless) {
    this.lossless = lossless;
  }


  /**
   * A change threshold on blocks below which they will be skipped by the encoder.
   * minimum: 0
   * @return staticThresh
  **/
  public Integer getStaticThresh() {
    return staticThresh;
  }

  public void setStaticThresh(Integer staticThresh) {
    this.staticThresh = staticThresh;
  }


  /**
   * Get aqMode
   * @return aqMode
  **/
  public Vp9AqMode getAqMode() {
    return aqMode;
  }

  public void setAqMode(Vp9AqMode aqMode) {
    this.aqMode = aqMode;
  }


  /**
   * altref noise reduction max frame count.
   * minimum: 0
   * maximum: 15
   * @return arnrMaxFrames
  **/
  public Integer getArnrMaxFrames() {
    return arnrMaxFrames;
  }

  public void setArnrMaxFrames(Integer arnrMaxFrames) {
    this.arnrMaxFrames = arnrMaxFrames;
  }


  /**
   * altref noise reduction filter strength.
   * minimum: 0
   * maximum: 6
   * @return arnrStrength
  **/
  public Integer getArnrStrength() {
    return arnrStrength;
  }

  public void setArnrStrength(Integer arnrStrength) {
    this.arnrStrength = arnrStrength;
  }


  /**
   * Get arnrType
   * @return arnrType
  **/
  public Vp9ArnrType getArnrType() {
    return arnrType;
  }

  public void setArnrType(Vp9ArnrType arnrType) {
    this.arnrType = arnrType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vp9VideoConfiguration vp9VideoConfiguration = (Vp9VideoConfiguration) o;
    return Objects.equals(this.crf, vp9VideoConfiguration.crf) &&
        Objects.equals(this.lagInFrames, vp9VideoConfiguration.lagInFrames) &&
        Objects.equals(this.tileColumns, vp9VideoConfiguration.tileColumns) &&
        Objects.equals(this.tileRows, vp9VideoConfiguration.tileRows) &&
        Objects.equals(this.frameParallel, vp9VideoConfiguration.frameParallel) &&
        Objects.equals(this.maxIntraRate, vp9VideoConfiguration.maxIntraRate) &&
        Objects.equals(this.qpMin, vp9VideoConfiguration.qpMin) &&
        Objects.equals(this.qpMax, vp9VideoConfiguration.qpMax) &&
        Objects.equals(this.rateUndershootPct, vp9VideoConfiguration.rateUndershootPct) &&
        Objects.equals(this.rateOvershootPct, vp9VideoConfiguration.rateOvershootPct) &&
        Objects.equals(this.noiseSensitivity, vp9VideoConfiguration.noiseSensitivity) &&
        Objects.equals(this.sharpness, vp9VideoConfiguration.sharpness) &&
        Objects.equals(this.minGop, vp9VideoConfiguration.minGop) &&
        Objects.equals(this.maxGop, vp9VideoConfiguration.maxGop) &&
        Objects.equals(this.minKeyframeInterval, vp9VideoConfiguration.minKeyframeInterval) &&
        Objects.equals(this.maxKeyframeInterval, vp9VideoConfiguration.maxKeyframeInterval) &&
        Objects.equals(this.quality, vp9VideoConfiguration.quality) &&
        Objects.equals(this.lossless, vp9VideoConfiguration.lossless) &&
        Objects.equals(this.staticThresh, vp9VideoConfiguration.staticThresh) &&
        Objects.equals(this.aqMode, vp9VideoConfiguration.aqMode) &&
        Objects.equals(this.arnrMaxFrames, vp9VideoConfiguration.arnrMaxFrames) &&
        Objects.equals(this.arnrStrength, vp9VideoConfiguration.arnrStrength) &&
        Objects.equals(this.arnrType, vp9VideoConfiguration.arnrType) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crf, lagInFrames, tileColumns, tileRows, frameParallel, maxIntraRate, qpMin, qpMax, rateUndershootPct, rateOvershootPct, noiseSensitivity, sharpness, minGop, maxGop, minKeyframeInterval, maxKeyframeInterval, quality, lossless, staticThresh, aqMode, arnrMaxFrames, arnrStrength, arnrType, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vp9VideoConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    crf: ").append(toIndentedString(crf)).append("\n");
    sb.append("    lagInFrames: ").append(toIndentedString(lagInFrames)).append("\n");
    sb.append("    tileColumns: ").append(toIndentedString(tileColumns)).append("\n");
    sb.append("    tileRows: ").append(toIndentedString(tileRows)).append("\n");
    sb.append("    frameParallel: ").append(toIndentedString(frameParallel)).append("\n");
    sb.append("    maxIntraRate: ").append(toIndentedString(maxIntraRate)).append("\n");
    sb.append("    qpMin: ").append(toIndentedString(qpMin)).append("\n");
    sb.append("    qpMax: ").append(toIndentedString(qpMax)).append("\n");
    sb.append("    rateUndershootPct: ").append(toIndentedString(rateUndershootPct)).append("\n");
    sb.append("    rateOvershootPct: ").append(toIndentedString(rateOvershootPct)).append("\n");
    sb.append("    noiseSensitivity: ").append(toIndentedString(noiseSensitivity)).append("\n");
    sb.append("    sharpness: ").append(toIndentedString(sharpness)).append("\n");
    sb.append("    minGop: ").append(toIndentedString(minGop)).append("\n");
    sb.append("    maxGop: ").append(toIndentedString(maxGop)).append("\n");
    sb.append("    minKeyframeInterval: ").append(toIndentedString(minKeyframeInterval)).append("\n");
    sb.append("    maxKeyframeInterval: ").append(toIndentedString(maxKeyframeInterval)).append("\n");
    sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
    sb.append("    lossless: ").append(toIndentedString(lossless)).append("\n");
    sb.append("    staticThresh: ").append(toIndentedString(staticThresh)).append("\n");
    sb.append("    aqMode: ").append(toIndentedString(aqMode)).append("\n");
    sb.append("    arnrMaxFrames: ").append(toIndentedString(arnrMaxFrames)).append("\n");
    sb.append("    arnrStrength: ").append(toIndentedString(arnrStrength)).append("\n");
    sb.append("    arnrType: ").append(toIndentedString(arnrType)).append("\n");
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

