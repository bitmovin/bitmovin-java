package com.bitmovin.api.encoding.encodings.muxing.information;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MuxingInformationAudioTrack
{
    private Integer index;
    private String codec;
    private String codecIso;
    private Long bitRate;
    private Long rate;
    private Integer sampleRate;
    private Integer channels;
    private Double duration;

    public Integer getIndex()
    {
        return this.index;
    }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public String getCodecIso()
    {
        return this.codecIso;
    }

    public void setCodecIso(String codecIso)
    {
        this.codecIso = codecIso;
    }

    public Long getBitRate()
    {
        return this.bitRate;
    }

    public void setBitRate(Long bitRate)
    {
        this.bitRate = bitRate;
    }

    public Integer getSampleRate()
    {
        return this.sampleRate;
    }

    public void setSampleRate(Integer sampleRate)
    {
        this.sampleRate = sampleRate;
    }

    public Integer getChannels()
    {
        return this.channels;
    }

    public void setChannels(Integer channels)
    {
        this.channels = channels;
    }


    public Long getRate()
    {
        return this.rate;
    }

    public void setRate(Long rate)
    {
        this.rate = rate;
    }
    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;

    }
}
