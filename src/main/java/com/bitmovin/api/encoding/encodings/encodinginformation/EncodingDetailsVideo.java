package com.bitmovin.api.encoding.encodings.encodinginformation;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by doweinberger on 8/4/16.
 */

@JsonTypeName("VIDEO")
public class EncodingDetailsVideo extends EncodingDetails
{
    private int height;
    private int width;
    private String fps;

    public EncodingDetailsVideo()
    {
        this.setType(EncodingDetailsType.VIDEO);
    }

    public int getHeight()
    {
        return this.height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public String getFps()
    {
        return this.fps;
    }

    public void setFps(String fps)
    {
        this.fps = fps;
    }
}
