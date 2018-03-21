package com.bitmovin.api.encoding.filters;

import java.util.ArrayList;
import java.util.List;

public class AudioMixChannel
{
    private Integer channelNumber;
    private List<SourceChannel> sourceChannels = new ArrayList<>();

    public AudioMixChannel()
    {
    }

    public AudioMixChannel(Integer channelNumber, List<SourceChannel> sourceChannels)
    {
        this.channelNumber = channelNumber;
        this.sourceChannels = sourceChannels;
    }

    public Integer getChannelNumber()
    {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber)
    {
        this.channelNumber = channelNumber;
    }

    public List<SourceChannel> getSourceChannels()
    {
        return sourceChannels;
    }

    public void setSourceChannels(List<SourceChannel> sourceChannels)
    {
        this.sourceChannels = sourceChannels;
    }
}
