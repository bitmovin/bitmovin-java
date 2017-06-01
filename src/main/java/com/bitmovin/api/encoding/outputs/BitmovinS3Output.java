package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.enums.AwsCloudRegion;

/**
 * Created by Dominic Miglar [dominic.miglar@bitmovin.com] on 9/1/16 at 6:18 PM.
 */

public class BitmovinS3Output extends Output
{
    private String name;
    private AwsCloudRegion cloudRegion;

    public BitmovinS3Output()
    {
        super();
        this.setType(OutputType.BITMOVIN_S3);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AwsCloudRegion getCloudRegion()
    {
        return this.cloudRegion;
    }

    public void setCloudRegion(AwsCloudRegion cloudRegion)
    {
        this.cloudRegion = cloudRegion;
    }
}
