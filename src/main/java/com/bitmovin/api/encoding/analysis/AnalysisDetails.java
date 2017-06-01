package com.bitmovin.api.encoding.analysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by dmiglar on 8/16/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisDetails
{
    private List<VideoStreamDetails>    videoStreams;
    private List<AudioStreamDetails>    audioStreams;
    private List<MetaStreamDetails>     metaStreams;
    private List<SubtitleStreamDetails> subtitleStreams;

    public List<VideoStreamDetails> getVideoStreams()
    {
        return this.videoStreams;
    }

    public void setVideoStreams(List<VideoStreamDetails> videoStreams)
    {
        this.videoStreams = videoStreams;
    }

    public List<AudioStreamDetails> getAudioStreams()
    {
        return this.audioStreams;
    }

    public void setAudioStreams(List<AudioStreamDetails> audioStreams)
    {
        this.audioStreams = audioStreams;
    }

    public List<MetaStreamDetails> getMetaStreams()
    {
        return this.metaStreams;
    }

    public void setMetaStreams(List<MetaStreamDetails> metaStreams)
    {
        this.metaStreams = metaStreams;
    }

    public List<SubtitleStreamDetails> getSubtitleStreams()
    {
        return this.subtitleStreams;
    }

    public void setSubtitleStreams(List<SubtitleStreamDetails> subtitleStreams)
    {
        this.subtitleStreams = subtitleStreams;
    }

}
