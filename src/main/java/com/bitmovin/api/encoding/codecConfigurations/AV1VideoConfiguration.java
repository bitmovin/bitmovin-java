package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.*;

/**
 * Created by
 * Al·lodi Jutgla Serrat [allodi.serrat@bitmovin.com]
 * on 16.08.18.
 */


public class AV1VideoConfiguration extends VideoConfiguration {


    private Integer lagInFrames;
    private Integer minQ;
    private Integer maxQ;
    private Integer undershootPct;
    private Integer overshootPct;
    private Long clientBufferSize;
    private Long clientOptimalBufferSize;
    private Integer tileColumns;
    private Integer tileRows;
    private Boolean isAutomaticAltRefFramesEnabled;
    private Integer arnrMaxFrames;
    private Integer arnrStrength;
    private Long maxIntraRate;
    private Boolean isLossless;
    private Boolean isFrameParallel;
    private Integer sharpness;
    private Boolean isFrameboostEnabled;
    private Boolean noiseSensitivity;
    private Integer minGfInterval;
    private Integer maxGfInterval;
    private Integer numTileGroups;
    private Integer mtuSize;


    public Integer getLagInFrames() { return this.lagInFrames; }

    public void setLagInFrames(Integer lagInFrames) { this.lagInFrames = lagInFrames; }

    public Integer getMinQ() { return this.minQ; }

    public void setMinQ(Integer minQ) { this.minQ = minQ; }

    public Integer getMaxQ() { return this.maxQ; }

    public void setMaxQ(Integer maxQ) { this.maxQ = maxQ; }

    public Integer getUndershootPct() { return undershootPct; }

    public void setUndershootPct(Integer undershootPct) { this.undershootPct = undershootPct; }

    public Integer getOvershootPct() { return overshootPct; }

    public void setOvershootPct(Integer overshootPct) { this.overshootPct = overshootPct; }

    public Long getClientBufferSize() { return clientBufferSize; }

    public void setClientBufferSize(Long clientBufferSize) { this.clientBufferSize = clientBufferSize; }

    public Long getClientOptimalBufferSize() { return clientOptimalBufferSize; }

    public void setClientOptimalBufferSize(Long clientOptimalBufferSize) { this.clientOptimalBufferSize = clientOptimalBufferSize; }

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

    public Boolean getAutomaticAltRefFramesEnabled() { return isAutomaticAltRefFramesEnabled; }

    public void setAutomaticAltRefFramesEnabled(Boolean automaticAltRefFramesEnabled) { isAutomaticAltRefFramesEnabled = automaticAltRefFramesEnabled; }

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

    public Long getMaxIntraRate()
    {
        return this.maxIntraRate;
    }

    public void setMaxIntraRate(Long maxIntraRate)
    {
        this.maxIntraRate = maxIntraRate;
    }

    public Boolean getLossless() { return isLossless; }

    public void setLossless(Boolean lossless) { isLossless = lossless; }

    public Boolean getFrameParallel() { return isFrameParallel; }

    public void setFrameParallel(Boolean frameParallel) { isFrameParallel = frameParallel; }

    public Integer getSharpness()
    {
        return this.sharpness;
    }

    public void setSharpness(Integer sharpness)
    {
        this.sharpness = sharpness;
    }

    public Boolean getFrameboostEnabled() { return isFrameboostEnabled; }

    public void setFrameboostEnabled(Boolean frameboostEnabled) { isFrameboostEnabled = frameboostEnabled; }

    public Boolean getNoiseSensitivity()
    {
        return this.noiseSensitivity;
    }

    public void setNoiseSensitivity(Boolean noiseSensitivity)
    {
        this.noiseSensitivity = noiseSensitivity;
    }

    public Integer getMinGfInterval() { return minGfInterval; }

    public void setMinGfInterval(Integer minGfInterval) { this.minGfInterval = minGfInterval; }

    public Integer getMaxGfInterval() { return maxGfInterval; }

    public void setMaxGfInterval(Integer maxGfInterval) { this.maxGfInterval = maxGfInterval; }

    public Integer getNumTileGroups() { return numTileGroups; }

    public void setNumTileGroups(Integer numTileGroups) { this.numTileGroups = numTileGroups; }

    public Integer getMtuSize() { return mtuSize; }

    public void setMtuSize(Integer mtuSize) { this.mtuSize = mtuSize; }
}
