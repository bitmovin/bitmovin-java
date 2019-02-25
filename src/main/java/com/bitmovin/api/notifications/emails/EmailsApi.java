package com.bitmovin.api.notifications.emails;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.emails.encoding.EncodingApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailsApi
{
    private final EmailsClient apiClient;
    public EncodingApi encoding;

    public EmailsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public EmailsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public EmailsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(EmailsClient.class);

        encoding = new EncodingApi(clientFactory);
    }

    /**
    * List Email Notifications
    * 
    * @return List&lt;Notification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Notification> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Email Notifications
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Notification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Notification> list(NotificationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
