package com.bitmovin.api.examples.util;

import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStreamRepresentation
{
    private String outputBasePath;
    private String relativeOutputPath;

    private Integer width;
    private Integer height;
    private Float rate;
    private Long bitrate;
    private ProfileH264 profile;
    private H264VideoConfiguration configuration;
    private List<Stream> streams;
    private Map<String, TSMuxing> streamIdTSMuxingMapping;
    private Map<String, FMP4Muxing> streamIdFmp4MuxingMapping;

    public MultiStreamRepresentation(Integer width, Integer height, Float rate, Long bitrate, ProfileH264 profile, String outputBasePath, String relativeOutputPath)
    {
        this.streams = new ArrayList<>();
        this.streamIdTSMuxingMapping = new HashMap<>();
        this.streamIdFmp4MuxingMapping = new HashMap<>();
        this.width = width;
        this.height = height;
        this.rate = rate;
        this.bitrate = bitrate;
        this.profile = profile;
        this.outputBasePath = outputBasePath;
        this.relativeOutputPath = relativeOutputPath;
    }

    public String getOutputBasePath()
    {
        return outputBasePath;
    }

    public void setOutputBasePath(String outputBasePath)
    {
        this.outputBasePath = outputBasePath;
    }

    public String getRelativeOutputPath()
    {
        return relativeOutputPath;
    }

    public void setRelativeOutputPath(String relativeOutputPath)
    {
        this.relativeOutputPath = relativeOutputPath;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Float getRate()
    {
        return rate;
    }

    public void setRate(Float rate)
    {
        this.rate = rate;
    }

    public Long getBitrate()
    {
        return bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }

    public ProfileH264 getProfile()
    {
        return profile;
    }

    public void setProfile(ProfileH264 profile)
    {
        this.profile = profile;
    }

    public H264VideoConfiguration getConfiguration()
    {
        return configuration;
    }

    public void setConfiguration(H264VideoConfiguration configuration)
    {
        this.configuration = configuration;
    }

    public List<Stream> getStreams()
    {
        return streams;
    }

    public void setStreams(List<Stream> streams)
    {
        this.streams = streams;
    }

    public void addStream(Stream stream)
    {
        this.streams.add(stream);
    }

    public void addTsMuxing(String streamId, TSMuxing tsMuxing)
    {
        this.streamIdTSMuxingMapping.put(streamId, tsMuxing);
    }

    public void addFmp4Muxing(String streamId, FMP4Muxing fmp4Muxing)
    {
        this.streamIdFmp4MuxingMapping.put(streamId, fmp4Muxing);
    }

    public TSMuxing getTsMuxingFromStreamId(String streamId)
    {
        return this.streamIdTSMuxingMapping.get(streamId);
    }

    public String getTsMuxingIdFromStreamId(String streamId)
    {
        if (this.streamIdTSMuxingMapping.get(streamId) == null)
            return null;

        return this.streamIdTSMuxingMapping.get(streamId).getId();
    }

    public FMP4Muxing getFmp4MuxingFromStreamId(String streamId)
    {
        return this.streamIdFmp4MuxingMapping.get(streamId);
    }

    public String getFmp4MuxingIdFromStreamId(String streamId)
    {
        if (this.streamIdFmp4MuxingMapping.get(streamId) == null)
            return null;

        return this.streamIdFmp4MuxingMapping.get(streamId).getId();
    }
}
