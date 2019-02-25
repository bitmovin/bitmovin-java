package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AdaptiveQuantMode;
import com.bitmovin.api.model.BAdapt;
import com.bitmovin.api.model.CodecConfigType;
import com.bitmovin.api.model.ColorConfig;
import com.bitmovin.api.model.EncodingMode;
import com.bitmovin.api.model.ForceFlushMode;
import com.bitmovin.api.model.LevelH265;
import com.bitmovin.api.model.LimitReferences;
import com.bitmovin.api.model.LimitTransferUnitDepthRecursionMode;
import com.bitmovin.api.model.MaxCtuSize;
import com.bitmovin.api.model.MaxTransferUnitSize;
import com.bitmovin.api.model.MinCodingUnitSize;
import com.bitmovin.api.model.MotionSearch;
import com.bitmovin.api.model.PixelFormat;
import com.bitmovin.api.model.ProfileH265;
import com.bitmovin.api.model.QuantizationGroupSize;
import com.bitmovin.api.model.RateDistortionLevelForQuantization;
import com.bitmovin.api.model.RateDistortionPenaltyMode;
import com.bitmovin.api.model.TransformSkipMode;
import com.bitmovin.api.model.TuInterDepth;
import com.bitmovin.api.model.TuIntraDepth;
import com.bitmovin.api.model.VideoConfiguration;
import com.bitmovin.api.model.VideoFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * H265VideoConfiguration
 */

public class H265VideoConfiguration extends VideoConfiguration {
  @JsonProperty("crf")
  private Double crf;

  @JsonProperty("profile")
  private ProfileH265 profile = null;

  @JsonProperty("bframes")
  private Integer bframes;

  @JsonProperty("refFrames")
  private Integer refFrames;

  @JsonProperty("qp")
  private Integer qp;

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
  private LevelH265 level = null;

  @JsonProperty("rcLookahead")
  private Integer rcLookahead;

  @JsonProperty("bAdapt")
  private BAdapt bAdapt = null;

  @JsonProperty("maxCTUSize")
  private MaxCtuSize maxCTUSize = null;

  @JsonProperty("tuIntraDepth")
  private TuIntraDepth tuIntraDepth = null;

  @JsonProperty("tuInterDepth")
  private TuInterDepth tuInterDepth = null;

  @JsonProperty("motionSearch")
  private MotionSearch motionSearch = null;

  @JsonProperty("subMe")
  private Integer subMe;

  @JsonProperty("motionSearchRange")
  private Integer motionSearchRange;

  @JsonProperty("weightPredictionOnPSlice")
  private Boolean weightPredictionOnPSlice;

  @JsonProperty("weightPredictionOnBSlice")
  private Boolean weightPredictionOnBSlice;

  @JsonProperty("sao")
  private Boolean sao;

  @JsonProperty("masterDisplay")
  private String masterDisplay;

  @JsonProperty("maxContentLightLevel")
  private String maxContentLightLevel;

  @JsonProperty("maxAverageLightLevel")
  private Integer maxAverageLightLevel;

  @JsonProperty("hdr")
  private Boolean hdr;

  @JsonProperty("sceneCutThreshold")
  private Integer sceneCutThreshold;

  @JsonProperty("adaptiveQuantizationMode")
  private AdaptiveQuantMode adaptiveQuantizationMode = null;

  @JsonProperty("enableHlgSignaling")
  private Boolean enableHlgSignaling;

  @JsonProperty("videoFormat")
  private VideoFormat videoFormat = null;

  @JsonProperty("psyRateDistortionOptimization")
  private Double psyRateDistortionOptimization;

  @JsonProperty("psyRateDistortionOptimizedQuantization")
  private Double psyRateDistortionOptimizedQuantization;

  @JsonProperty("enableHrdSignaling")
  private Boolean enableHrdSignaling;

  @JsonProperty("cutree")
  private Boolean cutree;

  @JsonProperty("minCodingUnitSize")
  private MinCodingUnitSize minCodingUnitSize = null;

  @JsonProperty("lookaheadSlices")
  private Integer lookaheadSlices;

  @JsonProperty("limitReferences")
  private LimitReferences limitReferences = null;

  @JsonProperty("rectangularMotionPartitionsAnalysis")
  private Boolean rectangularMotionPartitionsAnalysis;

  @JsonProperty("asymetricMotionPartitionsAnalysis")
  private Boolean asymetricMotionPartitionsAnalysis;

  @JsonProperty("limitModes")
  private Boolean limitModes;

  @JsonProperty("maxMerge")
  private Integer maxMerge;

  @JsonProperty("earlySkip")
  private Boolean earlySkip;

  @JsonProperty("recursionSkip")
  private Boolean recursionSkip;

  @JsonProperty("fastSearchForAngularIntraPredictions")
  private Boolean fastSearchForAngularIntraPredictions;

  @JsonProperty("evaluationOfIntraModesInBSlices")
  private Boolean evaluationOfIntraModesInBSlices;

  @JsonProperty("signHide")
  private Boolean signHide;

  @JsonProperty("rateDistortionLevelForModeDecision")
  private Integer rateDistortionLevelForModeDecision;

  @JsonProperty("rateDistortionLevelForQuantization")
  private RateDistortionLevelForQuantization rateDistortionLevelForQuantization = null;

  @JsonProperty("qpMin")
  private Integer qpMin;

  @JsonProperty("qpMax")
  private Integer qpMax;

  @JsonProperty("wavefrontParallelProcessing")
  private Boolean wavefrontParallelProcessing;

  @JsonProperty("parallelModeDecision")
  private Boolean parallelModeDecision;

  @JsonProperty("parallelMotionEstimation")
  private Boolean parallelMotionEstimation;

  @JsonProperty("slices")
  private Integer slices;

  @JsonProperty("copyPicture")
  private Boolean copyPicture;

  @JsonProperty("levelHighTier")
  private Boolean levelHighTier;

  @JsonProperty("skipSplitRateDistortionAnalysis")
  private Boolean skipSplitRateDistortionAnalysis;

  @JsonProperty("codingUnitLossless")
  private Boolean codingUnitLossless;

  @JsonProperty("transformSkip")
  private TransformSkipMode transformSkip = null;

  @JsonProperty("refineRateDistortionCost")
  private Boolean refineRateDistortionCost;

  @JsonProperty("limitTransferUnitDepthRecursion")
  private LimitTransferUnitDepthRecursionMode limitTransferUnitDepthRecursion = null;

  @JsonProperty("noiseReductionIntra")
  private Integer noiseReductionIntra;

  @JsonProperty("noiseReductionInter")
  private Integer noiseReductionInter;

  @JsonProperty("rateDistortionPenalty")
  private RateDistortionPenaltyMode rateDistortionPenalty = null;

  @JsonProperty("maximumTransferUnitSize")
  private MaxTransferUnitSize maximumTransferUnitSize = null;

  @JsonProperty("dynamicRateDistortionStrength")
  private Integer dynamicRateDistortionStrength;

  @JsonProperty("ssimRateDistortionOptimization")
  private Boolean ssimRateDistortionOptimization;

  @JsonProperty("temporalMotionVectorPredictors")
  private Boolean temporalMotionVectorPredictors;

  @JsonProperty("analyzeSourceFramePixels")
  private Boolean analyzeSourceFramePixels;

  @JsonProperty("strongIntraSmoothing")
  private Boolean strongIntraSmoothing;

  @JsonProperty("constrainedIntraPrediction")
  private Boolean constrainedIntraPrediction;

  @JsonProperty("scenecutBias")
  private Double scenecutBias;

  @JsonProperty("allowedRADLBeforeIDR")
  private Integer allowedRADLBeforeIDR;

  @JsonProperty("gopLookahead")
  private Integer gopLookahead;

  @JsonProperty("bframeBias")
  private Integer bframeBias;

  @JsonProperty("forceFlush")
  private ForceFlushMode forceFlush = null;

