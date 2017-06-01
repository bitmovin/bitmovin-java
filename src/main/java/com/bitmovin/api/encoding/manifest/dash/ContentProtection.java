package com.bitmovin.api.encoding.manifest.dash;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by msmole on 13.10.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentProtection
{
    private String id;
    private String encodingId;
    private String streamId;
    private String muxingId;
    private String drmId;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public String getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }

    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public String getDrmId()
    {
        return this.drmId;
    }

    public void setDrmId(String drmId)
    {
        this.drmId = drmId;
    }
}
