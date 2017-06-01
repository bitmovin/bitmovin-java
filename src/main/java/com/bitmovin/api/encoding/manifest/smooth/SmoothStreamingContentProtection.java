package com.bitmovin.api.encoding.manifest.smooth;

/**
 * Created by atrattnig on 11/16/16.
 */
public class SmoothStreamingContentProtection
{
    private String id;
    private String encodingId;
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
