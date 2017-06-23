package com.bitmovin.api.examples.util;

/**
 * Created by Roland Kersche on 22.06.17.
 */
public class H264Representation
{
    private Integer width;
    private Integer heigth;
    private Float rate;
    private Long bitrate;

    public H264Representation(Integer width, Integer heigth, Float rate, Long bitrate)
    {
        this.width = width;
        this.heigth = heigth;
        this.rate = rate;
        this.bitrate = bitrate;
    }

    public Integer getWidth()
    {
        return this.width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeigth()
    {
        return this.heigth;
    }

    public void setHeigth(Integer heigth)
    {
        this.heigth = heigth;
    }

    public Float getRate()
    {
        return this.rate;
    }

    public void setRate(Float rate)
    {
        this.rate = rate;
    }

    public Long getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }
}
