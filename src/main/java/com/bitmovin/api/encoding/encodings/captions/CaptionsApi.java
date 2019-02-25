package com.bitmovin.api.encoding.encodings.captions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.captions.cea.CeaApi;
import com.bitmovin.api.encoding.encodings.captions.webvtt.WebvttApi;
import com.bitmovin.api.encoding.encodings.captions.ttml.TtmlApi;
import com.bitmovin.api.encoding.encodings.captions.scc.SccApi;


public class CaptionsApi
{
    public CeaApi cea;
    public WebvttApi webvtt;
    public TtmlApi ttml;
    public SccApi scc;

    public CaptionsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CaptionsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CaptionsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        cea = new CeaApi(clientFactory);
        webvtt = new WebvttApi(clientFactory);
        ttml = new TtmlApi(clientFactory);
        scc = new SccApi(clientFactory);
    }

}
