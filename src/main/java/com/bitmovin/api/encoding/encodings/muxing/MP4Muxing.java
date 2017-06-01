package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

/**
 * Created by doweinberger on 8/16/16.
 */
public class MP4Muxing extends Muxing
{
    private String name;

    private String filename;

    private Integer fragmentDuration;

    public MP4Muxing()
    {
        this.type = MuxingType.MP4;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFilename()
    {
        return this.filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public Integer getFragmentDuration()
    {
        return this.fragmentDuration;
    }
    public void setFragmentDuration(Integer fragmentDuration)
    {
        this.fragmentDuration = fragmentDuration;
    }
}
