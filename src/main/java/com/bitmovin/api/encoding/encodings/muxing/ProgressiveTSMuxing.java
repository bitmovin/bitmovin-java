package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

public class ProgressiveTSMuxing extends Muxing {
    private Double segmentLength;
    private String filename;

    public ProgressiveTSMuxing() {
        this.type = MuxingType.PROGRESSIVE_TS;
    }

    public Double getSegmentLength() {
        return this.segmentLength;
    }

    public void setSegmentLength(Double segmentLength) {
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
}