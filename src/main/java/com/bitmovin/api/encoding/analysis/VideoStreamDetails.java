package com.bitmovin.api.encoding.analysis;

/**
 * Created by dmiglar on 8/16/16.
 */
public class VideoStreamDetails extends StreamDetails
{
    private String   fps;
    private Integer width;
    private Integer height;
    private Integer bitrate;

    public String getFps()
    {
        return this.fps;
    }

    public void setFps(String fps)
    {
        this.fps = fps;
    }

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

    public Integer getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Integer bitrate)
    {
        this.bitrate = bitrate;
    }
}
