package com.bitmovin.api.encoding.encodings.transfer;

/**
 * Copied from transfer-resource-client and removed database stuff.
 **/

public class EncodingTransfer extends Transfer
{
    private String encodingId;

    public EncodingTransfer()
    {
        super();
    }

    public EncodingTransfer(String encodingId)
    {
        super();
        this.encodingId = encodingId;
    }

    public String getEncodingId()
    {
        return this.encodingId;
    }

    public void setEncodingId(String encodingId)
    {
        this.encodingId = encodingId;
    }
}
