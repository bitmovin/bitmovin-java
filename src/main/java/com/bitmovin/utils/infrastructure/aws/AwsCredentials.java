package com.bitmovin.utils.infrastructure.aws;

import com.bitmovin.utils.auth.Credentials;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 4/20/16
 */
public class AwsCredentials extends Credentials
{
    private Long id;

    public String accessKey;

    public String secretKey;

    public AwsCredentials()
    {

    }

    public AwsCredentials(String accessKey, String secretKey)
    {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
}
