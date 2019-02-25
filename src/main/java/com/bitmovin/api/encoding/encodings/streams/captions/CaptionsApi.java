package com.bitmovin.api.encoding.encodings.streams.captions;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.captions.cea.CeaApi;


public class CaptionsApi
{
    public CeaApi cea;

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
    }

}
