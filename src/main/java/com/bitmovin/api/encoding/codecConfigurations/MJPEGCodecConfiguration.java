package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.PixelFormat;

public class MJPEGCodecConfiguration extends CodecConfig
{
    private Float rate;
    private Integer qScale;
    private PixelFormat pixelFormat;

    public Float getRate()
    {
        return rate;
    }

    public void setRate(Float rate)
    {
        this.rate = rate;
    }

    public Integer getqScale()
    {
        return qScale;
    }

    public void setqScale(Integer qScale)
    {
        this.qScale = qScale;
    }

    public PixelFormat getPixelFormat()
    {
        return pixelFormat;
    }

    public void setPixelFormat(PixelFormat pixelFormat)
    {
        this.pixelFormat = pixelFormat;
    }
}
