package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

/**
 * Created by doweinberger on 8/10/16.
 */
public class TSMuxing extends Muxing {
    private Double segmentLength;
    private String segmentNaming;
    private Integer segmentsMuxed;

    public TSMuxing() {
        this.type = MuxingType.TS;
    }

    public Double getSegmentLength() {
        return this.segmentLength;
    }

    public void setSegmentLength(Double segmentLength) {
        this.segmentLength = segmentLength;
    }

    public String getSegmentNaming() {
        return this.segmentNaming;
    }

    public void setSegmentNaming(String segmentNaming) {
        this.segmentNaming = segmentNaming;
    }

    public Integer getSegmentsMuxed()
    {
        return this.segmentsMuxed;
    }

    public void setSegmentsMuxed(Integer segmentsMuxed)
    {
        this.segmentsMuxed = segmentsMuxed;
    }
}