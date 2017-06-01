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

    private LevelH265 level;


    private int rcLookahead;


    private BAdapt bAdapt = BAdapt.FULL;


    private MaxCTUSize maxCTUSize = MaxCTUSize.S64;


    private TuIntraDepth tuIntraDepth = TuIntraDepth.D1;


    private TuInterDepth tuInterDepth = TuInterDepth.D1;


    private MotionSearch motionSearch = MotionSearch.HEX;

    private Integer subMe;

    private Integer motionSearchRange;

    private boolean weightPredictionOnPSlice;

    private boolean weightPredictionOnBSlice;

    private boolean sao;

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

    public int getBframes()
    {
        return this.bframes;
    }

    public void setBframes(int bframes)
    {
        this.bframes = bframes;
    }

    public int getRefFrames()
    {
        return this.refFrames;
    }

    public void setRefFrames(int refFrames)
    {
        this.refFrames = refFrames;
    }

    public int getQpMin()
    {
        return this.qpMin;
    }

    public void setQpMin(int qpMin)
    {
        this.qpMin = qpMin;
    }

    public int getQpMax()
    {
        return this.qpMax;
    }

    public void setQpMax(int qpMax)
    {
        this.qpMax = qpMax;
    }

    public long getMaxBitrate()
    {
        return this.maxBitrate;
    }

    public void setMaxBitrate(long maxBitrate)
    {
        this.maxBitrate = maxBitrate;
    }

    public long getMinBitrate()
    {
        return this.minBitrate;
    }

    public void setMinBitrate(long minBitrate)
    {
        this.minBitrate = minBitrate;
    }

    public LevelH265 getLevel()
    {
        return this.level;
    }

    public void setLevel(LevelH265 level)
    {
        this.level = level;
    }

    public int getRcLookahead()
    {
        return this.rcLookahead;
    }

    public void setRcLookahead(int rcLookahead)
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

    public int getSubMe()
    {
        return this.subMe;
    }

    public void setSubMe(int subMe)
    {
        this.subMe = subMe;
    }

    public int getMotionSearchRange()
    {
        return this.motionSearchRange;
    }

    public void setMotionSearchRange(int motionSearchRange)
    {
        this.motionSearchRange = motionSearchRange;
    }

    public boolean isWeightPredictionOnPSlice()
    {
        return this.weightPredictionOnPSlice;
    }

    public void setWeightPredictionOnPSlice(boolean weightPredictionOnPSlice)
    {
        this.weightPredictionOnPSlice = weightPredictionOnPSlice;
    }

    public boolean isWeightPredictionOnBSlice()
    {
        return this.weightPredictionOnBSlice;
    }

    public void setWeightPredictionOnBSlice(boolean weightPredictionOnBSlice)
    {
        this.weightPredictionOnBSlice = weightPredictionOnBSlice;
    }

    public boolean isSao()
    {
        return this.sao;
    }

    public void setSao(boolean sao)
    {
        this.sao = sao;
    }
}
