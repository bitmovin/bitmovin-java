package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmoser on 25.10.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveDetailsResponse
{
    private String streamKey;
    private String encoderIp;
    private String application;

    public String getStreamKey()
    {
        return this.streamKey;
    }

    public void setStreamKey(String streamKey)
    {
        this.streamKey = streamKey;
    }

    public String getEncoderIp()
    {
        return this.encoderIp;
    }

    public void setEncoderIp(String encoderIp)
    {
        this.encoderIp = encoderIp;
    }

    public String getApplication()
    {
        return this.application;
    }

    public void setApplication(String application)
    {
        this.application = application;
    }

}
