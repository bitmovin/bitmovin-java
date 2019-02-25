package com.bitmovin.api.notifications;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.webhooks.WebhooksApi;
import com.bitmovin.api.notifications.state.StateApi;
import com.bitmovin.api.notifications.emails.EmailsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationsApi
{
    private final NotificationsClient apiClient;
    public WebhooksApi webhooks;
    public StateApi state;
    public EmailsApi emails;

    public NotificationsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public NotificationsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public NotificationsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(NotificationsClient.class);

        webhooks = new WebhooksApi(clientFactory);
        state = new StateApi(clientFactory);
        emails = new EmailsApi(clientFactory);
    }


    /**
    * Delete Notification
    * 
    * @param notificationId Id of the notification (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse delete(String notificationId) throws BitmovinException
    {
        return this.apiClient.delete(notificationId);
    }

    /**
    * Get Notification
    * 
    * @param notificationId Id of the notification (required)
    * @return Notification
    * @throws BitmovinException if fails to make API call
    */
    public Notification get(String notificationId) throws BitmovinException
    {
        return this.apiClient.get(notificationId);
    }
    /**
    * List Notifications
    * 
    * @return List&lt;Notification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Notification> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Notifications
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Notification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Notification> list(NotificationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
    /**
    * List Notification State History (All Resources)
    * 
    * @param notificationId Id of the notification (required)
    * @return List&lt;NotificationStateEntry&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<NotificationStateEntry> listByNotificationId(String notificationId) throws BitmovinException
    {
        return this.apiClient.listByNotificationId(notificationId, new HashMap<String, Object>());
    }

    /**
    * List Notification State History (All Resources)
    * 
    * @param notificationId Id of the notification (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;NotificationStateEntry&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<NotificationStateEntry> listByNotificationId(String notificationId, NotificationStateEntrysListByNotificationIdQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.listByNotificationId(notificationId, queryParams);
    }

    /**
    * Mute Notification
    * 
    * @param notificationId Id of the notification (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse mute(String notificationId) throws BitmovinException
    {
        return this.apiClient.mute(notificationId);
    }

    /**
    * Unmute Notification
    * 
    * @param notificationId Id of the notification (required)
    * @return BitmovinResponse
    * @throws BitmovinException if fails to make API call
    */
    public BitmovinResponse unmute(String notificationId) throws BitmovinException
    {
        return this.apiClient.unmute(notificationId);
    }
}
