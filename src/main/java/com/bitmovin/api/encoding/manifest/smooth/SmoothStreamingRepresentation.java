package com.bitmovin.api.encoding.manifest.smooth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atrattnig on 11/16/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmoothStreamingRepresentation
{
    private String id;
    private String encodingId;
    private String muxingId;
    private String mediaFile;
    private String language;
    private String trackName;

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

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getTrackName()
    {
        return trackName;
    }

    public void setTrackName(String trackName)
    {
        this.trackName = trackName;
    }
}
