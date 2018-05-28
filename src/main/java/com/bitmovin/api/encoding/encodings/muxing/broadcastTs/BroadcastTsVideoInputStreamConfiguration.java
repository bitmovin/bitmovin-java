package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

public class BroadcastTsVideoInputStreamConfiguration extends BroadcastTsInputStreamConfiguration
{
    private Boolean insertAccessUnitDelimiterInAvc;

    private Integer maxDecodeDelay;

    public BroadcastTsVideoInputStreamConfiguration()
    {
        super();
    }

    public Boolean getInsertAccessUnitDelimiterInAvc()
    {
        return this.insertAccessUnitDelimiterInAvc;
    }

    public void setInsertAccessUnitDelimiterInAvc(Boolean insertAccessUnitDelimiterInAvc)
    {
        this.insertAccessUnitDelimiterInAvc = insertAccessUnitDelimiterInAvc;
    }

    public Integer getMaxDecodeDelay()
    {
        return this.maxDecodeDelay;
    }

    public void setMaxDecodeDelay(Integer maxDecodeDelay)
    {
        this.maxDecodeDelay = maxDecodeDelay;
    }
}
