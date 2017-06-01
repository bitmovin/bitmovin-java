package com.bitmovin.api.encoding.manifest.hls;

/**
 * Created by arudich on 11.01.17.
 **/
public class SubtitlesMediaInfo extends StandardMediaInfo
{
    private Boolean forced;

    public Boolean getForced() { return this.forced; }

    public void setForced(Boolean forced) { this.forced = forced; }
}
