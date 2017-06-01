package com.bitmovin.api.encoding.manifest.hls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Created by arudich on 25.01.17.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VttMediaInfo extends BasicMediaInfo
{
    private String vttUrl;

    private String uri;

    private Boolean forced;


    public String getVttUrl() { return this.vttUrl; }

    public void setVttUrl(String vttUrl) { this.vttUrl = vttUrl; }

    public String getUri() { return this.uri; }

    public void setUri(String uri) { this.uri = uri; }

    public Boolean getForced() { return this.forced; }

    public void setForced(Boolean forced) { this.forced = forced; }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof VttMediaInfo)) return false;
        if (!super.equals(o)) return false;

        VttMediaInfo that = (VttMediaInfo) o;

        if (this.vttUrl != null ? !this.vttUrl.equals(that.vttUrl) : that.vttUrl != null) return false;
        if (this.uri != null ? !this.uri.equals(that.uri) : that.uri != null) return false;
        return this.forced != null ? this.forced.equals(that.forced) : that.forced == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (this.vttUrl != null ? this.vttUrl.hashCode() : 0);
        result = 31 * result + (this.uri != null ? this.uri.hashCode() : 0);
        result = 31 * result + (this.forced != null ? this.forced.hashCode() : 0);
        return result;
    }
}
