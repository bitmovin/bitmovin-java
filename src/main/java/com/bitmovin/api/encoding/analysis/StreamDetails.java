package com.bitmovin.api.encoding.analysis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dmiglar on 8/16/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamDetails
{
    private String  id;
    private String  codec;
    private Integer duration;
    private Integer position;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCodec()
    {
        return this.codec;
    }

    public void setCodec(String codec)
    {
        this.codec = codec;
    }

    public Integer getDuration()
    {
        return this.duration;
    }

    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }

    public Integer getPosition()
    {
        return this.position;
    }

    public void setPosition(Integer position)
    {
        this.position = position;
    }
}
