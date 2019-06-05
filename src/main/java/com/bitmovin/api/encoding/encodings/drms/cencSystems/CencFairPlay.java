package com.bitmovin.api.encoding.encodings.drms.cencSystems;

public class CencFairPlay
{
    private String iv;
    private String uri;

    public CencFairPlay()
    {
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
