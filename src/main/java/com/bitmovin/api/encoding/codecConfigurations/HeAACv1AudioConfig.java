package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.ChannelLayout;
import com.bitmovin.api.encoding.codecConfigurations.enums.ConfigType;
import com.bitmovin.api.encoding.codecConfigurations.enums.SBRSignaling;

public class HeAACv1AudioConfig extends AudioConfiguration
{
    private ChannelLayout channelLayout;

    private Integer volumeAdjust;

    private boolean normalize;

    private SBRSignaling signaling;

    public HeAACv1AudioConfig()
    {
        this.setType(ConfigType.HE_AAC_V1);
    }

    public ChannelLayout getChannelLayout()
    {
        return this.channelLayout;
    }

    public void setChannelLayout(ChannelLayout channelLayout)
    {
        this.channelLayout = channelLayout;
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

    public SBRSignaling getSignaling() { return this.signaling; }

    public void setSignaling(SBRSignaling signaling) { this.signaling = signaling; }

}
