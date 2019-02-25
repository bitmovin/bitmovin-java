package com.bitmovin.api.encoding.encodings.streams.captions.cea;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.encodings.streams.captions.cea.scc.SccApi;


public class CeaApi
{
    public SccApi scc;

    public CeaApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CeaApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CeaApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        scc = new SccApi(clientFactory);
    }

}
