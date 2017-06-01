package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.resource.WebhookResource;
import com.bitmovin.api.webhooks.Webhook;

import java.util.Map;

/**
 * Created by miglar on 12/22/16.
 */
public class NotificationContainer
{
    public  WebhookResource<Webhook> webhooks;

    public NotificationContainer(Map<String, String> headers)
    {
        this.webhooks = new WebhookResource<>(headers, ApiUrls.notificationWebhooks, Webhook.class);
    }
}
