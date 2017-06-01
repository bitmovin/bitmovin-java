package com.bitmovin.api.encoding.encodings.muxing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Roland Kersche on 10/21/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MuxingStream
{

    private String streamId;

    public String getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }
}
