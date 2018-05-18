package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import com.bitmovin.api.encoding.encodings.muxing.enums.RAIUnit;

public class BroadcastTsInputStreamConfiguration
{
    private String streamId;

    private Integer packetIdentifier;

    private Boolean startWithDiscontinuityIndicator;
    private Boolean alignPes;
    private RAIUnit setRaiOnAu;

    public BroadcastTsInputStreamConfiguration()
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

    public Integer getPacketIdentifier()
    {
        return this.packetIdentifier;
    }

    public void setPacketIdentifier(Integer packetIdentifier)
    {
        this.packetIdentifier = packetIdentifier;
    }

    public Boolean getStartWithDiscontinuityIndicator()
    {
        return this.startWithDiscontinuityIndicator;
    }

    public void setStartWithDiscontinuityIndicator(Boolean startWithDiscontinuityIndicator)
    {
        this.startWithDiscontinuityIndicator = startWithDiscontinuityIndicator;
    }

    public Boolean getAlignPes()
    {
        return this.alignPes;
    }

    public void setAlignPes(Boolean alignPes)
    {
        this.alignPes = alignPes;
    }

    public RAIUnit getSetRaiOnAu()
    {
        return this.setRaiOnAu;
    }

    public void setSetRaiOnAu(RAIUnit setRaiOnAu)
    {
        this.setRaiOnAu = setRaiOnAu;
    }

}