  @JsonProperty("adaptiveQuantizationStrength")
  private Double adaptiveQuantizationStrength;

  @JsonProperty("adaptiveQuantizationMotion")
  private Boolean adaptiveQuantizationMotion;

  @JsonProperty("quantizationGroupSize")
  private QuantizationGroupSize quantizationGroupSize = null;

  @JsonProperty("strictCbr")
  private Boolean strictCbr;

  @JsonProperty("qpOffsetChromaCb")
  private Integer qpOffsetChromaCb;

  @JsonProperty("qpOffsetChromaCr")
  private Integer qpOffsetChromaCr;

  @JsonProperty("ipRatio")
  private Double ipRatio;

  @JsonProperty("pbRatio")
  private Double pbRatio;

  @JsonProperty("quantizerCurveCompressionFactor")
  private Double quantizerCurveCompressionFactor;

  @JsonProperty("qpStep")
  private Integer qpStep;

  @JsonProperty("grainOptimizedRateControl")
  private Boolean grainOptimizedRateControl;

  @JsonProperty("blurQuants")
  private Double blurQuants;

  @JsonProperty("blurComplexity")
  private Double blurComplexity;

  @JsonProperty("saoNonDeblock")
  private Boolean saoNonDeblock;

  @JsonProperty("limitSao")
  private Boolean limitSao;

  @JsonProperty("lowpassDct")
  private Boolean lowpassDct;


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
  public ProfileH265 getProfile() {
    return profile;
  }

  public void setProfile(ProfileH265 profile) {
    this.profile = profile;
  }


  /**
   * Sets the amount of b frames
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
   * Sets the amount of reference frames
   * minimum: 0
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
   * Sets the quantization factor
   * minimum: 0
   * maximum: 51
   * @return qp
  **/
  public Integer getQp() {
    return qp;
  }

