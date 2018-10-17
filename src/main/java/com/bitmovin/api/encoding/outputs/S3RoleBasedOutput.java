package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.enums.AwsCloudRegion;

/**
 * Created by
 * Fabre Lambeau [fabre.lambeau@bitmovin.com]
 * on 17.10.18.
 **/
public class S3RoleBasedOutput extends Output
{
    private String roleArn;
    private String bucketName;
    private AwsCloudRegion cloudRegion;

    public S3RoleBasedOutput()
    {
        super();
        this.setType(OutputType.S3);
    }

    public String getRoleArn()
    {
        return this.roleArn;
    }

    public void setRoleArn(String roleArn)
    {
        this.roleArn = roleArn;
    }

    public String getBucketName()
    {
        return this.bucketName;
    }

    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
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
