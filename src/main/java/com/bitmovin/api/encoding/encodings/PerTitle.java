package com.bitmovin.api.encoding.encodings;

public class PerTitle
{

    private PerTitleConfiguration h264Configuration;
    private PerTitleConfiguration h265Configuration;
    private PerTitleConfiguration vp8Configuration;
    private PerTitleConfiguration vp9Configuration;
    private PerTitleConfiguration av1Configuration;

    public PerTitleConfiguration getH264Configuration()
    {
        return this.h264Configuration;
    }

    public void setH264Configuration(PerTitleConfiguration h264Configuration)
    {
        this.h264Configuration = h264Configuration;
    }

    public PerTitleConfiguration getH265Configuration()
    {
        return this.h265Configuration;
    }

    public void setH265Configuration(PerTitleConfiguration h265Configuration)
    {
        this.h265Configuration = h265Configuration;
    }

    public PerTitleConfiguration getVp8Configuration()
    {
        return this.vp8Configuration;
    }

    public void setVp8Configuration(PerTitleConfiguration vp8Configuration)
    {
        this.vp8Configuration = vp8Configuration;
    }

    public PerTitleConfiguration getVp9Configuration()
    {
        return this.vp9Configuration;
    }

    public void setVp9Configuration(PerTitleConfiguration vp9Configuration)
    {
        this.vp9Configuration = vp9Configuration;
    }

    public PerTitleConfiguration getAv1Configuration()
    {
        return this.av1Configuration;
    }

    public void setAv1Configuration(PerTitleConfiguration av1Configuration)
    {
        this.av1Configuration = av1Configuration;
    }
}
