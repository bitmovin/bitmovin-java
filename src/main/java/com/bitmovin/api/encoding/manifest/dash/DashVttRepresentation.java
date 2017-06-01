package com.bitmovin.api.encoding.manifest.dash;

/**
 * Created by arudich on 01.02.17.
 **/
public class DashVttRepresentation extends DashRepresentation
{
    private String vttUrl;


    public String getVttUrl() { return this.vttUrl; }

    public void setVttUrl(String vttUrl) { this.vttUrl = vttUrl; }
}
