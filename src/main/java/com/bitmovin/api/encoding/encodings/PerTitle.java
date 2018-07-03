package com.bitmovin.api.encoding.encodings;

public class PerTitle
{
    private Integer minBitrate;
    private Integer maxBitrate;

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

}
