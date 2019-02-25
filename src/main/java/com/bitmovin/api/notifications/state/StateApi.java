package com.bitmovin.api.notifications.state;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateApi
{
    private final StateClient apiClient;

    public StateApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public StateApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public StateApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(StateClient.class);

    }

    /**
    * List Notification State History (Specific Resource)
    * 
    * @param notificationId Id of the notification (required)
    * @param resourceId Id of the resource, e.g. encoding id (required)
    * @return List&lt;NotificationStateEntry&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<NotificationStateEntry> list(String notificationId, String resourceId) throws BitmovinException
    {
        return this.apiClient.list(notificationId, resourceId, new HashMap<String, Object>());
    }

    /**
    * List Notification State History (Specific Resource)
    * 
    * @param notificationId Id of the notification (required)
    * @param resourceId Id of the resource, e.g. encoding id (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;NotificationStateEntry&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<NotificationStateEntry> list(String notificationId, String resourceId, NotificationStateEntrysListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(notificationId, resourceId, queryParams);
    }
}
