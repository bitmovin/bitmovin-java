package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.enums.GoogleCloudRegion;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 6:31 PM.
 */
public class BitmovinGcsOutput extends Output
{
    private String name;
    private GoogleCloudRegion cloudRegion;

    public BitmovinGcsOutput()
    {
        super();
        this.setType(OutputType.BITMOVIN_GCS);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public GoogleCloudRegion getCloudRegion()
    {
        return this.cloudRegion;
    }

    public void setCloudRegion(GoogleCloudRegion cloudRegion)
    {
        this.cloudRegion = cloudRegion;
    }
}
