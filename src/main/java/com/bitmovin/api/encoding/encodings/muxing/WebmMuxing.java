package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

import java.util.Date;

/**
 * Created by dmoser on 09.02.17.
 */
public class WebmMuxing extends Muxing
{
    private String name;
    private String description;
    private Date createdAt;
    private Date modifiedAt;
    private Double segmentLength;
    private String segmentNaming;
    private String initSegmentName;

    public WebmMuxing()
    {
        this.setType(MuxingType.WEBM);
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

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
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

    public String getSegmentNaming()
    {
        return this.segmentNaming;
    }

    public void setSegmentNaming(String segmentNaming)
    {
        this.segmentNaming = segmentNaming;
    }

    public String getInitSegmentName()
    {
        return this.initSegmentName;
    }

    public void setInitSegmentName(String initSegmentName)
    {
        this.initSegmentName = initSegmentName;
    }
}
