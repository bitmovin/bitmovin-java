package com.bitmovin.api.encoding.encodings.muxings.fmp4.captions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.webvtt.WebvttApi;
import com.bitmovin.api.encoding.encodings.muxings.fmp4.captions.ttml.TtmlApi;


public class CaptionsApi
{
    public WebvttApi webvtt;
    public TtmlApi ttml;

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

        webvtt = new WebvttApi(clientFactory);
        ttml = new TtmlApi(clientFactory);
    }

}
