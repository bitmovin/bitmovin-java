package com.bitmovin.api.encoding.encodings.streams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Roland Kersche on 26.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamInputAnalysisMetaStream
{
    private String id;
    private Integer position;
    private Long duration;
    private String codec;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }

    public Long getDuration()
    {
        return this.duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }
}
