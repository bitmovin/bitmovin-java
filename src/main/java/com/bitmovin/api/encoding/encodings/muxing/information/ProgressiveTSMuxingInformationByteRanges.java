package com.bitmovin.api.encoding.encodings.muxing.information;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgressiveTSMuxingInformationByteRanges
{
    private int segmentNumber;
    private Long startBytes;
    private Long endBytes;
    private Double duration;

    public int getSegmentNumber()
    {
        return this.segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber)
    {
        this.segmentNumber = segmentNumber;
    }

    public Long getStartBytes()
    {
        return this.startBytes;
    }

    public void setStartBytes(Long startBytes)
    {
        this.startBytes = startBytes;
    }

    public Long getEndBytes()
    {
        return this.endBytes;
    }

    public void setEndBytes(Long endBytes)
    {
        this.endBytes = endBytes;
    }

    public Double getDuration()
    {
        return this.duration;
    }

    public void setDuration(Double duration)
    {
        this.duration = duration;
    }
}
