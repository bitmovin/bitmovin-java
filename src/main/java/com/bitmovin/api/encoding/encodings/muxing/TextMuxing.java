package com.bitmovin.api.encoding.encodings.muxing;

import com.bitmovin.api.encoding.encodings.muxing.enums.FragmentedMP4MuxingManifestType;
import com.bitmovin.api.encoding.encodings.muxing.enums.MuxingType;

/**
 * Created by gfronza on 7/3/19.
 */
public class TextMuxing extends Muxing {

    private String name;
    private String filename;

    public TextMuxing()
    {
        this.type = MuxingType.TEXT;
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
}