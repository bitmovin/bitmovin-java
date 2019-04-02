package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.*;

import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class H264VideoConfiguration extends VideoConfiguration
{

    private ProfileH264 profile;

    private Float crf;

    private Integer bframes;

    private Integer refFrames;

    private Integer qpMin;

    private Integer qpMax;

    private MVPredictionMode mvPredictionMode;

    private Integer mvSearchRangeMax;

    private boolean cabac;

    private Long maxBitrate;

    private Long minBitrate;

    private Long bufsize;

    private LevelH264 level;

    private BAdapt bAdaptiveStrategy;

    private H264MotionEstimationMethod motionEstimationMethod;

    private Integer rcLookahead;

    private H264SubMe subMe;

    private List<H264Partition> partitions;

    private Integer slices;

    private H264InterlaceMode interlaceMode;

    private H264Trellis trellis;

    private PixelFormat pixelFormat;

    private Double minKeyframeInterval;

    private Double maxKeyframeInterval;

    private Integer sceneCutThreshold;

    private Cea608708SubtitleConfig cea608708SubtitleConfig;

    private H264NalHrd nalHrd;

    private H264BPyramid bPyramid;

    private Boolean openGop;

    private H264AdaptiveQuantizationMode adaptiveQuantizationMode;

    private Double adaptiveQuantizationStrength;

    public H264VideoConfiguration()
    {
        this.setType(ConfigType.H264);
        this.setCabac(true);
        cea608708SubtitleConfig = null;
    }

    public ProfileH264 getProfile()
    {
        return this.profile;
    }
    public void setProfile(ProfileH264 profile)
    {
        this.profile = profile;
    }
    public Float getCrf()
    {
        return this.crf;
    }
    public void setCrf(Float crf)
    {
        this.crf = crf;
    }
    public Integer getBframes()
    {
        return this.bframes;
    }
    public void setBframes(Integer bframes)
    {
        this.bframes = bframes;
    }
    public Integer getRefFrames()
    {
        return this.refFrames;
    }
    public void setRefFrames(Integer refFrames)
    {
        this.refFrames = refFrames;
    }
    public Integer getQpMin()
    {
        return this.qpMin;
    }
    public void setQpMin(Integer qpMin)
    {
        this.qpMin = qpMin;
    }
    public Integer getQpMax()
    {
        return this.qpMax;
    }
    public void setQpMax(Integer qpMax)
    {
        this.qpMax = qpMax;
    }
    public MVPredictionMode getMvPredictionMode()
    {
        return this.mvPredictionMode;
    }
    public void setMvPredictionMode(MVPredictionMode mvPredictionMode)
    {
        this.mvPredictionMode = mvPredictionMode;
    }
    public Integer getMvSearchRangeMax()
    {
        return this.mvSearchRangeMax;
    }
    public void setMvSearchRangeMax(Integer mvSearchRangeMax)
    {
        this.mvSearchRangeMax = mvSearchRangeMax;
    }
    public boolean isCabac()
    {
        return this.cabac;
    }
    public void setCabac(boolean cabac)
    {
        this.cabac = cabac;
    }
    public Long getMaxBitrate()
    {
        return this.maxBitrate;
    }
    public void setMaxBitrate(Long maxBitrate)
    {
        this.maxBitrate = maxBitrate;
    }
    public Long getMinBitrate()
    {
        return this.minBitrate;
    }
    public void setMinBitrate(Long minBitrate)
    {
        this.minBitrate = minBitrate;
    }
    public LevelH264 getLevel()
    {
        return this.level;
    }
    public void setLevel(LevelH264 level)
    {
        this.level = level;
    }
    public Long getBufsize()
    {
        return this.bufsize;
    }
    public void setBufsize(Long bufsize)
    {
        this.bufsize = bufsize;
    }
    public BAdapt getbAdaptiveStrategy()
    {
        return this.bAdaptiveStrategy;
    }
    public void setbAdaptiveStrategy(BAdapt bAdaptiveStrategy)
    {
        this.bAdaptiveStrategy = bAdaptiveStrategy;
    }
    public H264MotionEstimationMethod getMotionEstimationMethod()
    {
        return this.motionEstimationMethod;
    }
    public void setMotionEstimationMethod(H264MotionEstimationMethod motionEstimationMethod)
    {
        this.motionEstimationMethod = motionEstimationMethod;
    }
    public Integer getRcLookahead()
    {
        return this.rcLookahead;
    }
    public void setRcLookahead(Integer rcLookahead)
    {
        this.rcLookahead = rcLookahead;
    }
    public H264SubMe getSubMe()
    {
        return this.subMe;
    }
    public void setSubMe(H264SubMe subMe)
    {
        this.subMe = subMe;
    }
    public List<H264Partition> getPartitions()
    {
        return this.partitions;
    }
    public void setPartitions(List<H264Partition> partitions)
    {
        this.partitions = partitions;
    }
    public Integer getSlices()
    {
        return this.slices;
    }
    public void setSlices(Integer slices)
    {
        this.slices = slices;
    }
    public H264InterlaceMode getInterlaceMode()
    {
        return this.interlaceMode;
    }
    public void setInterlaceMode(H264InterlaceMode interlaceMode)
    {
        this.interlaceMode = interlaceMode;
    }
    public H264Trellis getTrellis()
    {
        return this.trellis;
    }
    public void setTrellis(H264Trellis trellis)
    {
        this.trellis = trellis;
    }

    public Double getMinKeyframeInterval()
    {
        return this.minKeyframeInterval;
    }

    public void setMinKeyframeInterval(Double minKeyframeInterval)
    {
        this.minKeyframeInterval = minKeyframeInterval;
    }

    public Double getMaxKeyframeInterval()
    {
        return this.maxKeyframeInterval;
    }

    public void setMaxKeyframeInterval(Double maxKeyframeInterval)
    {
        this.maxKeyframeInterval = maxKeyframeInterval;
    }

    public PixelFormat getPixelFormat()
    {
        return pixelFormat;
    }
    public void setPixelFormat(PixelFormat pixelFormat)
    {
        this.pixelFormat = pixelFormat;
    }

    public Integer getSceneCutThreshold()
    {
        return this.sceneCutThreshold;
    }

    public void setSceneCutThreshold(Integer sceneCutThreshold)
    {
        this.sceneCutThreshold = sceneCutThreshold;
    }

    public Cea608708SubtitleConfig getCea608708SubtitleConfig()
    {
        return cea608708SubtitleConfig;
    }

    public void setCea608708SubtitleConfig(Cea608708SubtitleConfig cea608708SubtitleConfig)
    {
        this.cea608708SubtitleConfig = cea608708SubtitleConfig;
    }

    public H264NalHrd getNalHrd()
    {
        return nalHrd;
    }

    public void setNalHrd(H264NalHrd nalHrd)
    {
        this.nalHrd = nalHrd;
    }

    public H264BPyramid getbPyramid()
    {
        return bPyramid;
    }

    public void setbPyramid(H264BPyramid bPyramid)
    {
        this.bPyramid = bPyramid;
    }

    public Boolean getOpenGop()
    {
        return this.openGop;
    }

    public void setOpenGop(Boolean openGop)
    {
        this.openGop = openGop;
    }

    public void setAdaptiveQuantizationMode(H264AdaptiveQuantizationMode adaptiveQuantizationMode)
    {
        this.adaptiveQuantizationMode = adaptiveQuantizationMode;
    }

    public H264AdaptiveQuantizationMode getAdaptiveQuantizationMode()
    {
        return this.adaptiveQuantizationMode;
    }

    public void setAdaptiveQuantizationStrength(Double adaptiveQuantizationStrength)
    {
        this.adaptiveQuantizationStrength = adaptiveQuantizationStrength;
    }

    public Double getAdaptiveQuantizationStrength()
    {
        return this.adaptiveQuantizationStrength;
    }

}
