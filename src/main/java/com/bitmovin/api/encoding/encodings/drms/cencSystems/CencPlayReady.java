package com.bitmovin.api.encoding.encodings.drms.cencSystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by atrattnig on 8/26/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CencPlayReady
{
    private String laUrl;

    public CencPlayReady()
    {

    }
    public CencPlayReady(String laUrl)
    {
        this.laUrl = laUrl;
    }

    public String getLaUrl()
    {
        return this.laUrl;
    }
    public void setLaUrl(String laUrl)
    {
        this.laUrl = laUrl;
    }
}
