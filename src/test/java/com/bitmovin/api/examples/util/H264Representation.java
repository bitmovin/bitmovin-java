package com.bitmovin.api.examples.util;

import com.bitmovin.api.encoding.codecConfigurations.H264VideoConfiguration;
import com.bitmovin.api.encoding.codecConfigurations.enums.ProfileH264;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.streams.Stream;

/**
 * Created by Roland Kersche on 22.06.17.
 */
public class H264Representation
{
    private String outputBasePath;
    private String relativeOutputPath;

    private Integer width;
    private Integer height;
    private Float rate;
    private Long bitrate;
    private ProfileH264 profile;
    private H264VideoConfiguration configuration;
    private Stream stream;
    private TSMuxing tsMuxing;
    private FMP4Muxing fmp4Muxing;

    public H264Representation(Integer width, Integer height, Float rate, Long bitrate)
    {
        this(width, height, rate, bitrate, ProfileH264.HIGH);
    }

    public H264Representation(Integer width, Integer height, Float rate, Long bitrate, ProfileH264 profile)
    {
        this.width = width;
        this.height = height;
        this.rate = rate;
        this.bitrate = bitrate;
        this.profile = profile;
    }

    public H264Representation(Integer width, Integer height, Float rate, Long bitrate, ProfileH264 profile, String outputBasePath, String relativeOutputPath)
    {
        this(width, height, rate, bitrate, profile);
        this.relativeOutputPath = relativeOutputPath;
        this.outputBasePath = outputBasePath;
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
        return this.width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return this.height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Float getRate()
    {
        return this.rate;
    }

    public void setRate(Float rate)
    {
        this.rate = rate;
    }

    public Long getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }

    public H264VideoConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public void setConfiguration(H264VideoConfiguration configuration)
    {
        this.configuration = configuration;
    }

    public ProfileH264 getProfile()
    {
        return this.profile;
    }

    public void setProfile(ProfileH264 profile)
    {
        this.profile = profile;
    }

    public Stream getStream()
    {
        return this.stream;
    }

    public void setStream(Stream stream)
    {
        this.stream = stream;
    }

    public TSMuxing getTsMuxing()
    {
        return this.tsMuxing;
    }

    public void setTsMuxing(TSMuxing tsMuxing)
    {
        this.tsMuxing = tsMuxing;
    }

    public FMP4Muxing getFmp4Muxing()
    {
        return this.fmp4Muxing;
    }

    public void setFmp4Muxing(FMP4Muxing fmp4Muxing)
    {
        this.fmp4Muxing = fmp4Muxing;
    }
}
