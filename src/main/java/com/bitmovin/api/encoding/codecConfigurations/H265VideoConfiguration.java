package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.*;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class H265VideoConfiguration extends VideoConfiguration
{

    private ProfileH265 profile;

    private Float crf;

    private Integer bframes;


    private Integer refFrames;


    private Integer qpMin;

    private Integer qpMax;

    private Long maxBitrate;

    private Long minBitrate;

    private Long bufsize;

    private LevelH265 level;


    private Integer rcLookahead;


    private BAdapt bAdapt = BAdapt.FULL;


    private MaxCTUSize maxCTUSize = MaxCTUSize.S64;


    private TuIntraDepth tuIntraDepth = TuIntraDepth.D1;


    private TuInterDepth tuInterDepth = TuInterDepth.D1;


    private MotionSearch motionSearch = MotionSearch.HEX;

    private Integer subMe;

    private Integer motionSearchRange;

    private Boolean weightPredictionOnPSlice;

    private Boolean weightPredictionOnBSlice;

    private Boolean sao;

    public H265VideoConfiguration()
    {
        this.setType(ConfigType.H265);
    }

    public ProfileH265 getProfile()
    {
        return this.profile;
    }

    public void setProfile(ProfileH265 profile)
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

    public Long getBufsize() { return this.bufsize; }

    public void setBufsize(Long bufsize) { this.bufsize = bufsize; }

    public LevelH265 getLevel()
    {
        return this.level;
    }

    public void setLevel(LevelH265 level)
    {
        this.level = level;
    }

    public Integer getRcLookahead()
    {
        return this.rcLookahead;
    }

    public void setRcLookahead(Integer rcLookahead)
    {
        this.rcLookahead = rcLookahead;
    }

    public BAdapt getbAdapt()
    {
        return this.bAdapt;
    }

    public void setbAdapt(BAdapt bAdapt)
    {
        this.bAdapt = bAdapt;
    }

    public MaxCTUSize getMaxCTUSize()
    {
        return this.maxCTUSize;
    }

    public void setMaxCTUSize(MaxCTUSize maxCTUSize)
    {
        this.maxCTUSize = maxCTUSize;
    }

    public TuIntraDepth getTuIntraDepth()
    {
        return this.tuIntraDepth;
    }

    public void setTuIntraDepth(TuIntraDepth tuIntraDepth)
    {
        this.tuIntraDepth = tuIntraDepth;
    }

    public TuInterDepth getTuInterDepth()
    {
        return this.tuInterDepth;
    }

    public void setTuInterDepth(TuInterDepth tuInterDepth)
    {
        this.tuInterDepth = tuInterDepth;
    }

    public MotionSearch getMotionSearch()
    {
        return this.motionSearch;
    }

    public void setMotionSearch(MotionSearch motionSearch)
    {
        this.motionSearch = motionSearch;
    }

    public Integer getSubMe()
    {
        return this.subMe;
    }

    public void setSubMe(Integer subMe)
    {
        this.subMe = subMe;
    }

    public Integer getMotionSearchRange()
    {
        return this.motionSearchRange;
    }

    public void setMotionSearchRange(Integer motionSearchRange)
    {
        this.motionSearchRange = motionSearchRange;
    }

    public Boolean getWeightPredictionOnPSlice()
    {
        return this.weightPredictionOnPSlice;
    }

    public void setWeightPredictionOnPSlice(Boolean weightPredictionOnPSlice)
    {
        this.weightPredictionOnPSlice = weightPredictionOnPSlice;
    }

    public Boolean getWeightPredictionOnBSlice()
    {
        return this.weightPredictionOnBSlice;
    }

    public void setWeightPredictionOnBSlice(Boolean weightPredictionOnBSlice)
    {
        this.weightPredictionOnBSlice = weightPredictionOnBSlice;
    }

    public Boolean getSao()
    {
        return this.sao;
    }

    public void setSao(Boolean sao)
    {
        this.sao = sao;
    }
}
