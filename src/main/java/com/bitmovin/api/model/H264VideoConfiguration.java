package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AdaptiveQuantMode;
import com.bitmovin.api.model.BAdapt;
import com.bitmovin.api.model.Cea608708SubtitleConfiguration;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.ColorConfig;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.H264BPyramid;
import com.bitmovin.api.model.H264InterlaceMode;
import com.bitmovin.api.model.H264MotionEstimationMethod;
import com.bitmovin.api.model.H264NalHrd;
import com.bitmovin.api.model.H264Partition;
import com.bitmovin.api.model.H264SubMe;
import com.bitmovin.api.model.H264Trellis;
import com.bitmovin.api.model.LevelH264;
import com.bitmovin.api.model.MvPredictionMode;
import com.bitmovin.api.model.PixelFormat;
import com.bitmovin.api.model.ProfileH264;
import com.bitmovin.api.model.VideoConfiguration;
import com.bitmovin.api.model.WeightedPredictionPFrames;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * H264VideoConfiguration
 */

public class H264VideoConfiguration extends VideoConfiguration {
  @JsonProperty("crf")
  private Double crf;

  @JsonProperty("profile")
  private ProfileH264 profile = null;

  @JsonProperty("bframes")
  private Integer bframes;

  @JsonProperty("refFrames")
  private Integer refFrames;

  @JsonProperty("qpMin")
  private Integer qpMin;

  @JsonProperty("qpMax")
  private Integer qpMax;

  @JsonProperty("mvPredictionMode")
  private MvPredictionMode mvPredictionMode = null;

  @JsonProperty("mvSearchRangeMax")
  private Integer mvSearchRangeMax;

  @JsonProperty("cabac")
  private Boolean cabac;

  @JsonProperty("maxBitrate")
  private Long maxBitrate;

  @JsonProperty("minBitrate")
  private Long minBitrate;

  @JsonProperty("bufsize")
  private Long bufsize;

  @JsonProperty("minGop")
  private Integer minGop;

  @JsonProperty("maxGop")
  private Integer maxGop;

  @JsonProperty("openGop")
  private Boolean openGop;

  @JsonProperty("minKeyframeInterval")
  private Double minKeyframeInterval;

  @JsonProperty("maxKeyframeInterval")
  private Double maxKeyframeInterval;

  @JsonProperty("level")
  private LevelH264 level = null;

  @JsonProperty("bAdaptiveStrategy")
  private BAdapt bAdaptiveStrategy = null;

  @JsonProperty("motionEstimationMethod")
  private H264MotionEstimationMethod motionEstimationMethod = null;

  @JsonProperty("rcLookahead")
  private Integer rcLookahead;

  @JsonProperty("subMe")
  private H264SubMe subMe = null;

  @JsonProperty("trellis")
  private H264Trellis trellis = null;

  @JsonProperty("partitions")
  private List<H264Partition> partitions;

  @JsonProperty("slices")
  private Integer slices;

  @JsonProperty("interlaceMode")
  private H264InterlaceMode interlaceMode = null;

  @JsonProperty("sceneCutThreshold")
  private Integer sceneCutThreshold;

  @JsonProperty("nalHrd")
  private H264NalHrd nalHrd = null;

  @JsonProperty("bPyramid")
  private H264BPyramid bPyramid = null;

  @JsonProperty("Cea608708SubtitleConfiguration")
  private Cea608708SubtitleConfiguration cea608708SubtitleConfiguration = null;

  @JsonProperty("deblockAlpha")
  private Integer deblockAlpha;

  @JsonProperty("deblockBeta")
  private Integer deblockBeta;

  @JsonProperty("adaptiveQuantizationMode")
  private AdaptiveQuantMode adaptiveQuantizationMode = null;

  @JsonProperty("adaptiveQuantizationStrength")
  private BigDecimal adaptiveQuantizationStrength;

  @JsonProperty("mixedReferences")
  private Boolean mixedReferences;

