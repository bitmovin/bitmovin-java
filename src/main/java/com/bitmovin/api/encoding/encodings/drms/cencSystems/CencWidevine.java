package com.bitmovin.api.encoding.encodings.drms.cencSystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atrattnig on 8/26/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CencWidevine
{
    private String pssh;

    public CencWidevine()
    {

    }
    public CencWidevine(String pssh)
    {
        this.pssh = pssh;
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
