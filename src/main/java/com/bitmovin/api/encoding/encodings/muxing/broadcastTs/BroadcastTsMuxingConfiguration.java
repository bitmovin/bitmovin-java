package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import java.util.ArrayList;
import java.util.List;

public class BroadcastTsMuxingConfiguration
{
    private TransportConfiguration transport;

    private ProgramConfiguration program;

    private List<VideoInputStreamConfiguration> videoStreams;

    private List<AudioInputStreamConfiguration> audioStreams;

    public BroadcastTsMuxingConfiguration()
    {
        this.transport = new TransportConfiguration();
        this.program = new ProgramConfiguration();
        this.videoStreams = new ArrayList<>();
        this.audioStreams = new ArrayList<>();
    }

    public BroadcastTsMuxingConfiguration(
            TransportConfiguration transportConfiguration,
            ProgramConfiguration programConfiguration,
            VideoInputStreamConfiguration videoInputStreamConfiguration,
            AudioInputStreamConfiguration audioInputStreamConfiguration)
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

    public TransportConfiguration getTransport()
    {
        return this.transport;
    }

    public void setTransport(TransportConfiguration transport)
    {
        this.transport = transport;
    }

    public ProgramConfiguration getProgram()
    {
        return this.program;
    }

    public void setProgram(ProgramConfiguration program)
    {
        this.program = program;
    }

    public List<VideoInputStreamConfiguration> getVideoStreams()
    {
        return this.videoStreams;
    }

    public void setVideoStreams(List<VideoInputStreamConfiguration> videoStreams)
    {
        this.videoStreams = videoStreams;
    }

    public List<AudioInputStreamConfiguration> getAudioStreams()
    {
        return this.audioStreams;
    }

    public void setAudioStreams(List<AudioInputStreamConfiguration> audioStreams)
    {
        this.audioStreams = audioStreams;
    }
}
