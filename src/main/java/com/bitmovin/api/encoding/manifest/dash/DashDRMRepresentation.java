package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by doweinberger on 8/29/16.
 **/
public class DashDRMRepresentation extends DashFmp4Representation
{
    private String drmId;

    public String getDrmId()
    {
        return this.drmId;
    }

    public void setDrmId(String drmId)
    {
        this.drmId = drmId;
    }
}
