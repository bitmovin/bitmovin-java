package com.bitmovin.api.encoding.analysis;

/**
 * Created by dmiglar on 8/16/16.
 */
public class AudioStreamDetails extends StreamDetails
{
    private Integer sampleRate;
    private Integer bitrate;
    private String language;
    private Boolean hearingImpaired;

    public Integer getSampleRate()
    {
        return this.sampleRate;
    }

    public void setSampleRate(Integer sampleRate)
    {
        this.sampleRate = sampleRate;
    }

    public Integer getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Integer bitrate)
    {
        this.bitrate = bitrate;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Boolean getHearingImpaired()
    {
        return this.hearingImpaired;
    }

    public void setHearingImpaired(Boolean hearingImpaired)
    {
        this.hearingImpaired = hearingImpaired;
    }
}
