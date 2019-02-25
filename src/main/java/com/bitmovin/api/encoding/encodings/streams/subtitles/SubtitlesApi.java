package com.bitmovin.api.encoding.encodings.streams.subtitles;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.subtitles.dvbsub.DvbsubApi;


public class SubtitlesApi
{
    public DvbsubApi dvbsub;

    public SubtitlesApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SubtitlesApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SubtitlesApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        dvbsub = new DvbsubApi(clientFactory);
    }

}
