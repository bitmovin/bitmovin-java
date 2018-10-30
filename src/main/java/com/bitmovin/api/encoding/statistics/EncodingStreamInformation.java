package com.bitmovin.api.encoding.statistics;

import com.bitmovin.api.encoding.encodings.EncodingMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingStreamInformation
{
    private String streamId;
    private String codecConfigId;
    private Double multiplicator;
    private Long encodedBytes;
    private Double encodedSeconds;
    private Double billableMinutes;
    private Integer width;
    private Integer height;
    private Double rate;
    private Long bitrate;
    private String codec;
    private String resolution;

    private EncodingMode encodingMode;
    private Double encodingModeMultiplicator;

    private PerTitleResultStream perTitleResultStream;
    private Double perTitleMultiplicator;

    public EncodingStreamInformation()
    {

    }

    public String getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }

    public String getCodecConfigId()
    {
        return this.codecConfigId;
    }

    public void setCodecConfigId(String codecConfigId)
    {
        this.codecConfigId = codecConfigId;
    }

    public Double getMultiplicator()
    {
        return this.multiplicator;
    }

    public void setMultiplicator(Double multiplicator)
    {
        this.multiplicator = multiplicator;
    }

    public Long getEncodedBytes()
    {
        return this.encodedBytes;
    }

    public void setEncodedBytes(Long encodedBytes)
    {
        this.encodedBytes = encodedBytes;
    }

    public Double getEncodedSeconds()
    {
        return this.encodedSeconds;
    }

    public void setEncodedSeconds(Double encodedSeconds)
    {
        this.encodedSeconds = encodedSeconds;
    }

    public Integer getWidth()
    {
        return this.width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return this.height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Double getRate()
    {
        return this.rate;
    }

    public void setRate(Double rate)
    {
        this.rate = rate;
    }

    public Long getBitrate()
    {
        return this.bitrate;
    }

    public void setBitrate(Long bitrate)
    {
        this.bitrate = bitrate;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public String getResolution()
    {
        return this.resolution;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public Double getBillableMinutes()
    {
        return this.billableMinutes;
    }

    public void setBillableMinutes(Double billableMinutes)
    {
        this.billableMinutes = billableMinutes;
    }

    public EncodingMode getEncodingMode()
    {
        return this.encodingMode;
    }

    private void setEncodingMode(EncodingMode encodingMode)
    {
        this.encodingMode = encodingMode;
    }

    public Double getEncodingModeMultiplicator()
    {
        return this.encodingModeMultiplicator;
    }

    private void setEncodingModeMultiplicator(Double encodingModeMultiplicator)
    {
        this.encodingModeMultiplicator = encodingModeMultiplicator;
    }

    public PerTitleResultStream getPerTitleResultStream()
    {
        return this.perTitleResultStream;
    }

    public void setPerTitleResultStream(PerTitleResultStream perTitleResultStream)
    {
        this.perTitleResultStream = perTitleResultStream;
    }

    public Double getPerTitleMultiplicator()
    {
        return this.perTitleMultiplicator;
    }

    public void setPerTitleMultiplicator(Double perTitleMultiplicator)
    {
        this.perTitleMultiplicator = perTitleMultiplicator;
    }

    @Override
    public String toString()
    {
        return "EncodingStreamInformation{" +
                "streamId='" + streamId + '\'' +
                ", codecConfigId='" + codecConfigId + '\'' +
                ", multiplicator=" + multiplicator +
                ", encodedBytes=" + encodedBytes +
                ", encodedSeconds=" + encodedSeconds +
                ", billableMinutes=" + billableMinutes +
                ", width=" + width +
                ", height=" + height +
                ", rate=" + rate +
                ", bitrate=" + bitrate +
                ", codec='" + codec + '\'' +
                ", resolution='" + resolution + '\'' +
                ", encodingMode=" + encodingMode +
                ", encodingModeMultiplicator=" + encodingModeMultiplicator +
                ", perTitleResultStream=" + perTitleResultStream +
                ", perTitleMultiplicator=" + perTitleMultiplicator +
                '}';
    }
}
