package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.PixelFormat;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class VideoConfiguration extends CodecConfig
{


    private Integer width;

    private Integer height;

    private Long bitrate;

    private Float rate;

    private Integer minGop;

    private Integer maxGop;

    private ColorConfig colorConfig;

    private PixelFormat pixelFormat;


    public Integer getWidth()
    {
        return this.width;
    }
    public void setWidth(Integer width)
    {
        this.width = width;
    }
    public Integer getHeight()
    {
        return this.height;
    }
    public void setHeight(Integer height)
    {
        this.height = height;
    }
    public Long getBitrate()
    {
        return this.bitrate;
    }
    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }
    public Float getRate()
    {
        return this.rate;
    }
    public void setRate(Float rate)
    {
        this.rate = rate;
    }
    public Integer getMinGop()
    {
        return this.minGop;
    }
    public void setMinGop(Integer minGop)
    {
        this.minGop = minGop;
    }
    public Integer getMaxGop()
    {
        return this.maxGop;
    }
    public void setMaxGop(Integer maxGop)
    {
        this.maxGop = maxGop;
    }
    public ColorConfig getColorConfig() { return this.colorConfig; }
    public void setColorConfig(ColorConfig colorConfig) { this.colorConfig = colorConfig; }
    public PixelFormat getPixelFormat() { return this.pixelFormat; }
    public void setPixelFormat(PixelFormat pixelFormat) { this.pixelFormat = pixelFormat; }
}
