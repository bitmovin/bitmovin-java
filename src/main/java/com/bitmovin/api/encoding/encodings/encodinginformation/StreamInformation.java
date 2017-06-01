package com.bitmovin.api.encoding.encodings.encodinginformation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doweinberger on 8/4/16.
 */
public class StreamInformation
{
    private String id;

    private String streamId;

    private Map<String, MuxingInformation> muxings = new HashMap<String, MuxingInformation>();

    public String getStreamId()
    {
        return this.streamId;
    }

    public void setStreamId(String streamId)
    {
        this.streamId = streamId;
    }

    public Map<String, MuxingInformation> getMuxings()
    {
        return this.muxings;
    }

    public void setMuxings(Map<String, MuxingInformation> muxings)
    {
        this.muxings = muxings;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
