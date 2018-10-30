package com.bitmovin.api.encoding.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EncodingStatistics
{
    private Date date;
    private String encodingId;
    private Long bytesEncoded;
    private Long timeEncoded;
    private Long downloadedSize;
    private Double billableMinutes;
    private List<BillableEncodingMinutes> billableEncodingMinutes;
    private Double billableTransmuxingMinutes;
    private Double billableFeatureMinutes;
    private List<EncodingStreamInformation> streams;
    private List<EncodingMuxingInformation> muxings;
    private List<EncodingFeatureInformation> features;
    private String label;

    public EncodingStatistics()
    {
        this(null);
    }

    public EncodingStatistics(Date date)
    {
        this.date = date;
        this.bytesEncoded = 0L;
        this.timeEncoded = 0L;
        this.billableMinutes = 0.0D;
        this.billableTransmuxingMinutes = 0.0D;
        this.billableFeatureMinutes = 0.0D;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Long getBytesEncoded()
    {
        return bytesEncoded;
    }

    public void setBytesEncoded(Long bytesEncoded)
    {
        this.bytesEncoded = bytesEncoded;
    }

    public Long getTimeEncoded()
    {
        return timeEncoded;
    }

    public void setTimeEncoded(Long timeEncoded)
    {
        this.timeEncoded = timeEncoded;
    }

    public Long getDownloadedSize()
    {
        return downloadedSize;
    }

    public void setDownloadedSize(Long downloadedSize)
    {
        this.downloadedSize = downloadedSize;
    }

    public Double getBillableMinutes()
    {
        return this.billableMinutes;
    }

    public void setBillableMinutes(Double billableMinutes) { this.billableMinutes = billableMinutes; }

    public List<BillableEncodingMinutes> getBillableEncodingMinutes()
    {
        return billableEncodingMinutes;
    }

    public void setBillableEncodingMinutes(List<BillableEncodingMinutes> billableEncodingMinutes)
    {
        this.billableEncodingMinutes = billableEncodingMinutes;
    }

    public Double getBillableFeatureMinutes()
    {
        return this.billableFeatureMinutes;
    }

    public void setBillableFeatureMinutes(Double billableFeatureMinutes)
    {
        this.billableFeatureMinutes = billableFeatureMinutes;
    }

    public Double getBillableTransmuxingMinutes()
    {
        return billableTransmuxingMinutes;
    }

    public void setBillableTransmuxingMinutes(Double billableTransmuxingMinutes)
    {
        this.billableTransmuxingMinutes = billableTransmuxingMinutes;
    }

    public String getEncodingId()
    {
        return encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public List<EncodingFeatureInformation> getFeatures()
    {
        return this.features;
    }

    public void setFeatures(List<EncodingFeatureInformation> features)
    {
        this.features = features;
    }

    public List<EncodingStreamInformation> getStreams()
    {
        return streams;
    }

    public void setStreams(List<EncodingStreamInformation> streams)
    {
        this.streams = streams;
    }

    public List<EncodingMuxingInformation> getMuxings()
    {
        return muxings;
    }

    public void setMuxings(List<EncodingMuxingInformation> muxings)
    {
        this.muxings = muxings;
    }

    @Override
    public String toString()
    {
        return "EncodingStatistics{" +
                "date=" + date +
                ", encodingId='" + encodingId + '\'' +
                ", bytesEncoded=" + bytesEncoded +
                ", timeEncoded=" + timeEncoded +
                ", downloadedSize=" + downloadedSize +
                ", billableMinutes=" + billableMinutes +
                ", billableEncodingMinutes=" + billableEncodingMinutes +
                ", billableTransmuxingMinutes=" + billableTransmuxingMinutes +
                ", billableFeatureMinutes=" + billableFeatureMinutes +
                ", streams=" + streams +
                ", muxings=" + muxings +
                ", features=" + features +
                ", label='" + label + '\'' +
                '}';
    }
}