package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.encoding.encodings.live.LiveDashManifest;
import com.bitmovin.api.encoding.encodings.live.LiveHlsManifest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roland Kersche on 12/12/16.
 */
public class StartEncodingRequest
{
    private Trimming trimming;
    private List<LiveHlsManifest>  hlsManifests  = new ArrayList<>();
    private List<LiveDashManifest> dashManifests = new ArrayList<>();

    public StartEncodingRequest()
    {
    }

    public Trimming getTrimming()
    {
        return this.trimming;
    }

    public void setTrimming(Trimming trimming)
    {
        this.trimming = trimming;
    }

    public List<LiveHlsManifest> getHlsManifests()
    {
        return this.hlsManifests;
    }

    public void setHlsManifests(List<LiveHlsManifest> hlsManifests)
    {
        this.hlsManifests = hlsManifests;
    }

    public List<LiveDashManifest> getDashManifests()
    {
        return this.dashManifests;
    }

    public void setDashManifests(List<LiveDashManifest> dashManifests)
    {
        this.dashManifests = dashManifests;
    }
}
