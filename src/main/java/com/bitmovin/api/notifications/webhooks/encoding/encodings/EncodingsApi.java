package com.bitmovin.api.notifications.webhooks.encoding.encodings;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.webhooks.encoding.encodings.finished.FinishedApi;
import com.bitmovin.api.notifications.webhooks.encoding.encodings.error.ErrorApi;


public class EncodingsApi
{
    public FinishedApi finished;
    public ErrorApi error;

    public EncodingsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EncodingsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EncodingsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        finished = new FinishedApi(clientFactory);
        error = new ErrorApi(clientFactory);
    }

}
