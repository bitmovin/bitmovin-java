package com.bitmovin.api.encoding.encodings;

/**
 * Created by msmole on 31.03.17.
 */
public class InternalEncodingStatistics
{
    private String encodingId;
    private long bytesEncoded;
    private long timeEncoded;
    private long timeEnqueued;
    private Double encodingCosts;
    private Double serviceTaskCosts;

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public long getBytesEncoded()
    {
        return this.bytesEncoded;
    }

    public void setBytesEncoded(long bytesEncoded)
    {
        this.bytesEncoded = bytesEncoded;
    }

    public long getTimeEncoded()
    {
        return this.timeEncoded;
    }

    public void setTimeEncoded(long timeEncoded)
    {
        this.timeEncoded = timeEncoded;
    }

    public long getTimeEnqueued()
    {
        return this.timeEnqueued;
    }

    public void setTimeEnqueued(long timeEnqueued)
    {
        this.timeEnqueued = timeEnqueued;
    }

    public Double getEncodingCosts()
    {
        return this.encodingCosts;
    }

    public void setEncodingCosts(Double encodingCosts)
    {
        this.encodingCosts = encodingCosts;
    }

    public Double getServiceTaskCosts()
    {
        return this.serviceTaskCosts;
    }

    public void setServiceTaskCosts(Double serviceTaskCosts)
    {
        this.serviceTaskCosts = serviceTaskCosts;
    }
}
