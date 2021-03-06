package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.FragmentedMP4MuxingManifestType;
import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

/**
 * Created by doweinberger on 8/16/16.
 */
public class MP4Muxing extends Muxing
{
    private String name;

    private String filename;

    private Integer fragmentDuration;

    private FragmentedMP4MuxingManifestType fragmentedMP4MuxingManifestType;

    private TimeCode timeCode;

    private InternalChunkLength internalChunkLength;

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

    public FragmentedMP4MuxingManifestType getFragmentedMP4MuxingManifestType()
    {
        return this.fragmentedMP4MuxingManifestType;
    }

    public void setFragmentedMP4MuxingManifestType(FragmentedMP4MuxingManifestType fragmentedMP4MuxingManifestType)
    {
        this.fragmentedMP4MuxingManifestType = fragmentedMP4MuxingManifestType;
    }

    public TimeCode getTimeCode()
    {
        return this.timeCode;
    }

    public void setTimeCode(TimeCode timeCode)
    {
        this.timeCode = timeCode;
    }

    public InternalChunkLength getInternalChunkLength()
    {
        return this.internalChunkLength;
    }

    public void setInternalChunkLength(InternalChunkLength internalChunkLength)
    {
        this.internalChunkLength = internalChunkLength;
    }
}
