package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.enums.StreamSelectionMode;

public class TimeBasedTrimmingInputStream extends AbstractApiResponse
{

    private String inputStreamId;

    private Integer offset;

    private Integer duration;

    public TimeBasedTrimmingInputStream() {
    }

    public String getInputStreamId()
    {
        return this.inputStreamId;
    }

    public void setInputStreamId(String inputId)
    {
        this.inputStreamId= inputStreamId;
    }

    public Integer getOffset()
    {
        return this.offset;
    }

    public void setOffset(Integer offset)
    {
        this.offset= offset;
    }

    public Integer getDuration() { return this.duration; }

    public void setDuration(Integer duration) { this.duration= duration; }
}
