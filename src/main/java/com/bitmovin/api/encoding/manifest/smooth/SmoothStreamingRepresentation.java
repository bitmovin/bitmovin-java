package com.bitmovin.api.encoding.manifest.smooth;

/**
 * Created by atrattnig on 11/16/16.
 */
public class SmoothStreamingRepresentation
{
    private String id;
    private String encodingId;
    private String muxingId;
    private String mediaFile;

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

    public String getMediaFile()
    {
        return this.mediaFile;
    }

    public void setMediaFile(String mediaFile)
    {
        this.mediaFile = mediaFile;
    }

}