  @JsonProperty("adaptiveSpatialTransform")
  private Boolean adaptiveSpatialTransform;

  @JsonProperty("fastSkipDetectionPFrames")
  private Boolean fastSkipDetectionPFrames;

  @JsonProperty("weightedPredictionBFrames")
  private Boolean weightedPredictionBFrames;

  @JsonProperty("weightedPredictionPFrames")
  private WeightedPredictionPFrames weightedPredictionPFrames = null;

  @JsonProperty("macroblockTreeRatecontrol")
  private Boolean macroblockTreeRatecontrol;

  @JsonProperty("quantizerCurveCompression")
  private BigDecimal quantizerCurveCompression;

  @JsonProperty("psyRateDistortionOptimization")
  private BigDecimal psyRateDistortionOptimization;

  @JsonProperty("psyTrellis")
  private BigDecimal psyTrellis;


  /**
   * Sets the constant rate factor for quality-based variable bitrate. Either bitrate or crf is required.
   * minimum: 0
   * maximum: 51
   * @return crf
  **/
  public Double getCrf() {
    return crf;
  }

  public void setCrf(Double crf) {
    this.crf = crf;
  }


  /**
   * Get profile
   * @return profile
  **/
  public ProfileH264 getProfile() {
    return profile;
  }

  public void setProfile(ProfileH264 profile) {
    this.profile = profile;
  }


  /**
   * Sets the amount of b frames.
   * minimum: 0
   * maximum: 16
   * @return bframes
  **/
  public Integer getBframes() {
    return bframes;
  }

  public void setBframes(Integer bframes) {
    this.bframes = bframes;
  }


  /**
   * Sets the amount of reference frames.
   * minimum: 1
   * maximum: 16
   * @return refFrames
  **/
  public Integer getRefFrames() {
    return refFrames;
  }

  public void setRefFrames(Integer refFrames) {
    this.refFrames = refFrames;
  }


  /**
   * Sets the minimum of quantization factor.
   * minimum: 0
   * maximum: 69
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
   * maximum: 69
   * @return qpMax
  **/
  public Integer getQpMax() {
    return qpMax;
  }

  public void setQpMax(Integer qpMax) {
    this.qpMax = qpMax;
  }


  /**
   * Get mvPredictionMode
   * @return mvPredictionMode
  **/
  public MvPredictionMode getMvPredictionMode() {
    return mvPredictionMode;
  }

  public void setMvPredictionMode(MvPredictionMode mvPredictionMode) {
    this.mvPredictionMode = mvPredictionMode;
  }


  /**
   * Sets the maximum Motion-Vector-Search-Range
   * minimum: 16
   * maximum: 24
   * @return mvSearchRangeMax
  **/
  public Integer getMvSearchRangeMax() {
    return mvSearchRangeMax;
  }

  public void setMvSearchRangeMax(Integer mvSearchRangeMax) {
    this.mvSearchRangeMax = mvSearchRangeMax;
  }


  /**
   * Enable or disable CABAC
   * @return cabac
  **/
  public Boolean getCabac() {
    return cabac;
  }

  public void setCabac(Boolean cabac) {
    this.cabac = cabac;
  }


  /**
   * Maximum Bitrate
   * @return maxBitrate
  **/
  public Long getMaxBitrate() {
    return maxBitrate;
  }

  public void setMaxBitrate(Long maxBitrate) {
    this.maxBitrate = maxBitrate;
  }


  /**
   * Minimum Bitrate
   * @return minBitrate
  **/
  public Long getMinBitrate() {
    return minBitrate;
  }

  public void setMinBitrate(Long minBitrate) {
    this.minBitrate = minBitrate;
  }


  /**
   * Playback device buffer size
   * @return bufsize
  **/
  public Long getBufsize() {
    return bufsize;
  }

  public void setBufsize(Long bufsize) {
    this.bufsize = bufsize;
  }


