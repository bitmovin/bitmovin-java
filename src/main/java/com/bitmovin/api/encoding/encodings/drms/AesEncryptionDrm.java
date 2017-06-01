package com.bitmovin.api.encoding.encodings.drms;

import com.bitmovin.api.encoding.encodings.drms.enums.AESEncryptionMethod;

/**
 * Created by doweinberger on 8/16/16.
 */
public class AesEncryptionDrm extends Drm
{
    private String key;
    private String iv;
    private String keyFileUri;

    private AESEncryptionMethod method;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getIv()
    {
        return this.iv;
    }

    public void setIv(String iv)
    {
        this.iv = iv;
    }

    public String getKeyFileUri()
    {
        return this.keyFileUri;
    }

    public void setKeyFileUri(String keyFileUri)
    {
        this.keyFileUri = keyFileUri;
    }

    public AESEncryptionMethod getMethod()
    {
        return this.method;
    }

    public void setMethod(AESEncryptionMethod method)
    {
        this.method = method;
    }
}
