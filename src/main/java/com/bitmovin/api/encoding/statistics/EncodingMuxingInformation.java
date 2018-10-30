package com.bitmovin.api.encoding.statistics;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingMuxingInformation
{
    private String muxingId;
    private String streamId;
    private Double multiplicator;
    private Long encodedBytes;
    private Double encodedSeconds;
    private Double billableMinutes;
    private MuxingType muxingType;

    public EncodingMuxingInformation()
    {

    }

    public String getMuxingId()
    {
        return muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public String getStreamId()
    {
        return streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }

    public Double getMultiplicator()
    {
        return multiplicator;
    }

    public void setMultiplicator(Double multiplicator)
    {
        this.multiplicator = multiplicator;
    }

    public Long getEncodedBytes()
    {
        return encodedBytes;
    }

    public void setEncodedBytes(Long encodedBytes)
    {
        this.encodedBytes = encodedBytes;
    }

    public Double getEncodedSeconds()
    {
        return encodedSeconds;
    }

    public void setEncodedSeconds(Double encodedSeconds)
    {
        this.encodedSeconds = encodedSeconds;
    }

    public MuxingType getMuxingType()
    {
        return muxingType;
    }

    public void setMuxingType(MuxingType muxingType)
    {
        this.muxingType = muxingType;
    }

    public Double getBillableMinutes()
    {
        return billableMinutes;
    }

    public void setBillableMinutes(Double billableMinutes)
    {
        this.billableMinutes = billableMinutes;
    }

    @Override
    public String toString()
    {
        return "EncodingMuxingInformation{" +
                "muxingId='" + muxingId + '\'' +
                ", streamId='" + streamId + '\'' +
                ", multiplicator=" + multiplicator +
                ", encodedBytes=" + encodedBytes +
                ", encodedSeconds=" + encodedSeconds +
                ", billableMinutes=" + billableMinutes +
                ", muxingType=" + muxingType +
                '}';
    }
}