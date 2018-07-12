package com.bitmovin.api.encoding.encodings;

public class PerTitle
{
    private Integer minBitrate;
    private Integer maxBitrate;

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

    public AutoRepresentation getAutoRepresentations()
    {
        return this.autoRepresentations;
    }

    public void setAutoRepresentations(AutoRepresentation autoRepresentations)
    {
        this.autoRepresentations = autoRepresentations;
    }
}
