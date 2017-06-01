package com.bitmovin.api.encoding.encodings.transfer;

/**
 * Copied from transfer-resource-client and removed database stuff.
 **/

public class ManifestTransfer extends Transfer
{
    private String manifestId;

    public ManifestTransfer()
    {
        super();
    }

    public ManifestTransfer(String manifestId)
    {
        super();
        this.manifestId = manifestId;
    }

    public String getManifestId()
    {
        return this.manifestId;
    }

    public void setManifestId(String manifestId)
    {
        this.manifestId = manifestId;
    }
}
