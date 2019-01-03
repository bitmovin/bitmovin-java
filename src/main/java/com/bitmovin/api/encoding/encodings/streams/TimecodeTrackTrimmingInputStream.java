package com.bitmovin.api.encoding.encodings.streams;

import com.bitmovin.api.AbstractApiResponse;

public class TimecodeTrackTrimmingInputStream extends AbstractApiResponse
{

    private String inputStreamId;

    private String startTimeCode;

    private String endTimeCode;

    public TimecodeTrackTrimmingInputStream() {
    }

    public String getInputStreamId()
    {
        return this.inputStreamId;
    }

    public void setInputStreamId(String inputStreamId)
    {
        this.inputStreamId= inputStreamId;
    }

    public String getStartTimeCode()
    {
        return this.startTimeCode;
    }

    public void setStartTimeCode(String startTimeCode)
    {
        this.startTimeCode= startTimeCode;
    }

    public String getEndTimeCode()
    {
        return this.endTimeCode;
    }

    public void setEndTimeCode(String startTimeCode)
    {
        this.endTimeCode= endTimeCode;
    }

}
