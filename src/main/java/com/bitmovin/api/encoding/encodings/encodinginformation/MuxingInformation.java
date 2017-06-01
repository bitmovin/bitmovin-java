package com.bitmovin.api.encoding.encodings.encodinginformation;

/**
 * Created by doweinberger on 8/4/16.
 */

public class MuxingInformation
{
    private Integer id;
    private String muxingId;

    private EncodingDetails encodingDetails;

    public String getMuxingId()
    {
        return this.muxingId;
    }

    public void setMuxingId(String muxingId)
    {
        this.muxingId = muxingId;
    }

    public EncodingDetails getEncodingDetails()
    {
        return this.encodingDetails;
    }

    public void setEncodingDetails(EncodingDetails encodingDetails)
    {
        this.encodingDetails = encodingDetails;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
