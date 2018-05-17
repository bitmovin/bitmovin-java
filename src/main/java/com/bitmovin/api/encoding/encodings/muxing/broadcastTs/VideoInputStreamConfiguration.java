package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

public class VideoInputStreamConfiguration extends InputStreamConfiguration
{
    private Boolean insertAccessUnitDelimiterInAvc;

    private Integer maxDecodeDelay;

    public VideoInputStreamConfiguration()
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