  public void setQp(Integer qp) {
    this.qp = qp;
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
   * Specify the size of the VBV buffer (kbits)
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
  public LevelH265 getLevel() {
    return level;
  }

  public void setLevel(LevelH265 level) {
    this.level = level;
  }


  /**
   * Number of frames for slice-type decision lookahead
   * minimum: 1
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
   * Set the level of effort in determining B frame placement
   * @return bAdapt
  **/
  public BAdapt getBAdapt() {
    return bAdapt;
  }

  public void setBAdapt(BAdapt bAdapt) {
    this.bAdapt = bAdapt;
  }


  /**
   * Get maxCTUSize
   * @return maxCTUSize
  **/
  public MaxCtuSize getMaxCTUSize() {
    return maxCTUSize;
  }

  public void setMaxCTUSize(MaxCtuSize maxCTUSize) {
    this.maxCTUSize = maxCTUSize;
  }


  /**
   * Get tuIntraDepth
   * @return tuIntraDepth
  **/
  public TuIntraDepth getTuIntraDepth() {
    return tuIntraDepth;
  }

  public void setTuIntraDepth(TuIntraDepth tuIntraDepth) {
    this.tuIntraDepth = tuIntraDepth;
  }


  /**
   * Get tuInterDepth
   * @return tuInterDepth
  **/
  public TuInterDepth getTuInterDepth() {
    return tuInterDepth;
  }

  public void setTuInterDepth(TuInterDepth tuInterDepth) {
    this.tuInterDepth = tuInterDepth;
  }


  /**
   * Get motionSearch
   * @return motionSearch
  **/
  public MotionSearch getMotionSearch() {
    return motionSearch;
  }

  public void setMotionSearch(MotionSearch motionSearch) {
    this.motionSearch = motionSearch;
  }


  /**
   * Set the amount of subpel refinement to perform.
   * minimum: 0
   * maximum: 7
   * @return subMe
  **/
  public Integer getSubMe() {
    return subMe;
  }

  public void setSubMe(Integer subMe) {
    this.subMe = subMe;
  }


  /**
   * Set the Motion search range.
   * minimum: 0
   * maximum: 32768
   * @return motionSearchRange
  **/
  public Integer getMotionSearchRange() {
    return motionSearchRange;
  }

  public void setMotionSearchRange(Integer motionSearchRange) {
    this.motionSearchRange = motionSearchRange;
  }


  /**
   * Enable weighted prediction in P slices
   * @return weightPredictionOnPSlice
  **/
  public Boolean getWeightPredictionOnPSlice() {
    return weightPredictionOnPSlice;
  }

  public void setWeightPredictionOnPSlice(Boolean weightPredictionOnPSlice) {
    this.weightPredictionOnPSlice = weightPredictionOnPSlice;
  }


  /**
   * Enable weighted prediction in B slices
   * @return weightPredictionOnBSlice
  **/
  public Boolean getWeightPredictionOnBSlice() {
    return weightPredictionOnBSlice;
  }

  public void setWeightPredictionOnBSlice(Boolean weightPredictionOnBSlice) {
    this.weightPredictionOnBSlice = weightPredictionOnBSlice;
  }


  /**
   * Toggle sample adaptive offset loop filter
   * @return sao
  **/
  public Boolean getSao() {
    return sao;
  }

  public void setSao(Boolean sao) {
    this.sao = sao;
  }


  /**
   * Set the mastering display color volume SEI info (SMPTE ST 2086). For example &#x60;G(13250,34500)B(7500,3000)R(34000,16000)WP(15635,16450)L(10000000,1)&#x60; describes a P3D65 1000-nits monitor, where G(x&#x3D;0.265, y&#x3D;0.690), B(x&#x3D;0.150, y&#x3D;0.060), R(x&#x3D;0.680, y&#x3D;0.320), WP(x&#x3D;0.3127, y&#x3D;0.3290), L(max&#x3D;1000, min&#x3D;0.0001). Part of HDR-10 metadata.
   * @return masterDisplay
  **/
  public String getMasterDisplay() {
    return masterDisplay;
  }

  public void setMasterDisplay(String masterDisplay) {
    this.masterDisplay = masterDisplay;
  }


  /**
   * Set the max content light level (MaxCLL). Use together with maxPictureAverageLightLevel (which will be 0 if not set). Part of HDR-10 metadata.
   * @return maxContentLightLevel
  **/
  public String getMaxContentLightLevel() {
    return maxContentLightLevel;
  }

  public void setMaxContentLightLevel(String maxContentLightLevel) {
    this.maxContentLightLevel = maxContentLightLevel;
  }


  /**
   * Set the maximum picture average light level (MaxFALL). Use together with maxContentLightLevel (which will be 0 if not set). Part of HDR-10 metadata.
   * @return maxAverageLightLevel
  **/
  public Integer getMaxAverageLightLevel() {
    return maxAverageLightLevel;
  }

  public void setMaxAverageLightLevel(Integer maxAverageLightLevel) {
    this.maxAverageLightLevel = maxAverageLightLevel;
  }


  /**
   * Force signaling of HDR parameters in SEI packets. Enabled automatically when masterDisplay or maxContentLightLevel/maxPictureAverageLightLevel are set. Useful when there is a desire to signal 0 values for maxContentLightLevel and maxPictureAverageLightLevel.
   * @return hdr
  **/
  public Boolean getHdr() {
    return hdr;
  }

  public void setHdr(Boolean hdr) {
    this.hdr = hdr;
  }


  /**
   * Scene Change sensitivity. The higher the value, the more likely an I-Frame will be inserted. Set to 0 to disable it.
   * minimum: 0
   * @return sceneCutThreshold
  **/
  public Integer getSceneCutThreshold() {
    return sceneCutThreshold;
  }

  public void setSceneCutThreshold(Integer sceneCutThreshold) {
    this.sceneCutThreshold = sceneCutThreshold;
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
   * By enabling this video stream will be signaled as HLG
   * @return enableHlgSignaling
  **/
  public Boolean getEnableHlgSignaling() {
    return enableHlgSignaling;
  }

  public void setEnableHlgSignaling(Boolean enableHlgSignaling) {
    this.enableHlgSignaling = enableHlgSignaling;
  }


  /**
   * Specifies the source format of the original analog video prior to digitizing and encoding
   * @return videoFormat
  **/
  public VideoFormat getVideoFormat() {
    return videoFormat;
  }

  public void setVideoFormat(VideoFormat videoFormat) {
    this.videoFormat = videoFormat;
  }


  /**
   * Psycho-visual rate-distortion retains fine details like film grain at the expense of more blocking artifacts. Higher values make the video appear sharper and more detailed but with a higher risk of blocking artifacts. Needs to have subMe with RD_IP, RD_ALL, RD_REF_IP, RD_REF_ALL, QPRD or FULL_RD
   * @return psyRateDistortionOptimization
  **/
  public Double getPsyRateDistortionOptimization() {
    return psyRateDistortionOptimization;
  }

  public void setPsyRateDistortionOptimization(Double psyRateDistortionOptimization) {
    this.psyRateDistortionOptimization = psyRateDistortionOptimization;
  }


  /**
   * Strength of psycho-visual optimizations in quantization. Only has an effect in presets which use RDOQ (rd-levels 4 and 5). The value must be between 0 and 50, 1.0 is typical
   * @return psyRateDistortionOptimizedQuantization
  **/
  public Double getPsyRateDistortionOptimizedQuantization() {
    return psyRateDistortionOptimizedQuantization;
  }

  public void setPsyRateDistortionOptimizedQuantization(Double psyRateDistortionOptimizedQuantization) {
    this.psyRateDistortionOptimizedQuantization = psyRateDistortionOptimizedQuantization;
  }


  /**
   * Signal hypothetical reference decoder (HRD) information
   * @return enableHrdSignaling
  **/
  public Boolean getEnableHrdSignaling() {
    return enableHrdSignaling;
  }

  public void setEnableHrdSignaling(Boolean enableHrdSignaling) {
    this.enableHrdSignaling = enableHrdSignaling;
  }


  /**
   * Enables the use of lookahead’s lowres motion vector fields to determine the amount of reuse of each block to tune adaptive quantization factors.
   * @return cutree
  **/
  public Boolean getCutree() {
    return cutree;
  }

  public void setCutree(Boolean cutree) {
    this.cutree = cutree;
  }


  /**
   * Minimum CU size (width and height). By using 16 or 32 the encoder will not analyze the cost of CUs below that minimum threshold, saving considerable amounts of compute with a predictable increase in bitrate. This setting has a large effect on performance on the faster presets.
   * @return minCodingUnitSize
  **/
  public MinCodingUnitSize getMinCodingUnitSize() {
    return minCodingUnitSize;
  }

  public void setMinCodingUnitSize(MinCodingUnitSize minCodingUnitSize) {
    this.minCodingUnitSize = minCodingUnitSize;
  }


  /**
   * Use multiple worker threads to measure the estimated cost of each frame within the lookahead. The higher this parameter, the less accurate the frame costs will be which will result in less accurate B-frame and scene-cut decisions. Valid range: 0 - 16
   * @return lookaheadSlices
  **/
  public Integer getLookaheadSlices() {
    return lookaheadSlices;
  }

  public void setLookaheadSlices(Integer lookaheadSlices) {
    this.lookaheadSlices = lookaheadSlices;
  }


  /**
   * If enabled, limit references per depth, CU or both.
   * @return limitReferences
  **/
  public LimitReferences getLimitReferences() {
    return limitReferences;
  }

  public void setLimitReferences(LimitReferences limitReferences) {
    this.limitReferences = limitReferences;
  }


  /**
   * Enable analysis of rectangular motion partitions Nx2N and 2NxN.
   * @return rectangularMotionPartitionsAnalysis
  **/
  public Boolean getRectangularMotionPartitionsAnalysis() {
    return rectangularMotionPartitionsAnalysis;
  }

  public void setRectangularMotionPartitionsAnalysis(Boolean rectangularMotionPartitionsAnalysis) {
    this.rectangularMotionPartitionsAnalysis = rectangularMotionPartitionsAnalysis;
  }


  /**
   * Enable analysis of asymmetric motion partitions.
   * @return asymetricMotionPartitionsAnalysis
  **/
  public Boolean getAsymetricMotionPartitionsAnalysis() {
    return asymetricMotionPartitionsAnalysis;
  }

  public void setAsymetricMotionPartitionsAnalysis(Boolean asymetricMotionPartitionsAnalysis) {
    this.asymetricMotionPartitionsAnalysis = asymetricMotionPartitionsAnalysis;
  }


  /**
   * When enabled, will limit modes analyzed for each CU using cost metrics from the 4 sub-CUs. This can significantly improve performance when &#x60;rectangularMotionPartitionsAnalysis&#x60; and/or &#x60;asymetricMotionPartitionsAnalysis&#x60; are enabled at minimal compression efficiency loss.
   * @return limitModes
  **/
  public Boolean getLimitModes() {
    return limitModes;
  }

  public void setLimitModes(Boolean limitModes) {
    this.limitModes = limitModes;
  }


  /**
   * Maximum number of neighbor (spatial and temporal) candidate blocks that the encoder may consider for merging motion predictions. Valid range: 1 - 5
   * @return maxMerge
  **/
  public Integer getMaxMerge() {
    return maxMerge;
  }

  public void setMaxMerge(Integer maxMerge) {
    this.maxMerge = maxMerge;
  }


  /**
   * Measure 2Nx2N merge candidates first; if no residual is found, additional modes at that depth are not analysed.
   * @return earlySkip
  **/
  public Boolean getEarlySkip() {
    return earlySkip;
  }

  public void setEarlySkip(Boolean earlySkip) {
    this.earlySkip = earlySkip;
  }


  /**
   * If enabled exits early from CU depth recursion. When a skip CU is found, additional heuristics are used to decide whether to terminate recursion.
   * @return recursionSkip
  **/
  public Boolean getRecursionSkip() {
    return recursionSkip;
  }

  public void setRecursionSkip(Boolean recursionSkip) {
    this.recursionSkip = recursionSkip;
  }


  /**
   * Enable faster search method for angular intra predictions.
   * @return fastSearchForAngularIntraPredictions
  **/
  public Boolean getFastSearchForAngularIntraPredictions() {
    return fastSearchForAngularIntraPredictions;
  }

  public void setFastSearchForAngularIntraPredictions(Boolean fastSearchForAngularIntraPredictions) {
    this.fastSearchForAngularIntraPredictions = fastSearchForAngularIntraPredictions;
  }


  /**
   * Enables the evaluation of intra modes in B slices.
   * @return evaluationOfIntraModesInBSlices
  **/
  public Boolean getEvaluationOfIntraModesInBSlices() {
    return evaluationOfIntraModesInBSlices;
  }

  public void setEvaluationOfIntraModesInBSlices(Boolean evaluationOfIntraModesInBSlices) {
    this.evaluationOfIntraModesInBSlices = evaluationOfIntraModesInBSlices;
  }


  /**
   * Hide sign bit of one coefficient per coding tree unit.
   * @return signHide
  **/
  public Boolean getSignHide() {
    return signHide;
  }

  public void setSignHide(Boolean signHide) {
    this.signHide = signHide;
  }


  /**
   * Level of rate-distortion optimization in mode decision. The lower the value the faster the encode, the higher the value higher the compression efficiency. Valid range: 0 - 6
   * @return rateDistortionLevelForModeDecision
  **/
  public Integer getRateDistortionLevelForModeDecision() {
    return rateDistortionLevelForModeDecision;
  }

  public void setRateDistortionLevelForModeDecision(Integer rateDistortionLevelForModeDecision) {
    this.rateDistortionLevelForModeDecision = rateDistortionLevelForModeDecision;
  }


  /**
   * Specify the amount of rate-distortion analysis to use within quantization.
   * @return rateDistortionLevelForQuantization
  **/
  public RateDistortionLevelForQuantization getRateDistortionLevelForQuantization() {
    return rateDistortionLevelForQuantization;
  }

  public void setRateDistortionLevelForQuantization(RateDistortionLevelForQuantization rateDistortionLevelForQuantization) {
    this.rateDistortionLevelForQuantization = rateDistortionLevelForQuantization;
  }


  /**
   * Sets the minimum of quantization factor. Valid value range: 0 - 69
   * @return qpMin
  **/
  public Integer getQpMin() {
    return qpMin;
  }

  public void setQpMin(Integer qpMin) {
    this.qpMin = qpMin;
  }


  /**
   * Sets the maximum of quantization factor. Valid value range: 0 - 69
   * @return qpMax
  **/
  public Integer getQpMax() {
    return qpMax;
  }

  public void setQpMax(Integer qpMax) {
    this.qpMax = qpMax;
  }


  /**
   * The encoder may begin encoding a row as soon as the row above it is at least two CTUs ahead in the encode process. Default is enabled.
   * @return wavefrontParallelProcessing
  **/
  public Boolean getWavefrontParallelProcessing() {
    return wavefrontParallelProcessing;
  }

  public void setWavefrontParallelProcessing(Boolean wavefrontParallelProcessing) {
    this.wavefrontParallelProcessing = wavefrontParallelProcessing;
  }


  /**
   * When enabled the encoder will distribute the analysis work of each CU (merge, inter, intra) across multiple worker threads. Default is disabled.
   * @return parallelModeDecision
  **/
  public Boolean getParallelModeDecision() {
    return parallelModeDecision;
  }

  public void setParallelModeDecision(Boolean parallelModeDecision) {
    this.parallelModeDecision = parallelModeDecision;
  }


  /**
   * When enabled the encoder will distribute motion estimation across multiple worker threads when more than two references require motion searches for a given CU. Default is disabled.
   * @return parallelMotionEstimation
  **/
  public Boolean getParallelMotionEstimation() {
    return parallelMotionEstimation;
  }

  public void setParallelMotionEstimation(Boolean parallelMotionEstimation) {
    this.parallelMotionEstimation = parallelMotionEstimation;
  }


  /**
   * Encode each incoming frame as multiple parallel slices that may be decoded independently. Default is 1.
   * @return slices
  **/
  public Integer getSlices() {
    return slices;
  }

  public void setSlices(Integer slices) {
    this.slices = slices;
  }


  /**
   * Copy buffers of input picture in frame. Default is enabled.
   * @return copyPicture
  **/
  public Boolean getCopyPicture() {
    return copyPicture;
  }

  public void setCopyPicture(Boolean copyPicture) {
    this.copyPicture = copyPicture;
  }


  /**
   * If high tier is disabled the encoder will attempt to encode only at the main tier. Default is enabled.
   * @return levelHighTier
  **/
  public Boolean getLevelHighTier() {
    return levelHighTier;
  }

  public void setLevelHighTier(Boolean levelHighTier) {
    this.levelHighTier = levelHighTier;
  }


  /**
   * Enable skipping split rate distortion analysis when sum of split CU RD cost larger than one split CU RD cost for intra CU. Default disabled.
   * @return skipSplitRateDistortionAnalysis
  **/
  public Boolean getSkipSplitRateDistortionAnalysis() {
    return skipSplitRateDistortionAnalysis;
  }

  public void setSkipSplitRateDistortionAnalysis(Boolean skipSplitRateDistortionAnalysis) {
    this.skipSplitRateDistortionAnalysis = skipSplitRateDistortionAnalysis;
  }


  /**
   * If enabled, consider lossless mode in CU RDO decisions. Default is disabled.
   * @return codingUnitLossless
  **/
  public Boolean getCodingUnitLossless() {
    return codingUnitLossless;
  }

  public void setCodingUnitLossless(Boolean codingUnitLossless) {
    this.codingUnitLossless = codingUnitLossless;
  }


  /**
   * Enable evaluation of transform skip (bypass DCT but still use quantization) coding for 4x4 TU coded blocks. Default is NONE.
   * @return transformSkip
  **/
  public TransformSkipMode getTransformSkip() {
    return transformSkip;
  }

  public void setTransformSkip(TransformSkipMode transformSkip) {
    this.transformSkip = transformSkip;
  }


  /**
   * Enable QP based rate distortion refinement. Default is disabled.
   * @return refineRateDistortionCost
  **/
  public Boolean getRefineRateDistortionCost() {
    return refineRateDistortionCost;
  }

  public void setRefineRateDistortionCost(Boolean refineRateDistortionCost) {
    this.refineRateDistortionCost = refineRateDistortionCost;
  }


  /**
   * Enables early exit from transfer unit depth recursion, for inter coded blocks. Default is DISABLED.
   * @return limitTransferUnitDepthRecursion
  **/
  public LimitTransferUnitDepthRecursionMode getLimitTransferUnitDepthRecursion() {
    return limitTransferUnitDepthRecursion;
  }

  public void setLimitTransferUnitDepthRecursion(LimitTransferUnitDepthRecursionMode limitTransferUnitDepthRecursion) {
    this.limitTransferUnitDepthRecursion = limitTransferUnitDepthRecursion;
  }


  /**
   * An integer value, which denotes strength of noise reduction in intra CUs. Default 0.
   * minimum: 0
   * maximum: 2000
   * @return noiseReductionIntra
  **/
  public Integer getNoiseReductionIntra() {
    return noiseReductionIntra;
  }

  public void setNoiseReductionIntra(Integer noiseReductionIntra) {
    this.noiseReductionIntra = noiseReductionIntra;
  }


  /**
   * An integer value, which denotes strength of noise reduction in inter CUs. Default 0.
   * minimum: 0
   * maximum: 2000
   * @return noiseReductionInter
  **/
  public Integer getNoiseReductionInter() {
    return noiseReductionInter;
  }

  public void setNoiseReductionInter(Integer noiseReductionInter) {
    this.noiseReductionInter = noiseReductionInter;
  }


  /**
   * Penalty for 32x32 intra transfer units in non-I slices. Default DISABLED.
   * @return rateDistortionPenalty
  **/
  public RateDistortionPenaltyMode getRateDistortionPenalty() {
    return rateDistortionPenalty;
  }

  public void setRateDistortionPenalty(RateDistortionPenaltyMode rateDistortionPenalty) {
    this.rateDistortionPenalty = rateDistortionPenalty;
  }


  /**
   * Penalty for 32x32 intra transfer units in non-I slices. Default DISABLED.
   * @return maximumTransferUnitSize
  **/
  public MaxTransferUnitSize getMaximumTransferUnitSize() {
    return maximumTransferUnitSize;
  }

  public void setMaximumTransferUnitSize(MaxTransferUnitSize maximumTransferUnitSize) {
    this.maximumTransferUnitSize = maximumTransferUnitSize;
  }


  /**
   * Increases the RD level at points where quality drops due to VBV rate control enforcement. Default 0.
   * minimum: 0
   * maximum: 4
   * @return dynamicRateDistortionStrength
  **/
  public Integer getDynamicRateDistortionStrength() {
    return dynamicRateDistortionStrength;
  }

  public void setDynamicRateDistortionStrength(Integer dynamicRateDistortionStrength) {
    this.dynamicRateDistortionStrength = dynamicRateDistortionStrength;
  }


  /**
   * It is used for mode selection during analysis of CTUs and can achieve significant gain in terms of objective quality metrics SSIM and PSNR. Default false.
   * @return ssimRateDistortionOptimization
  **/
  public Boolean getSsimRateDistortionOptimization() {
    return ssimRateDistortionOptimization;
  }

  public void setSsimRateDistortionOptimization(Boolean ssimRateDistortionOptimization) {
    this.ssimRateDistortionOptimization = ssimRateDistortionOptimization;
  }


  /**
   * Enable temporal motion vector predictors in P and B slices. Default true.
   * @return temporalMotionVectorPredictors
  **/
  public Boolean getTemporalMotionVectorPredictors() {
    return temporalMotionVectorPredictors;
  }

  public void setTemporalMotionVectorPredictors(Boolean temporalMotionVectorPredictors) {
    this.temporalMotionVectorPredictors = temporalMotionVectorPredictors;
  }


  /**
   * Enable motion estimation with source frame pixels, in this mode, motion estimation can be computed independently. Default false.
   * @return analyzeSourceFramePixels
  **/
  public Boolean getAnalyzeSourceFramePixels() {
    return analyzeSourceFramePixels;
  }

  public void setAnalyzeSourceFramePixels(Boolean analyzeSourceFramePixels) {
    this.analyzeSourceFramePixels = analyzeSourceFramePixels;
  }


  /**
   * Enable strong intra smoothing for 32x32 intra blocks. Default true.
   * @return strongIntraSmoothing
  **/
  public Boolean getStrongIntraSmoothing() {
    return strongIntraSmoothing;
  }

  public void setStrongIntraSmoothing(Boolean strongIntraSmoothing) {
    this.strongIntraSmoothing = strongIntraSmoothing;
  }


  /**
   * When generating intra predictions for blocks in inter slices, only intra-coded reference pixels are used. Default false.
   * @return constrainedIntraPrediction
  **/
  public Boolean getConstrainedIntraPrediction() {
    return constrainedIntraPrediction;
  }

  public void setConstrainedIntraPrediction(Boolean constrainedIntraPrediction) {
    this.constrainedIntraPrediction = constrainedIntraPrediction;
  }


  /**
   * This value represents the percentage difference between the inter cost and intra cost of a frame used in scenecut detection. Default 5.0.
   * minimum: 0
   * maximum: 100
   * @return scenecutBias
  **/
  public Double getScenecutBias() {
    return scenecutBias;
  }

  public void setScenecutBias(Double scenecutBias) {
    this.scenecutBias = scenecutBias;
  }


  /**
   * Number of RADL pictures allowed infront of IDR. Requires fixed keyframe interval. Valid values 0 - &#x60;bframes&#x60;. Default 0.
   * @return allowedRADLBeforeIDR
  **/
  public Integer getAllowedRADLBeforeIDR() {
    return allowedRADLBeforeIDR;
  }

  public void setAllowedRADLBeforeIDR(Integer allowedRADLBeforeIDR) {
    this.allowedRADLBeforeIDR = allowedRADLBeforeIDR;
  }


  /**
   * Number of frames for GOP boundary decision lookahead. Valid values 0 - &#x60;rcLookahead&#x60;. Default 0
   * @return gopLookahead
  **/
  public Integer getGopLookahead() {
    return gopLookahead;
  }

  public void setGopLookahead(Integer gopLookahead) {
    this.gopLookahead = gopLookahead;
  }


  /**
   * Bias towards B frames in slicetype decision. The higher the bias the more likely the encoder is to use B frames. Default 0
   * minimum: -90
   * maximum: 100
   * @return bframeBias
  **/
  public Integer getBframeBias() {
    return bframeBias;
  }

  public void setBframeBias(Integer bframeBias) {
    this.bframeBias = bframeBias;
  }


  /**
   * Force the encoder to flush frames. Default is DISABLED.
   * @return forceFlush
  **/
  public ForceFlushMode getForceFlush() {
    return forceFlush;
  }

  public void setForceFlush(ForceFlushMode forceFlush) {
    this.forceFlush = forceFlush;
  }


  /**
   * Adjust the strength of the adaptive quantization offsets. Default 1.0.
   * minimum: 0
   * maximum: 3
   * @return adaptiveQuantizationStrength
  **/
  public Double getAdaptiveQuantizationStrength() {
    return adaptiveQuantizationStrength;
  }

  public void setAdaptiveQuantizationStrength(Double adaptiveQuantizationStrength) {
    this.adaptiveQuantizationStrength = adaptiveQuantizationStrength;
  }


  /**
   * Adjust the AQ offsets based on the relative motion of each block with respect to the motion of the frame. Default false.
   * @return adaptiveQuantizationMotion
  **/
  public Boolean getAdaptiveQuantizationMotion() {
    return adaptiveQuantizationMotion;
  }

  public void setAdaptiveQuantizationMotion(Boolean adaptiveQuantizationMotion) {
    this.adaptiveQuantizationMotion = adaptiveQuantizationMotion;
  }


  /**
   * Enable adaptive quantization for sub-CTUs. This parameter specifies the minimum CU size at which QP can be adjusted. Default is same as &#x60;maxCTUSize&#x60;.
   * @return quantizationGroupSize
  **/
  public QuantizationGroupSize getQuantizationGroupSize() {
    return quantizationGroupSize;
  }

  public void setQuantizationGroupSize(QuantizationGroupSize quantizationGroupSize) {
    this.quantizationGroupSize = quantizationGroupSize;
  }


  /**
   * Enables stricter conditions to control bitrate deviance from the target bitrate in ABR mode. Bit rate adherence is prioritised over quality. Default false.
   * @return strictCbr
  **/
  public Boolean getStrictCbr() {
    return strictCbr;
  }

  public void setStrictCbr(Boolean strictCbr) {
    this.strictCbr = strictCbr;
  }


  /**
   * Offset of Cb chroma QP from the luma QP selected by rate control. This is a general way to spend more or less bits on the chroma channel. Default 0
   * minimum: -12
   * maximum: 12
   * @return qpOffsetChromaCb
  **/
  public Integer getQpOffsetChromaCb() {
    return qpOffsetChromaCb;
  }

  public void setQpOffsetChromaCb(Integer qpOffsetChromaCb) {
    this.qpOffsetChromaCb = qpOffsetChromaCb;
  }


  /**
   * Offset of Cr chroma QP from the luma QP selected by rate control. This is a general way to spend more or less bits on the chroma channel. Default 0
   * minimum: -12
   * maximum: 12
   * @return qpOffsetChromaCr
  **/
  public Integer getQpOffsetChromaCr() {
    return qpOffsetChromaCr;
  }

  public void setQpOffsetChromaCr(Integer qpOffsetChromaCr) {
    this.qpOffsetChromaCr = qpOffsetChromaCr;
  }


  /**
   * QP ratio factor between I and P slices. This ratio is used in all of the rate control modes. Default 1.4
   * @return ipRatio
  **/
  public Double getIpRatio() {
    return ipRatio;
  }

  public void setIpRatio(Double ipRatio) {
    this.ipRatio = ipRatio;
  }


  /**
   * QP ratio factor between P and B slices. This ratio is used in all of the rate control modes. Default 1.3
   * @return pbRatio
  **/
  public Double getPbRatio() {
    return pbRatio;
  }

  public void setPbRatio(Double pbRatio) {
    this.pbRatio = pbRatio;
  }


  /**
   * Sets the quantizer curve compression factor. It weights the frame quantizer based on the complexity of residual (measured by lookahead). Default 0.6
   * minimum: 0.5
   * maximum: 1
   * @return quantizerCurveCompressionFactor
  **/
  public Double getQuantizerCurveCompressionFactor() {
    return quantizerCurveCompressionFactor;
  }

  public void setQuantizerCurveCompressionFactor(Double quantizerCurveCompressionFactor) {
    this.quantizerCurveCompressionFactor = quantizerCurveCompressionFactor;
  }


  /**
   * The maximum single adjustment in QP allowed to rate control. Default 4
   * @return qpStep
  **/
  public Integer getQpStep() {
    return qpStep;
  }

  public void setQpStep(Integer qpStep) {
    this.qpStep = qpStep;
  }


  /**
   * Enables a specialised ratecontrol algorithm for film grain content. Default false.
   * @return grainOptimizedRateControl
  **/
  public Boolean getGrainOptimizedRateControl() {
    return grainOptimizedRateControl;
  }

  public void setGrainOptimizedRateControl(Boolean grainOptimizedRateControl) {
    this.grainOptimizedRateControl = grainOptimizedRateControl;
  }


  /**
   * Temporally blur quants. Default 0.5
   * @return blurQuants
  **/
  public Double getBlurQuants() {
    return blurQuants;
  }

  public void setBlurQuants(Double blurQuants) {
    this.blurQuants = blurQuants;
  }


  /**
   * Temporally blur complexity. Default 20.0
   * @return blurComplexity
  **/
  public Double getBlurComplexity() {
    return blurComplexity;
  }

  public void setBlurComplexity(Double blurComplexity) {
    this.blurComplexity = blurComplexity;
  }


  /**
   * Specify how to handle depencency between SAO and deblocking filter. When enabled, non-deblocked pixels are used for SAO analysis. When disabled, SAO analysis skips the right/bottom boundary areas. Default false.
   * @return saoNonDeblock
  **/
  public Boolean getSaoNonDeblock() {
    return saoNonDeblock;
  }

  public void setSaoNonDeblock(Boolean saoNonDeblock) {
    this.saoNonDeblock = saoNonDeblock;
  }


  /**
   * Limit SAO filter computation by early terminating SAO process based on inter prediction mode, CTU spatial-domain correlations, and relations between luma and chroma. Default false.
   * @return limitSao
  **/
  public Boolean getLimitSao() {
    return limitSao;
  }

  public void setLimitSao(Boolean limitSao) {
    this.limitSao = limitSao;
  }


  /**
   * Will use low-pass subband dct approximation instead of the standard dct for 16x16 and 32x32 blocks. Default false.
   * @return lowpassDct
  **/
  public Boolean getLowpassDct() {
    return lowpassDct;
  }

  public void setLowpassDct(Boolean lowpassDct) {
    this.lowpassDct = lowpassDct;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    H265VideoConfiguration h265VideoConfiguration = (H265VideoConfiguration) o;
    return Objects.equals(this.crf, h265VideoConfiguration.crf) &&
        Objects.equals(this.profile, h265VideoConfiguration.profile) &&
        Objects.equals(this.bframes, h265VideoConfiguration.bframes) &&
        Objects.equals(this.refFrames, h265VideoConfiguration.refFrames) &&
        Objects.equals(this.qp, h265VideoConfiguration.qp) &&
        Objects.equals(this.maxBitrate, h265VideoConfiguration.maxBitrate) &&
        Objects.equals(this.minBitrate, h265VideoConfiguration.minBitrate) &&
        Objects.equals(this.bufsize, h265VideoConfiguration.bufsize) &&
        Objects.equals(this.minGop, h265VideoConfiguration.minGop) &&
        Objects.equals(this.maxGop, h265VideoConfiguration.maxGop) &&
        Objects.equals(this.openGop, h265VideoConfiguration.openGop) &&
        Objects.equals(this.minKeyframeInterval, h265VideoConfiguration.minKeyframeInterval) &&
        Objects.equals(this.maxKeyframeInterval, h265VideoConfiguration.maxKeyframeInterval) &&
        Objects.equals(this.level, h265VideoConfiguration.level) &&
        Objects.equals(this.rcLookahead, h265VideoConfiguration.rcLookahead) &&
        Objects.equals(this.bAdapt, h265VideoConfiguration.bAdapt) &&
        Objects.equals(this.maxCTUSize, h265VideoConfiguration.maxCTUSize) &&
        Objects.equals(this.tuIntraDepth, h265VideoConfiguration.tuIntraDepth) &&
        Objects.equals(this.tuInterDepth, h265VideoConfiguration.tuInterDepth) &&
        Objects.equals(this.motionSearch, h265VideoConfiguration.motionSearch) &&
        Objects.equals(this.subMe, h265VideoConfiguration.subMe) &&
        Objects.equals(this.motionSearchRange, h265VideoConfiguration.motionSearchRange) &&
        Objects.equals(this.weightPredictionOnPSlice, h265VideoConfiguration.weightPredictionOnPSlice) &&
        Objects.equals(this.weightPredictionOnBSlice, h265VideoConfiguration.weightPredictionOnBSlice) &&
        Objects.equals(this.sao, h265VideoConfiguration.sao) &&
        Objects.equals(this.masterDisplay, h265VideoConfiguration.masterDisplay) &&
        Objects.equals(this.maxContentLightLevel, h265VideoConfiguration.maxContentLightLevel) &&
        Objects.equals(this.maxAverageLightLevel, h265VideoConfiguration.maxAverageLightLevel) &&
        Objects.equals(this.hdr, h265VideoConfiguration.hdr) &&
        Objects.equals(this.sceneCutThreshold, h265VideoConfiguration.sceneCutThreshold) &&
        Objects.equals(this.adaptiveQuantizationMode, h265VideoConfiguration.adaptiveQuantizationMode) &&
        Objects.equals(this.enableHlgSignaling, h265VideoConfiguration.enableHlgSignaling) &&
        Objects.equals(this.videoFormat, h265VideoConfiguration.videoFormat) &&
        Objects.equals(this.psyRateDistortionOptimization, h265VideoConfiguration.psyRateDistortionOptimization) &&
        Objects.equals(this.psyRateDistortionOptimizedQuantization, h265VideoConfiguration.psyRateDistortionOptimizedQuantization) &&
        Objects.equals(this.enableHrdSignaling, h265VideoConfiguration.enableHrdSignaling) &&
        Objects.equals(this.cutree, h265VideoConfiguration.cutree) &&
        Objects.equals(this.minCodingUnitSize, h265VideoConfiguration.minCodingUnitSize) &&
        Objects.equals(this.lookaheadSlices, h265VideoConfiguration.lookaheadSlices) &&
        Objects.equals(this.limitReferences, h265VideoConfiguration.limitReferences) &&
        Objects.equals(this.rectangularMotionPartitionsAnalysis, h265VideoConfiguration.rectangularMotionPartitionsAnalysis) &&
        Objects.equals(this.asymetricMotionPartitionsAnalysis, h265VideoConfiguration.asymetricMotionPartitionsAnalysis) &&
        Objects.equals(this.limitModes, h265VideoConfiguration.limitModes) &&
        Objects.equals(this.maxMerge, h265VideoConfiguration.maxMerge) &&
        Objects.equals(this.earlySkip, h265VideoConfiguration.earlySkip) &&
        Objects.equals(this.recursionSkip, h265VideoConfiguration.recursionSkip) &&
        Objects.equals(this.fastSearchForAngularIntraPredictions, h265VideoConfiguration.fastSearchForAngularIntraPredictions) &&
        Objects.equals(this.evaluationOfIntraModesInBSlices, h265VideoConfiguration.evaluationOfIntraModesInBSlices) &&
        Objects.equals(this.signHide, h265VideoConfiguration.signHide) &&
        Objects.equals(this.rateDistortionLevelForModeDecision, h265VideoConfiguration.rateDistortionLevelForModeDecision) &&
        Objects.equals(this.rateDistortionLevelForQuantization, h265VideoConfiguration.rateDistortionLevelForQuantization) &&
        Objects.equals(this.qpMin, h265VideoConfiguration.qpMin) &&
        Objects.equals(this.qpMax, h265VideoConfiguration.qpMax) &&
        Objects.equals(this.wavefrontParallelProcessing, h265VideoConfiguration.wavefrontParallelProcessing) &&
        Objects.equals(this.parallelModeDecision, h265VideoConfiguration.parallelModeDecision) &&
        Objects.equals(this.parallelMotionEstimation, h265VideoConfiguration.parallelMotionEstimation) &&
        Objects.equals(this.slices, h265VideoConfiguration.slices) &&
        Objects.equals(this.copyPicture, h265VideoConfiguration.copyPicture) &&
        Objects.equals(this.levelHighTier, h265VideoConfiguration.levelHighTier) &&
        Objects.equals(this.skipSplitRateDistortionAnalysis, h265VideoConfiguration.skipSplitRateDistortionAnalysis) &&
        Objects.equals(this.codingUnitLossless, h265VideoConfiguration.codingUnitLossless) &&
        Objects.equals(this.transformSkip, h265VideoConfiguration.transformSkip) &&
        Objects.equals(this.refineRateDistortionCost, h265VideoConfiguration.refineRateDistortionCost) &&
        Objects.equals(this.limitTransferUnitDepthRecursion, h265VideoConfiguration.limitTransferUnitDepthRecursion) &&
        Objects.equals(this.noiseReductionIntra, h265VideoConfiguration.noiseReductionIntra) &&
        Objects.equals(this.noiseReductionInter, h265VideoConfiguration.noiseReductionInter) &&
        Objects.equals(this.rateDistortionPenalty, h265VideoConfiguration.rateDistortionPenalty) &&
        Objects.equals(this.maximumTransferUnitSize, h265VideoConfiguration.maximumTransferUnitSize) &&
        Objects.equals(this.dynamicRateDistortionStrength, h265VideoConfiguration.dynamicRateDistortionStrength) &&
        Objects.equals(this.ssimRateDistortionOptimization, h265VideoConfiguration.ssimRateDistortionOptimization) &&
        Objects.equals(this.temporalMotionVectorPredictors, h265VideoConfiguration.temporalMotionVectorPredictors) &&
        Objects.equals(this.analyzeSourceFramePixels, h265VideoConfiguration.analyzeSourceFramePixels) &&
        Objects.equals(this.strongIntraSmoothing, h265VideoConfiguration.strongIntraSmoothing) &&
        Objects.equals(this.constrainedIntraPrediction, h265VideoConfiguration.constrainedIntraPrediction) &&
        Objects.equals(this.scenecutBias, h265VideoConfiguration.scenecutBias) &&
        Objects.equals(this.allowedRADLBeforeIDR, h265VideoConfiguration.allowedRADLBeforeIDR) &&
        Objects.equals(this.gopLookahead, h265VideoConfiguration.gopLookahead) &&
        Objects.equals(this.bframeBias, h265VideoConfiguration.bframeBias) &&
        Objects.equals(this.forceFlush, h265VideoConfiguration.forceFlush) &&
        Objects.equals(this.adaptiveQuantizationStrength, h265VideoConfiguration.adaptiveQuantizationStrength) &&
        Objects.equals(this.adaptiveQuantizationMotion, h265VideoConfiguration.adaptiveQuantizationMotion) &&
        Objects.equals(this.quantizationGroupSize, h265VideoConfiguration.quantizationGroupSize) &&
        Objects.equals(this.strictCbr, h265VideoConfiguration.strictCbr) &&
        Objects.equals(this.qpOffsetChromaCb, h265VideoConfiguration.qpOffsetChromaCb) &&
        Objects.equals(this.qpOffsetChromaCr, h265VideoConfiguration.qpOffsetChromaCr) &&
        Objects.equals(this.ipRatio, h265VideoConfiguration.ipRatio) &&
        Objects.equals(this.pbRatio, h265VideoConfiguration.pbRatio) &&
        Objects.equals(this.quantizerCurveCompressionFactor, h265VideoConfiguration.quantizerCurveCompressionFactor) &&
        Objects.equals(this.qpStep, h265VideoConfiguration.qpStep) &&
        Objects.equals(this.grainOptimizedRateControl, h265VideoConfiguration.grainOptimizedRateControl) &&
        Objects.equals(this.blurQuants, h265VideoConfiguration.blurQuants) &&
        Objects.equals(this.blurComplexity, h265VideoConfiguration.blurComplexity) &&
        Objects.equals(this.saoNonDeblock, h265VideoConfiguration.saoNonDeblock) &&
        Objects.equals(this.limitSao, h265VideoConfiguration.limitSao) &&
        Objects.equals(this.lowpassDct, h265VideoConfiguration.lowpassDct) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crf, profile, bframes, refFrames, qp, maxBitrate, minBitrate, bufsize, minGop, maxGop, openGop, minKeyframeInterval, maxKeyframeInterval, level, rcLookahead, bAdapt, maxCTUSize, tuIntraDepth, tuInterDepth, motionSearch, subMe, motionSearchRange, weightPredictionOnPSlice, weightPredictionOnBSlice, sao, masterDisplay, maxContentLightLevel, maxAverageLightLevel, hdr, sceneCutThreshold, adaptiveQuantizationMode, enableHlgSignaling, videoFormat, psyRateDistortionOptimization, psyRateDistortionOptimizedQuantization, enableHrdSignaling, cutree, minCodingUnitSize, lookaheadSlices, limitReferences, rectangularMotionPartitionsAnalysis, asymetricMotionPartitionsAnalysis, limitModes, maxMerge, earlySkip, recursionSkip, fastSearchForAngularIntraPredictions, evaluationOfIntraModesInBSlices, signHide, rateDistortionLevelForModeDecision, rateDistortionLevelForQuantization, qpMin, qpMax, wavefrontParallelProcessing, parallelModeDecision, parallelMotionEstimation, slices, copyPicture, levelHighTier, skipSplitRateDistortionAnalysis, codingUnitLossless, transformSkip, refineRateDistortionCost, limitTransferUnitDepthRecursion, noiseReductionIntra, noiseReductionInter, rateDistortionPenalty, maximumTransferUnitSize, dynamicRateDistortionStrength, ssimRateDistortionOptimization, temporalMotionVectorPredictors, analyzeSourceFramePixels, strongIntraSmoothing, constrainedIntraPrediction, scenecutBias, allowedRADLBeforeIDR, gopLookahead, bframeBias, forceFlush, adaptiveQuantizationStrength, adaptiveQuantizationMotion, quantizationGroupSize, strictCbr, qpOffsetChromaCb, qpOffsetChromaCr, ipRatio, pbRatio, quantizerCurveCompressionFactor, qpStep, grainOptimizedRateControl, blurQuants, blurComplexity, saoNonDeblock, limitSao, lowpassDct, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class H265VideoConfiguration {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    crf: ").append(toIndentedString(crf)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    bframes: ").append(toIndentedString(bframes)).append("\n");
    sb.append("    refFrames: ").append(toIndentedString(refFrames)).append("\n");
    sb.append("    qp: ").append(toIndentedString(qp)).append("\n");
    sb.append("    maxBitrate: ").append(toIndentedString(maxBitrate)).append("\n");
    sb.append("    minBitrate: ").append(toIndentedString(minBitrate)).append("\n");
    sb.append("    bufsize: ").append(toIndentedString(bufsize)).append("\n");
    sb.append("    minGop: ").append(toIndentedString(minGop)).append("\n");
    sb.append("    maxGop: ").append(toIndentedString(maxGop)).append("\n");
    sb.append("    openGop: ").append(toIndentedString(openGop)).append("\n");
    sb.append("    minKeyframeInterval: ").append(toIndentedString(minKeyframeInterval)).append("\n");
    sb.append("    maxKeyframeInterval: ").append(toIndentedString(maxKeyframeInterval)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    rcLookahead: ").append(toIndentedString(rcLookahead)).append("\n");
    sb.append("    bAdapt: ").append(toIndentedString(bAdapt)).append("\n");
    sb.append("    maxCTUSize: ").append(toIndentedString(maxCTUSize)).append("\n");
    sb.append("    tuIntraDepth: ").append(toIndentedString(tuIntraDepth)).append("\n");
    sb.append("    tuInterDepth: ").append(toIndentedString(tuInterDepth)).append("\n");
    sb.append("    motionSearch: ").append(toIndentedString(motionSearch)).append("\n");
    sb.append("    subMe: ").append(toIndentedString(subMe)).append("\n");
    sb.append("    motionSearchRange: ").append(toIndentedString(motionSearchRange)).append("\n");
    sb.append("    weightPredictionOnPSlice: ").append(toIndentedString(weightPredictionOnPSlice)).append("\n");
    sb.append("    weightPredictionOnBSlice: ").append(toIndentedString(weightPredictionOnBSlice)).append("\n");
    sb.append("    sao: ").append(toIndentedString(sao)).append("\n");
    sb.append("    masterDisplay: ").append(toIndentedString(masterDisplay)).append("\n");
    sb.append("    maxContentLightLevel: ").append(toIndentedString(maxContentLightLevel)).append("\n");
    sb.append("    maxAverageLightLevel: ").append(toIndentedString(maxAverageLightLevel)).append("\n");
    sb.append("    hdr: ").append(toIndentedString(hdr)).append("\n");
    sb.append("    sceneCutThreshold: ").append(toIndentedString(sceneCutThreshold)).append("\n");
    sb.append("    adaptiveQuantizationMode: ").append(toIndentedString(adaptiveQuantizationMode)).append("\n");
    sb.append("    enableHlgSignaling: ").append(toIndentedString(enableHlgSignaling)).append("\n");
    sb.append("    videoFormat: ").append(toIndentedString(videoFormat)).append("\n");
    sb.append("    psyRateDistortionOptimization: ").append(toIndentedString(psyRateDistortionOptimization)).append("\n");
    sb.append("    psyRateDistortionOptimizedQuantization: ").append(toIndentedString(psyRateDistortionOptimizedQuantization)).append("\n");
    sb.append("    enableHrdSignaling: ").append(toIndentedString(enableHrdSignaling)).append("\n");
    sb.append("    cutree: ").append(toIndentedString(cutree)).append("\n");
    sb.append("    minCodingUnitSize: ").append(toIndentedString(minCodingUnitSize)).append("\n");
    sb.append("    lookaheadSlices: ").append(toIndentedString(lookaheadSlices)).append("\n");
    sb.append("    limitReferences: ").append(toIndentedString(limitReferences)).append("\n");
    sb.append("    rectangularMotionPartitionsAnalysis: ").append(toIndentedString(rectangularMotionPartitionsAnalysis)).append("\n");
    sb.append("    asymetricMotionPartitionsAnalysis: ").append(toIndentedString(asymetricMotionPartitionsAnalysis)).append("\n");
    sb.append("    limitModes: ").append(toIndentedString(limitModes)).append("\n");
    sb.append("    maxMerge: ").append(toIndentedString(maxMerge)).append("\n");
    sb.append("    earlySkip: ").append(toIndentedString(earlySkip)).append("\n");
    sb.append("    recursionSkip: ").append(toIndentedString(recursionSkip)).append("\n");
    sb.append("    fastSearchForAngularIntraPredictions: ").append(toIndentedString(fastSearchForAngularIntraPredictions)).append("\n");
    sb.append("    evaluationOfIntraModesInBSlices: ").append(toIndentedString(evaluationOfIntraModesInBSlices)).append("\n");
    sb.append("    signHide: ").append(toIndentedString(signHide)).append("\n");
    sb.append("    rateDistortionLevelForModeDecision: ").append(toIndentedString(rateDistortionLevelForModeDecision)).append("\n");
    sb.append("    rateDistortionLevelForQuantization: ").append(toIndentedString(rateDistortionLevelForQuantization)).append("\n");
    sb.append("    qpMin: ").append(toIndentedString(qpMin)).append("\n");
    sb.append("    qpMax: ").append(toIndentedString(qpMax)).append("\n");
    sb.append("    wavefrontParallelProcessing: ").append(toIndentedString(wavefrontParallelProcessing)).append("\n");
    sb.append("    parallelModeDecision: ").append(toIndentedString(parallelModeDecision)).append("\n");
    sb.append("    parallelMotionEstimation: ").append(toIndentedString(parallelMotionEstimation)).append("\n");
    sb.append("    slices: ").append(toIndentedString(slices)).append("\n");
    sb.append("    copyPicture: ").append(toIndentedString(copyPicture)).append("\n");
    sb.append("    levelHighTier: ").append(toIndentedString(levelHighTier)).append("\n");
    sb.append("    skipSplitRateDistortionAnalysis: ").append(toIndentedString(skipSplitRateDistortionAnalysis)).append("\n");
    sb.append("    codingUnitLossless: ").append(toIndentedString(codingUnitLossless)).append("\n");
    sb.append("    transformSkip: ").append(toIndentedString(transformSkip)).append("\n");
    sb.append("    refineRateDistortionCost: ").append(toIndentedString(refineRateDistortionCost)).append("\n");
    sb.append("    limitTransferUnitDepthRecursion: ").append(toIndentedString(limitTransferUnitDepthRecursion)).append("\n");
    sb.append("    noiseReductionIntra: ").append(toIndentedString(noiseReductionIntra)).append("\n");
    sb.append("    noiseReductionInter: ").append(toIndentedString(noiseReductionInter)).append("\n");
    sb.append("    rateDistortionPenalty: ").append(toIndentedString(rateDistortionPenalty)).append("\n");
    sb.append("    maximumTransferUnitSize: ").append(toIndentedString(maximumTransferUnitSize)).append("\n");
    sb.append("    dynamicRateDistortionStrength: ").append(toIndentedString(dynamicRateDistortionStrength)).append("\n");
    sb.append("    ssimRateDistortionOptimization: ").append(toIndentedString(ssimRateDistortionOptimization)).append("\n");
    sb.append("    temporalMotionVectorPredictors: ").append(toIndentedString(temporalMotionVectorPredictors)).append("\n");
    sb.append("    analyzeSourceFramePixels: ").append(toIndentedString(analyzeSourceFramePixels)).append("\n");
    sb.append("    strongIntraSmoothing: ").append(toIndentedString(strongIntraSmoothing)).append("\n");
    sb.append("    constrainedIntraPrediction: ").append(toIndentedString(constrainedIntraPrediction)).append("\n");
    sb.append("    scenecutBias: ").append(toIndentedString(scenecutBias)).append("\n");
    sb.append("    allowedRADLBeforeIDR: ").append(toIndentedString(allowedRADLBeforeIDR)).append("\n");
    sb.append("    gopLookahead: ").append(toIndentedString(gopLookahead)).append("\n");
    sb.append("    bframeBias: ").append(toIndentedString(bframeBias)).append("\n");
    sb.append("    forceFlush: ").append(toIndentedString(forceFlush)).append("\n");
    sb.append("    adaptiveQuantizationStrength: ").append(toIndentedString(adaptiveQuantizationStrength)).append("\n");
    sb.append("    adaptiveQuantizationMotion: ").append(toIndentedString(adaptiveQuantizationMotion)).append("\n");
    sb.append("    quantizationGroupSize: ").append(toIndentedString(quantizationGroupSize)).append("\n");
    sb.append("    strictCbr: ").append(toIndentedString(strictCbr)).append("\n");
    sb.append("    qpOffsetChromaCb: ").append(toIndentedString(qpOffsetChromaCb)).append("\n");
    sb.append("    qpOffsetChromaCr: ").append(toIndentedString(qpOffsetChromaCr)).append("\n");
    sb.append("    ipRatio: ").append(toIndentedString(ipRatio)).append("\n");
    sb.append("    pbRatio: ").append(toIndentedString(pbRatio)).append("\n");
    sb.append("    quantizerCurveCompressionFactor: ").append(toIndentedString(quantizerCurveCompressionFactor)).append("\n");
    sb.append("    qpStep: ").append(toIndentedString(qpStep)).append("\n");
    sb.append("    grainOptimizedRateControl: ").append(toIndentedString(grainOptimizedRateControl)).append("\n");
    sb.append("    blurQuants: ").append(toIndentedString(blurQuants)).append("\n");
    sb.append("    blurComplexity: ").append(toIndentedString(blurComplexity)).append("\n");
    sb.append("    saoNonDeblock: ").append(toIndentedString(saoNonDeblock)).append("\n");
    sb.append("    limitSao: ").append(toIndentedString(limitSao)).append("\n");
    sb.append("    lowpassDct: ").append(toIndentedString(lowpassDct)).append("\n");
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

