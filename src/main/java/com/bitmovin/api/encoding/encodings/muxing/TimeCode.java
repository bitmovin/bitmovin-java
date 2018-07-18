package com.bitmovin.api.encoding.encodings.muxing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeCode
{
    private String timeCodeStart;

    public TimeCode()
    {
    }

    public String getTimeCodeStart()
    {
        return this.timeCodeStart;
    }

    public void setTimeCodeStart(String timeCodeStart)
    {
        this.timeCodeStart = timeCodeStart;
    }
}