package com.bitmovin.api.encoding.manifest.dash;

import com.bitmovin.api.encoding.enums.DashMuxingType;

/**
 * Created by Raul Vecchione on 11.06.19.
 */

public class DashMP4Representation extends DashRepresentation
{
    private String muxingId;

    private String encodingId;

    private String filePath;


    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }

    public String getFilePath()
    {
        return this.filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
}