package com.bitmovin.api.encoding.manifest.hls;

/**
 * Created by arudich on 11.01.17.
 **/
public abstract class StandardMediaInfo extends SegmentsMediaInfo
{
    private String uri;

    public String getUri() { return this.uri; }

    public void setUri(String uri) { this.uri = uri; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof StandardMediaInfo)) return false;
        if (!super.equals(o)) return false;

        StandardMediaInfo that = (StandardMediaInfo) o;

        return this.uri != null ? this.uri.equals(that.uri) : that.uri == null;

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (this.uri != null ? this.uri.hashCode() : 0);
        return result;
    }
}
