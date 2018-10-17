package com.bitmovin.api.encoding.inputs;

import com.bitmovin.api.enums.AwsCloudRegion;

/**
 * Created by
 * Fabre Lambeau [fabre.lambeau@bitmovin.com]
 * on 17.10.18.
 **/
public class S3RoleBasedInput extends Input
{
    private String roleArn;
    private String bucketName;
    private AwsCloudRegion cloudRegion;

    public S3RoleBasedInput()
    {
        super();
        this.setType(InputType.S3_ROLE_BASED);
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
