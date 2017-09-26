package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

/**
 * Created by Roland Kersche on 26.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamInputAnalysisDetails
{
    private String formatName;
    private Double startTime;
    private Double duration;
    private Long size;
    private Long bitrate;
    private Map<String, Object> tags;
    private List<StreamInputAnalysisVideoStream> videoStreams;
    private List<StreamInputAnalysisAudioStream> audioStreams;
    private List<StreamInputAnalysisMetaStream> metaStreams;

    public List<StreamInputAnalysisVideoStream> getVideoStreams()
    {
        return this.videoStreams;
    }

    public void setVideoStreams(List<StreamInputAnalysisVideoStream> videoStreams)
    {
        this.videoStreams = videoStreams;
    }

    public List<StreamInputAnalysisAudioStream> getAudioStreams()
    {
        return this.audioStreams;
    }

    public void setAudioStreams(List<StreamInputAnalysisAudioStream> audioStreams)
    {
        this.audioStreams = audioStreams;
    }

    public List<StreamInputAnalysisMetaStream> getMetaStreams()
    {
        return this.metaStreams;
    }

    public void setMetaStreams(List<StreamInputAnalysisMetaStream> metaStreams)
    {
        this.metaStreams = metaStreams;
    }

    public List<StreamInputAnalysisSubtitleStream> getSubtitleStreams()
    {
        return this.subtitleStreams;
    }

    public void setSubtitleStreams(List<StreamInputAnalysisSubtitleStream> subtitleStreams)
    {
        this.subtitleStreams = subtitleStreams;
    }

    private List<StreamInputAnalysisSubtitleStream> subtitleStreams;

    public String getFormatName()
    {
        return this.formatName;
    }

    public void setFormatName(String formatName)
    {
        this.formatName = formatName;
    }

    public Double getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(Double startTime)
    {
        this.startTime = startTime;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    public Long getSize()
    {
        return this.size;
    }

    public void setSize(Long size)
    {
        this.size = size;
    }

    public Long getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }

    public Map<String, Object> getTags()
    {
        return this.tags;
    }

    public void setTags(Map<String, Object> tags)
    {
        this.tags = tags;
    }
}
