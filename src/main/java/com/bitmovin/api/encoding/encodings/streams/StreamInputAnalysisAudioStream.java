package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Roland Kersche on 26.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamInputAnalysisAudioStream
{
    private String id;
    private Integer position;
    private Long duration;
    private String codec;
    private Integer sampleRate;
    private Long bitrate;
    private String channelFormat;
    private String language;
    private Boolean hearingImpaired;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Long getDuration()
    {
        return this.duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public Integer getSampleRate()
    {
        return this.sampleRate;
    }

    public void setSampleRate(Integer sampleRate)
    {
        this.sampleRate = sampleRate;
    }

    public Long getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }

    public String getChannelFormat()
    {
        return this.channelFormat;
    }

    public void setChannelFormat(String channelFormat)
    {
        this.channelFormat = channelFormat;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Boolean getHearingImpaired()
    {
        return this.hearingImpaired;
    }

    public void setHearingImpaired(Boolean hearingImpaired)
    {
        this.hearingImpaired = hearingImpaired;
    }
}
