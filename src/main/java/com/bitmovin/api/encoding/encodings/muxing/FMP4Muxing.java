package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.07.16.
 */
public class FMP4Muxing extends Muxing {
    private Double segmentLength;
    private String segmentNaming;
    private String initSegmentName;
    private Integer segmentsMuxed;


    public FMP4Muxing() {
        this.type = MuxingType.FMP4;
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

    public String getInitSegmentName() {
        return this.initSegmentName;
    }

    public void setInitSegmentName(String initSegmentName) {
        this.initSegmentName = initSegmentName;
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
