package com.bitmovin.api.notifications.emails.encoding.encodings;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.notifications.emails.encoding.encodings.liveInputStreamChanged.LiveInputStreamChangedApi;
import com.bitmovin.api.notifications.emails.encoding.encodings.error.ErrorApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingsApi
{
    private final EncodingsClient apiClient;
    public LiveInputStreamChangedApi liveInputStreamChanged;
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

        this.apiClient = clientFactory.createApiClient(EncodingsClient.class);

        liveInputStreamChanged = new LiveInputStreamChangedApi(clientFactory);
        error = new ErrorApi(clientFactory);
    }

    /**
    * List Email Notifications (Specific Encoding)
    * 
    * @param encodingId Id of the encoding resource (required)
    * @return List&lt;EmailNotificationWithStreamConditions&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EmailNotificationWithStreamConditions> list(String encodingId) throws BitmovinException
    {
        return this.apiClient.list(encodingId, new HashMap<String, Object>());
    }

    /**
    * List Email Notifications (Specific Encoding)
    * 
    * @param encodingId Id of the encoding resource (required)
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;EmailNotificationWithStreamConditions&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EmailNotificationWithStreamConditions> list(String encodingId, EmailNotificationWithStreamConditionssListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(encodingId, queryParams);
    }
}
