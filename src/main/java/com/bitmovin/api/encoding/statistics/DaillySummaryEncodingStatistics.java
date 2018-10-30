package com.bitmovin.api.encoding.statistics;

public class DaillySummaryEncodingStatistics extends SummaryEncodingStatistics
{
    private Double billableMinutes;
    private Double billableTransmuxingMinutes;

    public DaillySummaryEncodingStatistics()
    {
    }

    public Double getBillableMinutes() { return billableMinutes; }

    public void setBillableMinutes(Double billableMinutes) { this.billableMinutes = billableMinutes; }

    public Double getBillableTransmuxingMinutes() { return billableTransmuxingMinutes; }

    public void setBillableTransmuxingMinutes(Double billableTransmuxingMinutes) { this.billableTransmuxingMinutes = billableTransmuxingMinutes; }

    @Override
    public String toString()
    {
        return "DaillySummaryEncodingStatistics{" +
                "date=" + getDate() +
                ", bytesEncoded=" + getBytesEncoded() +
                ", timeEncoded=" + getTimeEncoded() +
                ", billableMinutes=" + billableMinutes +
                ", billableTransmuxingMinutes=" + billableTransmuxingMinutes +
                '}';
    }
}
