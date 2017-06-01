package com.bitmovin.api.encoding.encodings.drms;

/**
 * Created by doweinberger on 8/16/16.
 */
public class FairPlayDrm extends Drm
{
    private String key;
    private String iv;
    private String uri;

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

    public String getUri()
    {
        return this.uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }
}
