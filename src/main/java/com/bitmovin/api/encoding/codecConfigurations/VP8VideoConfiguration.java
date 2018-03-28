package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.VP8ArnrType;
import com.bitmovin.api.encoding.codecConfigurations.enums.VP8NoiseSensitivity;
import com.bitmovin.api.encoding.codecConfigurations.enums.VP8Quality;

/**
 * Created by dmoser on 09.02.17.
 */
public class VP8VideoConfiguration extends VideoConfiguration
{
    private Integer lagInFrames;
    private Long maxIntraRate;
    private Integer qpMin;
    private Integer qpMax;
    private Integer rateUndershootPct;
    private Integer rateOvershootPct;
    private Integer cpuUsed;
    private VP8NoiseSensitivity noiseSensitivity;
    private Integer sharpness;
    private VP8Quality quality;
    private Integer staticThresh;
    private Integer arnrMaxFrames;
    private Integer arnrStrength;
    private VP8ArnrType arnrType;
    private Integer crf;

    public Integer getLagInFrames()
    {
        return this.lagInFrames;
    }

    public void setLagInFrames(Integer lagInFrames)
    {
        this.lagInFrames = lagInFrames;
    }

    public Long getMaxIntraRate()
    {
        return this.maxIntraRate;
    }

    public void setMaxIntraRate(Long maxIntraRate)
    {
        this.maxIntraRate = maxIntraRate;
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

    public Integer getRateUndershootPct()
    {
        return this.rateUndershootPct;
    }

    public void setRateUndershootPct(Integer rateUndershootPct)
    {
        this.rateUndershootPct = rateUndershootPct;
    }

    public Integer getRateOvershootPct()
    {
        return this.rateOvershootPct;
    }

    public void setRateOvershootPct(Integer rateOvershootPct)
    {
        this.rateOvershootPct = rateOvershootPct;
    }

    public Integer getCpuUsed()
    {
        return this.cpuUsed;
    }

    public void setCpuUsed(Integer cpuUsed)
    {
        this.cpuUsed = cpuUsed;
    }

    public VP8NoiseSensitivity getNoiseSensitivity()
    {
        return this.noiseSensitivity;
    }

    public void setNoiseSensitivity(VP8NoiseSensitivity noiseSensitivity)
    {
        this.noiseSensitivity = noiseSensitivity;
    }

    public Integer getSharpness()
    {
        return this.sharpness;
    }

    public void setSharpness(Integer sharpness)
    {
        this.sharpness = sharpness;
    }

    public VP8Quality getQuality()
    {
        return this.quality;
    }

    public void setQuality(VP8Quality quality)
    {
        this.quality = quality;
    }

    public Integer getStaticThresh()
    {
        return this.staticThresh;
    }

    public void setStaticThresh(Integer staticThresh)
    {
        this.staticThresh = staticThresh;
    }

    public Integer getArnrMaxFrames()
    {
        return this.arnrMaxFrames;
    }

    public void setArnrMaxFrames(Integer arnrMaxFrames)
    {
        this.arnrMaxFrames = arnrMaxFrames;
    }

    public Integer getArnrStrength()
    {
        return this.arnrStrength;
    }

    public void setArnrStrength(Integer arnrStrength)
    {
        this.arnrStrength = arnrStrength;
    }

    public VP8ArnrType getArnrType()
    {
        return this.arnrType;
    }

    public void setArnrType(VP8ArnrType arnrType)
    {
        this.arnrType = arnrType;
    }

    public Integer getCrf()
    {
        return this.crf;
    }

    public void setCrf(Integer crf)
    {
        this.crf = crf;
    }
}
