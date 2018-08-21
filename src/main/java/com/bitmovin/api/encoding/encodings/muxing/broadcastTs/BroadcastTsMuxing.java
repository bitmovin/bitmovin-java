package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

import java.util.Date;

public class BroadcastTsMuxing extends Muxing
{
    private String name;
    private String description;
    private Date modifiedAt;
    private Double segmentLength;
    private String filename;

    private BroadcastTsMuxingConfiguration configuration;

    public BroadcastTsMuxing()
    {
        super();
        this.setType(MuxingType.BROADCAST_TS);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getModifiedAt()
    {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public Double getSegmentLength()
    {
        return this.segmentLength;
    }

    public void setSegmentLength(Double segmentLength)
    {
        this.segmentLength = segmentLength;
    }

    public String getFilename()
    {
        return this.filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public BroadcastTsMuxingConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public void setConfiguration(BroadcastTsMuxingConfiguration configuration)
    {
        this.configuration = configuration;
    }
}
