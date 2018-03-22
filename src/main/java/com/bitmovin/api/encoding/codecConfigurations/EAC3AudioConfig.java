package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.ChannelLayout;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class EAC3AudioConfig extends AudioConfiguration
{
    private ChannelLayout channelLayout;

    public EAC3AudioConfig()
    {
        this.setType(ConfigType.EAC3);
    }

    public ChannelLayout getChannelLayout()
    {
        return this.channelLayout;
    }

    public void setChannelLayout(ChannelLayout channelLayout)
    {
        this.channelLayout = channelLayout;
    }
}
