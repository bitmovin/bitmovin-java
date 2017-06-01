package com.bitmovin.api.encoding.encodings.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmoser on 19.09.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartLiveEncodingRequest
{
    private String streamKey;
    private List<LiveHlsManifest> hlsManifests = new ArrayList<>();
    private List<LiveDashManifest> dashManifests = new ArrayList<>();

    public String getStreamKey()
    {
        return this.streamKey;
    }

    public void setStreamKey(String streamKey)
    {
        this.streamKey = streamKey;
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
