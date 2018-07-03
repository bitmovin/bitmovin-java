package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.encoding.encodings.live.LiveDashManifest;
import com.bitmovin.api.encoding.encodings.live.LiveHlsManifest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartEncodingRequest
{
    private Trimming trimming;
    private List<LiveHlsManifest>  hlsManifests  = new ArrayList<>();
    private List<LiveDashManifest> dashManifests = new ArrayList<>();
    private PerTitle perTitle;
    private EncodingMode encodingMode = EncodingMode.STANDARD;

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

    public PerTitle getPerTitle()
    {
        return this.perTitle;
    }

    public void setPerTitle(PerTitle perTitle)
    {
        this.perTitle = perTitle;
    }

    public EncodingMode getEncodingMode()
    {
        return this.encodingMode;
    }

    public void setEncodingMode(EncodingMode encodingMode)
    {
        this.encodingMode = encodingMode;
    }
}
