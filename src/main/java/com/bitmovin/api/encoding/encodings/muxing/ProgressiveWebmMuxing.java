package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

public class ProgressiveWebmMuxing extends Muxing
{
    private String name;
    private String description;
    private String filename;

    public ProgressiveWebmMuxing()
    {
        this.type = MuxingType.PROGRESSIVE_WEBM;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
