package com.bitmovin.api.notifications.webhooks.encoding.encodings.error;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.webhooks.encoding.encodings.error.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorApi
{
    private final ErrorClient apiClient;
    public CustomdataApi customdata;

    public ErrorApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public ErrorApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public ErrorApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(ErrorClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Add Encoding Error Webhook
    * 
    * @param webhook  (optional)
    * @return Webhook
    * @throws BitmovinException if fails to make API call
    */
    public Webhook create(Webhook webhook) throws BitmovinException
    {
        return this.apiClient.create(webhook);
    }

    /**
    * Add Encoding Error Webhook for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @param webhook  (optional)
    * @return Webhook
    * @throws BitmovinException if fails to make API call
    */
    public Webhook createbyEncodingId(String encodingId, Webhook webhook) throws BitmovinException
    {
        return this.apiClient.createbyEncodingId(encodingId, webhook);
    }

    /**
    * Delete Encoding Error Webhook for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @param webhookId Id of the webhook (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse deleteByEncodingIdAndWebhookId(String encodingId, String webhookId) throws BitmovinException
    {
        return this.apiClient.deleteByEncodingIdAndWebhookId(encodingId, webhookId);
    }

    /**
    * Delete Encoding Error Webhook
    * 
    * @param webhookId Id of the webhook (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse deleteByWebhookId(String webhookId) throws BitmovinException
    {
        return this.apiClient.deleteByWebhookId(webhookId);
    }

    /**
    * Encoding Error Webhook Details for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @param webhookId Id of the webhook (required)
    * @return Webhook
    * @throws BitmovinException if fails to make API call
    */
    public Webhook getByEncodingIdAndWebhookId(String encodingId, String webhookId) throws BitmovinException
    {
        return this.apiClient.getByEncodingIdAndWebhookId(encodingId, webhookId);
    }

    /**
    * Encoding Error Webhook Details
    * 
    * @param webhookId Id of the webhook (required)
    * @return Webhook
    * @throws BitmovinException if fails to make API call
    */
    public Webhook getByWebhookId(String webhookId) throws BitmovinException
    {
        return this.apiClient.getByWebhookId(webhookId);
    }
    /**
    * List Encoding Error Webhooks
    * 
    * @return List&lt;Webhook&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Webhook> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Encoding Error Webhooks
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Webhook&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Webhook> list(WebhooksListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * List Encoding Error Webhooks for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @return List&lt;Webhook&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Webhook> listByEncodingId(String encodingId) throws BitmovinException
    {
        return this.apiClient.listByEncodingId(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Encoding Error Webhooks for specific Encoding Resource
    * 
    * @param encodingId Id of the encoding (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Webhook&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Webhook> listByEncodingId(String encodingId, WebhooksListByEncodingIdQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByEncodingId(encodingId, queryParams);
    }
}
