package com.bitmovin.api.notifications.emails.encoding;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.emails.encoding.encodings.EncodingsApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingApi
{
    private final EncodingClient apiClient;
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

        this.apiClient = clientFactory.createApiClient(EncodingClient.class);

        encodings = new EncodingsApi(clientFactory);
    }

    /**
    * List Email Notifications (All Encodings)
    * 
    * @return List&lt;EmailNotification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EmailNotification> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List Email Notifications (All Encodings)
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EmailNotification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EmailNotification> list(EmailNotificationsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
