package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

public class MP3Muxing extends Muxing
{
    private String filename;

    public MP3Muxing()
    {
        this.type = MuxingType.MP3;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }
}
