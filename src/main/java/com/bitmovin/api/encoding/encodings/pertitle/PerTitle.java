package com.bitmovin.api.encoding.encodings.pertitle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerTitle
{

    private H264PerTitleConfiguration h264Configuration;
    private H265PerTitleConfiguration h265Configuration;
    private VP8PerTitleConfiguration vp8Configuration;
    private VP9PerTitleConfiguration vp9Configuration;
    private AV1PerTitleConfiguration av1Configuration;

    public H264PerTitleConfiguration getH264Configuration()
    {
        return this.h264Configuration;
    }

    public void setH264Configuration(H264PerTitleConfiguration h264Configuration)
    {
        this.h264Configuration = h264Configuration;
    }

    public H265PerTitleConfiguration getH265Configuration()
    {
        return this.h265Configuration;
    }

    public void setH265Configuration(H265PerTitleConfiguration h265Configuration)
    {
        this.h265Configuration = h265Configuration;
    }

    public VP8PerTitleConfiguration getVp8Configuration()
    {
        return this.vp8Configuration;
    }

    public void setVp8Configuration(VP8PerTitleConfiguration vp8Configuration)
    {
        this.vp8Configuration = vp8Configuration;
    }

    public VP9PerTitleConfiguration getVp9Configuration()
    {
        return this.vp9Configuration;
    }

    public void setVp9Configuration(VP9PerTitleConfiguration vp9Configuration)
    {
        this.vp9Configuration = vp9Configuration;
    }

    public AV1PerTitleConfiguration getAv1Configuration()
    {
        return this.av1Configuration;
    }

    public void setAv1Configuration(AV1PerTitleConfiguration av1Configuration)
    {
        this.av1Configuration = av1Configuration;
    }
}
