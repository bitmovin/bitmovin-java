package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.ChannelLayout;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class AACAudioConfig extends AudioConfiguration
{
    private ChannelLayout channelLayout;

    private Integer volumeAdjust;

    private boolean normalize;

    public AACAudioConfig()
    {
        this.setType(ConfigType.AAC);
    }

    public Integer getVolumeAdjust()
    {
        return this.volumeAdjust;
    }
    public void setVolumeAdjust(Integer volumeAdjust)
    {
        this.volumeAdjust = volumeAdjust;
    }
    public boolean isNormalize()
    {
        return this.normalize;
    }

    public void setNormalize(boolean normalize)
    {
        this.normalize = normalize;
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
