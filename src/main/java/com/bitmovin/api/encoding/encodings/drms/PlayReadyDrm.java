package com.bitmovin.api.encoding.encodings.drms;

import com.bitmovin.api.encoding.encodings.drms.enums.PlayReadyEncryptionMethod;

/**
 * Created by doweinberger on 8/16/16.
 */
public class PlayReadyDrm extends Drm
{
    private String keySeed;
    private String laUrl;
    private PlayReadyEncryptionMethod method;
    private String kid;
    private String pssh;

    public String getKeySeed()
    {
        return this.keySeed;
    }

    public void setKeySeed(String keySeed)
    {
        this.keySeed = keySeed;
    }

    public String getLaUrl()
    {
        return this.laUrl;
    }

    public void setLaUrl(String laUrl)
    {
        this.laUrl = laUrl;
    }

    public PlayReadyEncryptionMethod getMethod()
    {
        return this.method;
    }

    public void setMethod(PlayReadyEncryptionMethod method)
    {
        this.method = method;
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
