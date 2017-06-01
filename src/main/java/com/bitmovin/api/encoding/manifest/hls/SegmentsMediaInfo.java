package com.bitmovin.api.encoding.manifest.hls;


/**
 * Created by arudich on 25.01.17.
 **/
public abstract class SegmentsMediaInfo extends BasicMediaInfo
{
    private String encodingId;
    private String streamId;
    private String muxingId;
    private String drmId;
    private Long startSegmentNumber;
    private Long endSegmentNumber;
    private String segmentPath;


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

    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public String getSegmentPath()
    {
        return this.segmentPath;
    }

    public void setSegmentPath(String segmentPath)
    {
        this.segmentPath = segmentPath;
    }

    public String getDrmId()
    {
        return this.drmId;
    }

    public void setDrmId(String drmId)
    {
        this.drmId = drmId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SegmentsMediaInfo)) return false;
        if (!super.equals(o)) return false;

        SegmentsMediaInfo that = (SegmentsMediaInfo) o;

        if (this.encodingId != null ? !this.encodingId.equals(that.encodingId) : that.encodingId != null) return false;
        if (this.streamId != null ? !this.streamId.equals(that.streamId) : that.streamId != null) return false;
        if (this.muxingId != null ? !this.muxingId.equals(that.muxingId) : that.muxingId != null) return false;
        if (this.drmId != null ? !this.drmId.equals(that.drmId) : that.drmId != null) return false;
        if (this.startSegmentNumber != null ? !this.startSegmentNumber.equals(that.startSegmentNumber) : that.startSegmentNumber != null)
            return false;
        if (this.endSegmentNumber != null ? !this.endSegmentNumber.equals(that.endSegmentNumber) : that.endSegmentNumber != null)
            return false;
        return this.segmentPath != null ? this.segmentPath.equals(that.segmentPath) : that.segmentPath == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (this.encodingId != null ? this.encodingId.hashCode() : 0);
        result = 31 * result + (this.streamId != null ? this.streamId.hashCode() : 0);
        result = 31 * result + (this.muxingId != null ? this.muxingId.hashCode() : 0);
        result = 31 * result + (this.drmId != null ? this.drmId.hashCode() : 0);
        result = 31 * result + (this.startSegmentNumber != null ? this.startSegmentNumber.hashCode() : 0);
        result = 31 * result + (this.endSegmentNumber != null ? this.endSegmentNumber.hashCode() : 0);
        result = 31 * result + (this.segmentPath != null ? this.segmentPath.hashCode() : 0);
        return result;
    }
}
