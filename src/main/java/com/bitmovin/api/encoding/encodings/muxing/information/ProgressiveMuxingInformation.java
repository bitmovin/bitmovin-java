package com.bitmovin.api.encoding.encodings.muxing.information;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgressiveMuxingInformation
{
    private String mimeType;
    private Long fileSize;
    private String containerFormat;
    private Long containerBitrate;
    private Double duration;
    private List<MuxingInformationVideoTrack> videoTracks = new ArrayList<>();
    private List<MuxingInformationAudioTrack> audioTracks = new ArrayList<>();

    public String getMimeType()
    {
        return this.mimeType;
    }

    public void setMimeType(String mimeType)
    {
        this.mimeType = mimeType;
    }

    public Long getFileSize()
    {
        return this.fileSize;
    }

    public void setFileSize(Long fileSize)
    {
        this.fileSize = fileSize;
    }

    public String getContainerFormat()
    {
        return this.containerFormat;
    }

    public void setContainerFormat(String containerFormat)
    {
        this.containerFormat = containerFormat;
    }

    public Long getContainerBitrate()
    {
        return this.containerBitrate;
    }

    public void setContainerBitrate(Long containerBitrate)
    {
        this.containerBitrate = containerBitrate;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }

    public List<MuxingInformationVideoTrack> getVideoTracks()
    {
        return this.videoTracks;
    }

    public void setVideoTracks(List<MuxingInformationVideoTrack> videoTracks)
    {
        this.videoTracks = videoTracks;
    }

    public List<MuxingInformationAudioTrack> getAudioTracks()
    {
        return this.audioTracks;
    }

    public void setAudioTracks(List<MuxingInformationAudioTrack> audioTracks)
    {
        this.audioTracks = audioTracks;
    }
}
