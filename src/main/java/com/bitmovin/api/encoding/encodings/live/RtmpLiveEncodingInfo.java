package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmoser on 27.10.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtmpLiveEncodingInfo
{
    String encodingId;
    String mpdUrl;
    String rtmpUrl;
    String encodingName;
    String streamKey;
    String encoderIp;

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public String getMpdUrl()
    {
        return this.mpdUrl;
    }

    public void setMpdUrl(String mpdUrl)
    {
        this.mpdUrl = mpdUrl;
    }

    public String getRtmpUrl()
    {
        return this.rtmpUrl;
    }

    public void setRtmpUrl(String rtmpUrl)
    {
        this.rtmpUrl = rtmpUrl;
    }

    public String getEncodingName()
    {
        return this.encodingName;
    }

    public void setEncodingName(String encodingName)
    {
        this.encodingName = encodingName;
    }

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
}
