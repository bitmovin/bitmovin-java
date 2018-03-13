package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.SourceChannelType;

public class SourceChannel
{
    private Double gain;
    private SourceChannelType type;
    private Integer channelNumber;

    public SourceChannel()
    {

    }

    public SourceChannel(SourceChannelType type, Integer channelNumber)
    {
        this.type = type;
        this.channelNumber = channelNumber;
    }

    public SourceChannel(Double gain, SourceChannelType type, Integer channelNumber)
    {
        this.gain = gain;
        this.type = type;
        this.channelNumber = channelNumber;
    }

    public Double getGain()
    {
        return gain;
    }

    public void setGain(Double gain)
    {
        this.gain = gain;
    }

    public SourceChannelType getType()
    {
        return type;
    }

    public void setType(SourceChannelType type)
    {
        this.type = type;
    }

    public Integer getChannelNumber()
    {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber)
    {
        this.channelNumber = channelNumber;
    }
}
