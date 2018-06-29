package com.bitmovin.api.encoding.encodings.muxing.information;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgressiveTSMuxingInformation extends ProgressiveMuxingInformation
{

    private List<ProgressiveTSMuxingInformationByteRanges> byteRanges;

    public List<ProgressiveTSMuxingInformationByteRanges> getByteRanges()
    {
        return this.byteRanges;
    }

    public void setByteRanges(List<ProgressiveTSMuxingInformationByteRanges> byteRanges)
    {
        this.byteRanges = byteRanges;
    }

}
