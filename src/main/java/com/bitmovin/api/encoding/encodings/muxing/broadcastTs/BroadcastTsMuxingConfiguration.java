package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import java.util.ArrayList;
import java.util.List;

public class BroadcastTsMuxingConfiguration
{
    private BroadcastTsTransportConfiguration transport;

    private BroadcastProgramConfiguration program;

    private List<BroadcastTsVideoInputStreamConfiguration> videoStreams;

    private List<BroadcastTsAudioInputStreamConfiguration> audioStreams;

    public BroadcastTsMuxingConfiguration()
    {
        this.transport = new BroadcastTsTransportConfiguration();
        this.program = new BroadcastProgramConfiguration();
        this.videoStreams = new ArrayList<>();
        this.audioStreams = new ArrayList<>();
    }

    public BroadcastTsMuxingConfiguration(
            BroadcastTsTransportConfiguration transportConfiguration,
            BroadcastProgramConfiguration programConfiguration,
            BroadcastTsVideoInputStreamConfiguration videoInputStreamConfiguration,
            BroadcastTsAudioInputStreamConfiguration audioInputStreamConfiguration)
    {
        super();
        if (transportConfiguration != null)
            this.transport = transportConfiguration;
        if (programConfiguration != null)
            this.program = programConfiguration;
        this.videoStreams = new ArrayList<>();
        this.audioStreams = new ArrayList<>();
        if (videoInputStreamConfiguration != null)
            this.videoStreams.add(videoInputStreamConfiguration);
        if (audioInputStreamConfiguration != null)
            this.audioStreams.add(audioInputStreamConfiguration);
    }

    public BroadcastTsTransportConfiguration getTransport()
    {
        return this.transport;
    }

    public void setTransport(BroadcastTsTransportConfiguration transport)
    {
        this.transport = transport;
    }

    public BroadcastProgramConfiguration getProgram()
    {
        return this.program;
    }

    public void setProgram(BroadcastProgramConfiguration program)
    {
        this.program = program;
    }

    public List<BroadcastTsVideoInputStreamConfiguration> getVideoStreams()
    {
        return this.videoStreams;
    }

    public void setVideoStreams(List<BroadcastTsVideoInputStreamConfiguration> videoStreams)
    {
        this.videoStreams = videoStreams;
    }

    public List<BroadcastTsAudioInputStreamConfiguration> getAudioStreams()
    {
        return this.audioStreams;
    }

    public void setAudioStreams(List<BroadcastTsAudioInputStreamConfiguration> audioStreams)
    {
        this.audioStreams = audioStreams;
    }
}
