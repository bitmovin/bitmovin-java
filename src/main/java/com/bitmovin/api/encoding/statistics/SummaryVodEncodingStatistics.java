package com.bitmovin.api.encoding.statistics;

public class SummaryVodEncodingStatistics extends SummaryEncodingStatistics
{
    private Long timeEnqueued;
    private Float realtimeFactor;

    public SummaryVodEncodingStatistics() { super();}

    public Long getTimeEnqueued() { return timeEnqueued; }

    public void setTimeEnqueued(Long timeEnqueued) { this.timeEnqueued = timeEnqueued; }

    public Float getRealtimeFactor() { return realtimeFactor; }

    public void setRealtimeFactor(Float realtimeFactor) { this.realtimeFactor = realtimeFactor; }

    @Override
    public String toString()
    {
        return "SummaryVodEncodingStatistics{" +
                "date=" + getDate() +
                ", bytesEncoded=" + getBytesEncoded() +
                ", timeEncoded=" + getTimeEncoded() +
                ", timeEnqueued=" + timeEnqueued +
                ", realtimeFactor=" + realtimeFactor +
                '}';
    }
}
