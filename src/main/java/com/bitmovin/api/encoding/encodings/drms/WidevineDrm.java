package com.bitmovin.api.encoding.encodings.drms;

/**
 * Created by doweinberger on 8/16/16.
 */
public class WidevineDrm extends Drm
{
    private String key;
    private String kid;
    private String pssh;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKid()
    {
        return this.kid;
    }

    public void setKid(String kid)
    {
        this.kid = kid;
    }

    public String getPssh()
    {
        return this.pssh;
    }
    public void setPssh(String pssh)
    {
        this.pssh = pssh;
    }
}
