package com.bitmovin.api.encoding.analysis;

/**
 * Created by dmiglar on 8/16/16.
 */
public class SubtitleStreamDetails extends StreamDetails
{
    private String language;
    private Boolean hearingImpaired;

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
