package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;

public class TimeBasedTrimmingInputStream extends AbstractApiResponse
{

    private String inputStreamId;

    private Double offset;

    private Double duration;

    public TimeBasedTrimmingInputStream() {
    }

    public String getInputStreamId()
    {
        return this.inputStreamId;
    }

    public void setInputStreamId(String inputStreamId)
    {
        this.inputStreamId= inputStreamId;
    }

    public Double getOffset()
    {
        return this.offset;
    }

    public void setOffset(Double offset)
    {
        this.offset= offset;
    }

    public Double getDuration() { return this.duration; }

    public void setDuration(Double duration) { this.duration= duration; }
}