  /**
   * Minimum GOP length, the minimum distance between I-frames
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
   * Enable open-gop, allows referencing frames from a previous gop
   * @return openGop
  **/
  public Boolean getOpenGop() {
    return openGop;
  }

  public void setOpenGop(Boolean openGop) {
    this.openGop = openGop;
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
   * Get level
   * @return level
  **/
  public LevelH264 getLevel() {
    return level;
  }

  public void setLevel(LevelH264 level) {
    this.level = level;
  }


  /**
   * Get bAdaptiveStrategy
   * @return bAdaptiveStrategy
  **/
  public BAdapt getBAdaptiveStrategy() {
    return bAdaptiveStrategy;
  }

  public void setBAdaptiveStrategy(BAdapt bAdaptiveStrategy) {
    this.bAdaptiveStrategy = bAdaptiveStrategy;
  }


  /**
   * Get motionEstimationMethod
   * @return motionEstimationMethod
  **/
  public H264MotionEstimationMethod getMotionEstimationMethod() {
    return motionEstimationMethod;
  }

  public void setMotionEstimationMethod(H264MotionEstimationMethod motionEstimationMethod) {
    this.motionEstimationMethod = motionEstimationMethod;
  }


  /**
   * Number of frames for frame-type decision lookahead
   * minimum: 0
   * maximum: 250
   * @return rcLookahead
  **/
  public Integer getRcLookahead() {
    return rcLookahead;
  }

  public void setRcLookahead(Integer rcLookahead) {
    this.rcLookahead = rcLookahead;
  }


  /**
   * Subpixel motion estimation and mode decision
   * @return subMe
  **/
  public H264SubMe getSubMe() {
    return subMe;
  }

  public void setSubMe(H264SubMe subMe) {
    this.subMe = subMe;
  }


  /**
   * Enables or disables Trellis quantization. NOTE: This requires cabac
   * @return trellis
  **/
  public H264Trellis getTrellis() {
    return trellis;
  }

  public void setTrellis(H264Trellis trellis) {
    this.trellis = trellis;
  }


  public H264VideoConfiguration addPartitionsItem(H264Partition partitionsItem) {
    if (this.partitions == null) {
      this.partitions = new ArrayList<>();
    }
    this.partitions.add(partitionsItem);
    return this;
  }

  /**
   * Partitions to consider. Analyzing more partition options improves quality at the cost of speed.
   * @return partitions
  **/
  public List<H264Partition> getPartitions() {
    return partitions;
  }

  public void setPartitions(List<H264Partition> partitions) {
    this.partitions = partitions;
  }


  /**
   * Number of slices per frame.
   * minimum: 1
   * maximum: 45
   * @return slices
  **/
  public Integer getSlices() {
    return slices;
  }

  public void setSlices(Integer slices) {
    this.slices = slices;
  }


  /**
   * Using TOP_FIELD_FIRST or BOTTOM_FIELD_FIRST will output interlaced video
   * @return interlaceMode
  **/
  public H264InterlaceMode getInterlaceMode() {
    return interlaceMode;
  }

  public void setInterlaceMode(H264InterlaceMode interlaceMode) {
    this.interlaceMode = interlaceMode;
  }


  /**
   * Scene Change sensitivity. The higher the value, the more likely an I-Frame will be inserted. Set to 0 to disable it.
   * minimum: 0
   * maximum: 100
   * @return sceneCutThreshold
  **/
  public Integer getSceneCutThreshold() {
    return sceneCutThreshold;
  }

  public void setSceneCutThreshold(Integer sceneCutThreshold) {
    this.sceneCutThreshold = sceneCutThreshold;
  }


  /**
   * Signal hypothetical reference decoder (HRD) information (requires bufsize to be set)
   * @return nalHrd
  **/
  public H264NalHrd getNalHrd() {
    return nalHrd;
  }

  public void setNalHrd(H264NalHrd nalHrd) {
    this.nalHrd = nalHrd;
  }


  /**
   * Keep some B-frames as references
   * @return bPyramid
  **/
  public H264BPyramid getBPyramid() {
    return bPyramid;
  }

  public void setBPyramid(H264BPyramid bPyramid) {
    this.bPyramid = bPyramid;
  }


  /**
   * Defines whether CEA 608/708 subtitles are copied from the input video stream
   * @return cea608708SubtitleConfiguration
  **/
  public Cea608708SubtitleConfiguration getCea608708SubtitleConfiguration() {
    return cea608708SubtitleConfiguration;
  }

  public void setCea608708SubtitleConfiguration(Cea608708SubtitleConfiguration cea608708SubtitleConfiguration) {
    this.cea608708SubtitleConfiguration = cea608708SubtitleConfiguration;
  }


  /**
   * Strength of the in-loop deblocking filter. Higher values deblock more effectively but also soften the image
   * @return deblockAlpha
  **/
  public Integer getDeblockAlpha() {
    return deblockAlpha;
  }

  public void setDeblockAlpha(Integer deblockAlpha) {
    this.deblockAlpha = deblockAlpha;
  }


  /**
   * Threshold of the in-loop deblocking filter. Higher values apply deblocking stronger on non flat blocks, lower values on flat blocks
   * @return deblockBeta
  **/
  public Integer getDeblockBeta() {
    return deblockBeta;
  }

  public void setDeblockBeta(Integer deblockBeta) {
    this.deblockBeta = deblockBeta;
  }


  /**
   * Controls the adaptive quantization algorithm
   * @return adaptiveQuantizationMode
  **/
  public AdaptiveQuantMode getAdaptiveQuantizationMode() {
    return adaptiveQuantizationMode;
  }

  public void setAdaptiveQuantizationMode(AdaptiveQuantMode adaptiveQuantizationMode) {
    this.adaptiveQuantizationMode = adaptiveQuantizationMode;
  }


  /**
   * Values greater than 1 reduce blocking and blurring in flat and textured areas. Values less than 1 reduces ringing artifacts at the cost of more banding artifacts. Negative values are not allowed
   * @return adaptiveQuantizationStrength
  **/
  public BigDecimal getAdaptiveQuantizationStrength() {
    return adaptiveQuantizationStrength;
  }

  public void setAdaptiveQuantizationStrength(BigDecimal adaptiveQuantizationStrength) {
    this.adaptiveQuantizationStrength = adaptiveQuantizationStrength;
  }


  /**
   * Allow references on a per partition basis, rather than per-macroblock basis
   * @return mixedReferences
  **/
  public Boolean getMixedReferences() {
    return mixedReferences;
  }

  public void setMixedReferences(Boolean mixedReferences) {
    this.mixedReferences = mixedReferences;
  }


  /**
   * Enables adaptive spatial transform (high profile 8x8 transform)
   * @return adaptiveSpatialTransform
  **/
  public Boolean getAdaptiveSpatialTransform() {
    return adaptiveSpatialTransform;
  }

  public void setAdaptiveSpatialTransform(Boolean adaptiveSpatialTransform) {
    this.adaptiveSpatialTransform = adaptiveSpatialTransform;
  }


  /**
   * Enables fast skip detection on P-frames. Disabling this very slightly increases quality but at a large speed loss
   * @return fastSkipDetectionPFrames
  **/
  public Boolean getFastSkipDetectionPFrames() {
    return fastSkipDetectionPFrames;
  }

  public void setFastSkipDetectionPFrames(Boolean fastSkipDetectionPFrames) {
    this.fastSkipDetectionPFrames = fastSkipDetectionPFrames;
  }


  /**
   * Enable open-gop, allows referencing frames from a previous gop
   * @return weightedPredictionBFrames
  **/
  public Boolean getWeightedPredictionBFrames() {
    return weightedPredictionBFrames;
  }

  public void setWeightedPredictionBFrames(Boolean weightedPredictionBFrames) {
    this.weightedPredictionBFrames = weightedPredictionBFrames;
  }


  /**
   * Defines the mode for weighted prediction for P-frames
   * @return weightedPredictionPFrames
  **/
  public WeightedPredictionPFrames getWeightedPredictionPFrames() {
    return weightedPredictionPFrames;
  }

  public void setWeightedPredictionPFrames(WeightedPredictionPFrames weightedPredictionPFrames) {
    this.weightedPredictionPFrames = weightedPredictionPFrames;
  }


  /**
   * Enable macroblock tree ratecontrol. Macroblock tree rate control tracks how often blocks of the frame are used for prediciting future frames
   * @return macroblockTreeRatecontrol
  **/
  public Boolean getMacroblockTreeRatecontrol() {
    return macroblockTreeRatecontrol;
  }

  public void setMacroblockTreeRatecontrol(Boolean macroblockTreeRatecontrol) {
    this.macroblockTreeRatecontrol = macroblockTreeRatecontrol;
  }


  /**
   * Ratio between constant bitrate (0.0) and constant quantizer (1.0). Valid range 0.0 - 1.0
   * @return quantizerCurveCompression
  **/
  public BigDecimal getQuantizerCurveCompression() {
    return quantizerCurveCompression;
  }

  public void setQuantizerCurveCompression(BigDecimal quantizerCurveCompression) {
    this.quantizerCurveCompression = quantizerCurveCompression;
  }


  /**
   * Psychovisual Rate Distortion retains fine details like film grain at the expense of more blocking artifacts. Higher values make the video appear sharper and more detailed but with a higher risk of blocking artifacts. Needs to have subMe with RD_IP, RD_ALL, RD_REF_IP, RD_REF_ALL, QPRD or FULL_RD
   * @return psyRateDistortionOptimization
  **/
  public BigDecimal getPsyRateDistortionOptimization() {
    return psyRateDistortionOptimization;
  }

  public void setPsyRateDistortionOptimization(BigDecimal psyRateDistortionOptimization) {
    this.psyRateDistortionOptimization = psyRateDistortionOptimization;
  }


  /**
   * Higher values will improve sharpness and detail retention but might come at costs of artifacts. Needs to have trellis enabled
   * @return psyTrellis
  **/
  public BigDecimal getPsyTrellis() {
    return psyTrellis;
  }

  public void setPsyTrellis(BigDecimal psyTrellis) {
    this.psyTrellis = psyTrellis;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    H264VideoConfiguration h264VideoConfiguration = (H264VideoConfiguration) o;
    return Objects.equals(this.crf, h264VideoConfiguration.crf) &&
        Objects.equals(this.profile, h264VideoConfiguration.profile) &&
        Objects.equals(this.bframes, h264VideoConfiguration.bframes) &&
        Objects.equals(this.refFrames, h264VideoConfiguration.refFrames) &&
        Objects.equals(this.qpMin, h264VideoConfiguration.qpMin) &&
        Objects.equals(this.qpMax, h264VideoConfiguration.qpMax) &&
        Objects.equals(this.mvPredictionMode, h264VideoConfiguration.mvPredictionMode) &&
        Objects.equals(this.mvSearchRangeMax, h264VideoConfiguration.mvSearchRangeMax) &&
        Objects.equals(this.cabac, h264VideoConfiguration.cabac) &&
        Objects.equals(this.maxBitrate, h264VideoConfiguration.maxBitrate) &&
        Objects.equals(this.minBitrate, h264VideoConfiguration.minBitrate) &&
        Objects.equals(this.bufsize, h264VideoConfiguration.bufsize) &&
        Objects.equals(this.minGop, h264VideoConfiguration.minGop) &&
        Objects.equals(this.maxGop, h264VideoConfiguration.maxGop) &&
        Objects.equals(this.openGop, h264VideoConfiguration.openGop) &&
        Objects.equals(this.minKeyframeInterval, h264VideoConfiguration.minKeyframeInterval) &&
        Objects.equals(this.maxKeyframeInterval, h264VideoConfiguration.maxKeyframeInterval) &&
        Objects.equals(this.level, h264VideoConfiguration.level) &&
        Objects.equals(this.bAdaptiveStrategy, h264VideoConfiguration.bAdaptiveStrategy) &&
        Objects.equals(this.motionEstimationMethod, h264VideoConfiguration.motionEstimationMethod) &&
        Objects.equals(this.rcLookahead, h264VideoConfiguration.rcLookahead) &&
        Objects.equals(this.subMe, h264VideoConfiguration.subMe) &&
        Objects.equals(this.trellis, h264VideoConfiguration.trellis) &&
        Objects.equals(this.partitions, h264VideoConfiguration.partitions) &&
        Objects.equals(this.slices, h264VideoConfiguration.slices) &&
        Objects.equals(this.interlaceMode, h264VideoConfiguration.interlaceMode) &&
        Objects.equals(this.sceneCutThreshold, h264VideoConfiguration.sceneCutThreshold) &&
        Objects.equals(this.nalHrd, h264VideoConfiguration.nalHrd) &&
        Objects.equals(this.bPyramid, h264VideoConfiguration.bPyramid) &&
        Objects.equals(this.cea608708SubtitleConfiguration, h264VideoConfiguration.cea608708SubtitleConfiguration) &&
        Objects.equals(this.deblockAlpha, h264VideoConfiguration.deblockAlpha) &&
        Objects.equals(this.deblockBeta, h264VideoConfiguration.deblockBeta) &&
        Objects.equals(this.adaptiveQuantizationMode, h264VideoConfiguration.adaptiveQuantizationMode) &&
        Objects.equals(this.adaptiveQuantizationStrength, h264VideoConfiguration.adaptiveQuantizationStrength) &&
        Objects.equals(this.mixedReferences, h264VideoConfiguration.mixedReferences) &&
        Objects.equals(this.adaptiveSpatialTransform, h264VideoConfiguration.adaptiveSpatialTransform) &&
        Objects.equals(this.fastSkipDetectionPFrames, h264VideoConfiguration.fastSkipDetectionPFrames) &&
        Objects.equals(this.weightedPredictionBFrames, h264VideoConfiguration.weightedPredictionBFrames) &&
        Objects.equals(this.weightedPredictionPFrames, h264VideoConfiguration.weightedPredictionPFrames) &&
        Objects.equals(this.macroblockTreeRatecontrol, h264VideoConfiguration.macroblockTreeRatecontrol) &&
        Objects.equals(this.quantizerCurveCompression, h264VideoConfiguration.quantizerCurveCompression) &&
        Objects.equals(this.psyRateDistortionOptimization, h264VideoConfiguration.psyRateDistortionOptimization) &&
        Objects.equals(this.psyTrellis, h264VideoConfiguration.psyTrellis) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crf, profile, bframes, refFrames, qpMin, qpMax, mvPredictionMode, mvSearchRangeMax, cabac, maxBitrate, minBitrate, bufsize, minGop, maxGop, openGop, minKeyframeInterval, maxKeyframeInterval, level, bAdaptiveStrategy, motionEstimationMethod, rcLookahead, subMe, trellis, partitions, slices, interlaceMode, sceneCutThreshold, nalHrd, bPyramid, cea608708SubtitleConfiguration, deblockAlpha, deblockBeta, adaptiveQuantizationMode, adaptiveQuantizationStrength, mixedReferences, adaptiveSpatialTransform, fastSkipDetectionPFrames, weightedPredictionBFrames, weightedPredictionPFrames, macroblockTreeRatecontrol, quantizerCurveCompression, psyRateDistortionOptimization, psyTrellis, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class H264VideoConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    crf: ").append(toIndentedString(crf)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    bframes: ").append(toIndentedString(bframes)).append("\n");
    sb.append("    refFrames: ").append(toIndentedString(refFrames)).append("\n");
    sb.append("    qpMin: ").append(toIndentedString(qpMin)).append("\n");
    sb.append("    qpMax: ").append(toIndentedString(qpMax)).append("\n");
    sb.append("    mvPredictionMode: ").append(toIndentedString(mvPredictionMode)).append("\n");
    sb.append("    mvSearchRangeMax: ").append(toIndentedString(mvSearchRangeMax)).append("\n");
    sb.append("    cabac: ").append(toIndentedString(cabac)).append("\n");
    sb.append("    maxBitrate: ").append(toIndentedString(maxBitrate)).append("\n");
    sb.append("    minBitrate: ").append(toIndentedString(minBitrate)).append("\n");
    sb.append("    bufsize: ").append(toIndentedString(bufsize)).append("\n");
    sb.append("    minGop: ").append(toIndentedString(minGop)).append("\n");
    sb.append("    maxGop: ").append(toIndentedString(maxGop)).append("\n");
    sb.append("    openGop: ").append(toIndentedString(openGop)).append("\n");
    sb.append("    minKeyframeInterval: ").append(toIndentedString(minKeyframeInterval)).append("\n");
    sb.append("    maxKeyframeInterval: ").append(toIndentedString(maxKeyframeInterval)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    bAdaptiveStrategy: ").append(toIndentedString(bAdaptiveStrategy)).append("\n");
    sb.append("    motionEstimationMethod: ").append(toIndentedString(motionEstimationMethod)).append("\n");
    sb.append("    rcLookahead: ").append(toIndentedString(rcLookahead)).append("\n");
    sb.append("    subMe: ").append(toIndentedString(subMe)).append("\n");
    sb.append("    trellis: ").append(toIndentedString(trellis)).append("\n");
    sb.append("    partitions: ").append(toIndentedString(partitions)).append("\n");
    sb.append("    slices: ").append(toIndentedString(slices)).append("\n");
    sb.append("    interlaceMode: ").append(toIndentedString(interlaceMode)).append("\n");
    sb.append("    sceneCutThreshold: ").append(toIndentedString(sceneCutThreshold)).append("\n");
    sb.append("    nalHrd: ").append(toIndentedString(nalHrd)).append("\n");
    sb.append("    bPyramid: ").append(toIndentedString(bPyramid)).append("\n");
    sb.append("    cea608708SubtitleConfiguration: ").append(toIndentedString(cea608708SubtitleConfiguration)).append("\n");
    sb.append("    deblockAlpha: ").append(toIndentedString(deblockAlpha)).append("\n");
    sb.append("    deblockBeta: ").append(toIndentedString(deblockBeta)).append("\n");
    sb.append("    adaptiveQuantizationMode: ").append(toIndentedString(adaptiveQuantizationMode)).append("\n");
    sb.append("    adaptiveQuantizationStrength: ").append(toIndentedString(adaptiveQuantizationStrength)).append("\n");
    sb.append("    mixedReferences: ").append(toIndentedString(mixedReferences)).append("\n");
    sb.append("    adaptiveSpatialTransform: ").append(toIndentedString(adaptiveSpatialTransform)).append("\n");
    sb.append("    fastSkipDetectionPFrames: ").append(toIndentedString(fastSkipDetectionPFrames)).append("\n");
    sb.append("    weightedPredictionBFrames: ").append(toIndentedString(weightedPredictionBFrames)).append("\n");
    sb.append("    weightedPredictionPFrames: ").append(toIndentedString(weightedPredictionPFrames)).append("\n");
    sb.append("    macroblockTreeRatecontrol: ").append(toIndentedString(macroblockTreeRatecontrol)).append("\n");
    sb.append("    quantizerCurveCompression: ").append(toIndentedString(quantizerCurveCompression)).append("\n");
    sb.append("    psyRateDistortionOptimization: ").append(toIndentedString(psyRateDistortionOptimization)).append("\n");
    sb.append("    psyTrellis: ").append(toIndentedString(psyTrellis)).append("\n");
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

