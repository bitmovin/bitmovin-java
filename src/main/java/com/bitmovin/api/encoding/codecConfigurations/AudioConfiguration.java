package com.bitmovin.api.encoding.codecConfigurations;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class AudioConfiguration extends CodecConfig
{
    private Long bitrate;

    private Float rate;

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
}