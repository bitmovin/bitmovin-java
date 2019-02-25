package com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.vtt.VttApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.sidecar.SidecarApi;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.fmp4.Fmp4Api;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.mp4.Mp4Api;
import com.bitmovin.api.encoding.manifests.dash.periods.adaptationsets.representations.webm.WebmApi;


public class RepresentationsApi
{
    public VttApi vtt;
    public SidecarApi sidecar;
    public Fmp4Api fmp4;
    public Mp4Api mp4;
    public WebmApi webm;

    public RepresentationsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public RepresentationsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public RepresentationsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        vtt = new VttApi(clientFactory);
        sidecar = new SidecarApi(clientFactory);
        fmp4 = new Fmp4Api(clientFactory);
        mp4 = new Mp4Api(clientFactory);
        webm = new WebmApi(clientFactory);
    }

}
