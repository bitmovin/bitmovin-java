package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.AbstractApiResponse;

public class Keyframe extends AbstractApiResponse
{
    private Float time;
    private Boolean segmentCut;

    public Keyframe()
    {
    }

    public Keyframe(Float time, Boolean segmentCut)
    {
        this.time = time;
        this.segmentCut = segmentCut;
    }

    public Float getTime()
    {
        return time;
    }

    public void setTime(Float time)
    {
        this.time = time;
    }

    public Boolean getSegmentCut()
    {
        return segmentCut;
    }

    public void setSegmentCut(Boolean segmentCut)
    {
        this.segmentCut = segmentCut;
    }
}
