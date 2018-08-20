package com.bitmovin.api.encoding.encodings;

public class PerTitleConfiguration
{
    private Integer minBitrate;
    private Integer maxBitrate;
    private Double minBitrateStepSize;
    private Double maxBitrateStepSize;
    private AutoRepresentation autoRepresentations;

    public Integer getMinBitrate()
    {
        return this.minBitrate;
    }

    public void setMinBitrate(Integer minBitrate)
    {
        this.minBitrate = minBitrate;
    }

    public Integer getMaxBitrate()
    {
        return this.maxBitrate;
    }

    public void setMaxBitrate(Integer maxBitrate)
    {
        this.maxBitrate = maxBitrate;
    }

    public Double getMinBitrateStepSize()
    {
        return this.minBitrateStepSize;
    }

    public void setMinBitrateStepSize(Double minBitrateStepSize)
    {
        this.minBitrateStepSize = minBitrateStepSize;
    }

    public Double getMaxBitrateStepSize()
    {
        return this.maxBitrateStepSize;
    }

    public void setMaxBitrateStepSize(Double maxBitrateStepSize)
    {
        this.maxBitrateStepSize = maxBitrateStepSize;
    }

    public AutoRepresentation getAutoRepresentations()
    {
        return this.autoRepresentations;
    }

    public void setAutoRepresentations(AutoRepresentation autoRepresentations)
    {
        this.autoRepresentations = autoRepresentations;
    }

}
