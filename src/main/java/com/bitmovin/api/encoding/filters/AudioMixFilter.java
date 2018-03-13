package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.AudioMixChannelLayout;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AudioMixFilter extends Filter
{
    private String name;
    private String description;
    private AudioMixChannelLayout channelLayout;
    private List<AudioMixChannel> audioMixChannels = new ArrayList<>();

    public AudioMixFilter()
    {
        super();
        this.setType(FilterType.AUDIO_MIX);
    }

    public AudioMixFilter(String name,
                          String description,
                          AudioMixChannelLayout channelLayout,
                          List<AudioMixChannel> audioMixChannels)
    {
        this();
        this.name = name;
        this.description = description;
        this.channelLayout = channelLayout;
        this.audioMixChannels = audioMixChannels;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public AudioMixChannelLayout getChannelLayout()
    {
        return channelLayout;
    }

    public void setChannelLayout(AudioMixChannelLayout channelLayout)
    {
        this.channelLayout = channelLayout;
    }

    public List<AudioMixChannel> getAudioMixChannels()
    {
        return audioMixChannels;
    }

    public void setAudioMixChannels(List<AudioMixChannel> audioMixChannels)
    {
        this.audioMixChannels = audioMixChannels;
    }
}
