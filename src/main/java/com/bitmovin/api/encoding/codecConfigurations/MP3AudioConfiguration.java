package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.ChannelLayout;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;

public class MP3AudioConfiguration extends AudioConfiguration
{
    private ChannelLayout channelLayout;

    public MP3AudioConfiguration()
    {
        this.setType(ConfigType.MP3);
    }

    public ChannelLayout getChannelLayout()
    {
        return channelLayout;
    }

    public void setChannelLayout(ChannelLayout channelLayout)
    {
        this.channelLayout = channelLayout;
    }
}
