package com.bitmovin.api.encoding.manifests.smooth.representations;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.manifests.smooth.representations.mp4.Mp4Api;


public class RepresentationsApi
{
    public Mp4Api mp4;

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

        mp4 = new Mp4Api(clientFactory);
    }

}
