package com.bitmovin.api.notifications.webhooks.encoding;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.webhooks.encoding.encodings.EncodingsApi;


public class EncodingApi
{
    public EncodingsApi encodings;

    public EncodingApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EncodingApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EncodingApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        encodings = new EncodingsApi(clientFactory);
    }

}
