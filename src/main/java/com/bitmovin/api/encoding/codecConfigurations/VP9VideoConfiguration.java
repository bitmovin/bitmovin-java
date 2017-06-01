package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.VP9AqMode;
import com.bitmovin.api.encoding.codecConfigurations.enums.VP9ArnrType;
import com.bitmovin.api.encoding.codecConfigurations.enums.VP9Quality;


/**
 * Created by dmoser on 09.02.17.
 */
public class VP9VideoConfiguration extends VideoConfiguration
{
    private Integer lagInFrames;
    private Integer tileColumns;
    private Integer tileRows;
    private Boolean frameParallel;
    private Long maxIntraRate;
    private Integer qpMin;
    private Integer qpMax;
    private Integer crf;
    private Integer rateUndershootPct;
    private Integer rateOvershootPct;
    private Integer cpuUsed;
    private VP9Quality quality;
    private Boolean noiseSensitivity;
    private Boolean lossless;
    private Integer staticThresh;
    private VP9AqMode aqMode;
    private Integer arnrMaxFrames;
    private Integer arnrStrength;
    private VP9ArnrType arnrType;

    public Integer getLagInFrames()
    {
        return this.lagInFrames;
    }

    public void setLagInFrames(Integer lagInFrames)
    {
        this.lagInFrames = lagInFrames;
    }

    public Integer getTileColumns()
    {
        return this.tileColumns;
    }

    public void setTileColumns(Integer tileColumns)
    {
        this.tileColumns = tileColumns;
    }

    public Integer getTileRows()
    {
        return this.tileRows;
    }

    public void setTileRows(Integer tileRows)
    {
        this.tileRows = tileRows;
    }

    public Boolean getFrameParallel()
    {
        return this.frameParallel;
    }

    public void setFrameParallel(Boolean frameParallel)
    {
        this.frameParallel = frameParallel;
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

    public Integer getCrf()
    {
        return this.crf;
    }

    public void setCrf(Integer crf)
    {
        this.crf = crf;
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

    public VP9Quality getQuality()
    {
        return this.quality;
    }

    public void setQuality(VP9Quality quality)
    {
        this.quality = quality;
    }

    public Boolean getNoiseSensitivity()
    {
        return this.noiseSensitivity;
    }

    public void setNoiseSensitivity(Boolean noiseSensitivity)
    {
        this.noiseSensitivity = noiseSensitivity;
    }

    public Boolean getLossless()
    {
        return this.lossless;
    }

    public void setLossless(Boolean lossless)
    {
        this.lossless = lossless;
    }

    public Integer getStaticThresh()
    {
        return this.staticThresh;
    }

    public void setStaticThresh(Integer staticThresh)
    {
        this.staticThresh = staticThresh;
    }

    public VP9AqMode getAqMode()
    {
        return this.aqMode;
    }

    public void setAqMode(VP9AqMode aqMode)
    {
        this.aqMode = aqMode;
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

    public VP9ArnrType getArnrType()
    {
        return this.arnrType;
    }

    public void setArnrType(VP9ArnrType arnrType)
    {
        this.arnrType = arnrType;
    }
}
