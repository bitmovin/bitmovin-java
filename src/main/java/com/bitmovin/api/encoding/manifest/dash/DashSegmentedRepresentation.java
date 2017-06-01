package com.bitmovin.api.encoding.manifest.dash;

import com.bitmovin.api.encoding.enums.DashMuxingType;

/**
 * Created by arudich on 03.03.17.
 **/
public abstract class DashSegmentedRepresentation extends DashRepresentation
{
    private DashMuxingType type;

    private String muxingId;

    private String encodingId;

    private String streamId;

    private String segmentPath;

    private Long startSegmentNumber;

    private Long endSegmentNumber;


    public DashMuxingType getType()
    {
        return this.type;
    }

    public void setType(DashMuxingType type)
    {
        this.type = type;
    }

    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
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

    public String getSegmentPath()
    {
        return this.segmentPath;
    }

    public void setSegmentPath(String segmentPath)
    {
        this.segmentPath = segmentPath;
    }

    public Long getStartSegmentNumber()
    {
        return this.startSegmentNumber;
    }

    public void setStartSegmentNumber(Long startSegmentNumber)
    {
        this.startSegmentNumber = startSegmentNumber;
    }

    public Long getEndSegmentNumber()
    {
        return this.endSegmentNumber;
    }

    public void setEndSegmentNumber(Long endSegmentNumber)
    {
        this.endSegmentNumber = endSegmentNumber;
    }
}
