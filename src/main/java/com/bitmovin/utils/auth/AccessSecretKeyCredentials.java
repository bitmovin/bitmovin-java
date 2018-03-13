package com.bitmovin.utils.auth;

/**
 * Created by chris on 12/01/16.
 */
public class AccessSecretKeyCredentials extends Credentials
{
    public static final String ACCESSKEY = "AccessKey";
    public static final String SECRETKEY = "SecretKey";

    public AccessSecretKeyCredentials (String accessKey, String secretKey)
    {
        this.addCredentials(ACCESSKEY, accessKey);
        this.addCredentials(SECRETKEY, secretKey);
    }

    public String getAccessKey ()
    {
        return this.credentials.get(ACCESSKEY);
    }

    public String getSecretKey ()
    {
        return this.credentials.get(SECRETKEY);
    }
}
