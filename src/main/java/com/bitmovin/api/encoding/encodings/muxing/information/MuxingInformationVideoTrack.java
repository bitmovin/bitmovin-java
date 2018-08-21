package com.bitmovin.api.encoding.encodings.muxing.information;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MuxingInformationVideoTrack
{
    private Integer index;
    private String codec;
    private String codecIso;
    private Long bitRate;
    private Long rate;
    private String pixelFormat;
    private String frameMode;
    private Integer frameWidth;
    private Integer frameHeight;
    private String frameRate;
    private Double startTime;
    private Double duration;
    private Long numberOfFrames;

    public Integer getIndex()
    {
        return index;
    }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

    public String getCodec()
    {
        return codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public String getCodecIso()
    {
        return codecIso;
    }

    public void setCodecIso(String codecIso)
    {
        this.codecIso = codecIso;
    }

    public Long getBitRate()
    {
        return bitRate;
    }

    public void setBitRate(Long bitRate)
    {
        this.bitRate = bitRate;
    }

    public String getPixelFormat()
    {
        return pixelFormat;
    }

    public void setPixelFormat(String pixelFormat)
    {
        this.pixelFormat = pixelFormat;
    }

    public String getFrameMode()
    {
        return frameMode;
    }

    public void setFrameMode(String frameMode)
    {
        this.frameMode = frameMode;
    }

    public Integer getFrameWidth()
    {
        return frameWidth;
    }

    public void setFrameWidth(Integer frameWidth)
    {
        this.frameWidth = frameWidth;
    }

    public Integer getFrameHeight()
    {
        return frameHeight;
    }

    public void setFrameHeight(Integer frameHeight)
    {
        this.frameHeight = frameHeight;
    }

    public String getFrameRate()
    {
        return frameRate;
    }

    public void setFrameRate(String frameRate)
    {
        this.frameRate = frameRate;
    }

    public Double getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Double startTime)
    {
        this.startTime = startTime;
    }

    public Double getDuration()
    {
        return duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    public Long getNumberOfFrames()
    {
        return numberOfFrames;
    }

    public void setNumberOfFrames(Long numberOfFrames)
    {
        this.numberOfFrames = numberOfFrames;
    }

    public Long getRate()
    {
        return this.rate;
    }

    public void setRate(Long rate)
    {
        this.rate = rate;
    }
}
