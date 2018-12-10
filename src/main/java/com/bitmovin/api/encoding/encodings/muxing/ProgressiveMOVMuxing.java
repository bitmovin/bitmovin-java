package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

public class ProgressiveMOVMuxing extends Muxing
{
    private String name;
    private String description;
    private String filename;
    private InternalChunkLength internalChunkLength;

    public ProgressiveMOVMuxing()
    {
        this.type = MuxingType.PROGRESSIVE_MOV;
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

    public InternalChunkLength getInternalChunkLength()
    {
        return this.internalChunkLength;
    }

    public void setInternalChunkLength(InternalChunkLength internalChunkLength)
    {
        this.internalChunkLength = internalChunkLength;
    }
}
