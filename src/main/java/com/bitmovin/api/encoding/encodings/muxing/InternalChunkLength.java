package com.bitmovin.api.encoding.encodings.muxing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalChunkLength
{
    private InternalChunkLengthMode mode;
    private Double customChunkLength;

    public InternalChunkLengthMode getMode()
    {
        return this.mode;
    }

    public void setMode(InternalChunkLengthMode mode)
    {
        this.mode = mode;
    }

    public Double getCustomChunkLength()
    {
        return this.customChunkLength;
    }

    public void setCustomChunkLength(Double customChunkLength)
    {
        this.customChunkLength = customChunkLength;
    }
}
