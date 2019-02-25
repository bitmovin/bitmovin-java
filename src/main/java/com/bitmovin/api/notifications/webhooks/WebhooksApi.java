package com.bitmovin.api.notifications.webhooks;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.webhooks.encoding.EncodingApi;


public class WebhooksApi
{
    public EncodingApi encoding;

    public WebhooksApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public WebhooksApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public WebhooksApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        encoding = new EncodingApi(clientFactory);
    }

}
