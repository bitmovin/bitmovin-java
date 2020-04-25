package com.bitmovin.api.encoding.inputs;

import com.bitmovin.api.encoding.S3SignatureVersion;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dmoser on 02.02.17.
 */
public class GenericS3Input extends Input
{
    private String accessKey;
    private String secretKey;
    private String bucketName;
    private String host;
    private Integer port;

    @JsonProperty(value = "signatureVersion")
    private S3SignatureVersion signatureVersion;

    @JsonProperty(value = "ssl")
    private Boolean ssl;

    public GenericS3Input()
    {
        super();
        this.setType(InputType.GENERIC_S3);
    }

    public String getAccessKey()
    {
        return this.accessKey;
    }

    public void setAccessKey(String accessKey)
    {
        this.accessKey = accessKey;
    }

    public String getSecretKey()
    {
        return this.secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public String getBucketName()
    {
        return this.bucketName;
    }

    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }

    public String getHost()
    {
        return this.host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public Integer getPort()
    {
        return this.port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public S3SignatureVersion getSignatureVersion()
    {
        return this.signatureVersion;
    }

    public void setSignatureVersion(S3SignatureVersion signatureVersion)
    {
        this.signatureVersion = signatureVersion;
    }

    public Boolean getSsl()
    {
        return this.ssl;
    }

    public void setSsl(Boolean ssl)
    {
        this.ssl = ssl;
    }
}
