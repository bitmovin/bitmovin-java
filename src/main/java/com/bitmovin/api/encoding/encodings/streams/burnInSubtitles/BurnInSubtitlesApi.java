package com.bitmovin.api.encoding.encodings.streams.burnInSubtitles;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.burnInSubtitles.srt.SrtApi;


public class BurnInSubtitlesApi
{
    public SrtApi srt;

    public BurnInSubtitlesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public BurnInSubtitlesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public BurnInSubtitlesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        srt = new SrtApi(clientFactory);
    }

}
