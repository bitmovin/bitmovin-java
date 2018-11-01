package com.bitmovin.api.encoding.manifest.hls;

import com.bitmovin.api.encoding.manifest.enums.PositionMode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomTag
{
    private String id;
    private PositionMode positionMode;
    private String keyframeId;
    private Long segment;
    private Double time;
    private String data;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getData()
    {
        return this.data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public PositionMode getPositionMode()
    {
        return this.positionMode;
    }

    public void setPositionMode(PositionMode positionMode)
    {
        this.positionMode = positionMode;
    }

    public String getKeyframeId()
    {
        return this.keyframeId;
    }

    public void setKeyframeId(String keyframeId)
    {
        this.keyframeId = keyframeId;
    }

    public Long getSegment()
    {
        return this.segment;
    }

    public void setSegment(Long segment)
    {
        this.segment = segment;
    }

    public Double getTime()
    {
        return this.time;
    }

    public void setTime(Double time)
    {
        this.time = time;
    }
}
