package com.bitmovin.api.notifications.webhooks.encoding.encodings.error.customdata;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomdataApi
{
    private final CustomdataClient apiClient;

    public CustomdataApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public CustomdataApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public CustomdataApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(CustomdataClient.class);

    }


    /**
    * Encoding Error Webhook Custom Data for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @param webhookId Id of the webhook (required)
    * @return CustomData
    * @throws BitmovinException if fails to make API call
    */
    public CustomData getCustomDataByEncodingIdAndWebhookId(String encodingId, String webhookId) throws BitmovinException
    {
        return this.apiClient.getCustomDataByEncodingIdAndWebhookId(encodingId, webhookId);
    }

    /**
    * Encoding Error Webhook Custom Data
    * 
    * @param webhookId Id of the webhook (required)
    * @return CustomData
    * @throws BitmovinException if fails to make API call
    */
    public CustomData getCustomDataByWebhookId(String webhookId) throws BitmovinException
    {
        return this.apiClient.getCustomDataByWebhookId(webhookId);
    }
}
