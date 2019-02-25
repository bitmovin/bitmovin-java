package com.bitmovin.api.notifications.emails.encoding.encodings.liveInputStreamChanged;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveInputStreamChangedApi
{
    private final LiveInputStreamChangedClient apiClient;

    public LiveInputStreamChangedApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public LiveInputStreamChangedApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public LiveInputStreamChangedApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(LiveInputStreamChangedClient.class);

    }


    /**
    * Add Live Input Stream Changed Email Notification (All Encodings)
    * 
    * @param emailNotificationWithStreamConditions The email notifications object (optional)
    * @return EmailNotificationWithStreamConditions
    * @throws BitmovinException if fails to make API call
    */
    public EmailNotificationWithStreamConditions create(EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException
    {
        return this.apiClient.create(emailNotificationWithStreamConditions);
    }

    /**
    * Add Live Input Stream Changed Email Notification (Specific Encoding)
    * 
    * @param encodingId Id of the encoding resource (required)
    * @param emailNotificationWithStreamConditions The email notifications object (optional)
    * @return EmailNotificationWithStreamConditions
    * @throws BitmovinException if fails to make API call
    */
    public EmailNotificationWithStreamConditions createByEncodingId(String encodingId, EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException
    {
        return this.apiClient.createByEncodingId(encodingId, emailNotificationWithStreamConditions);
    }

    /**
    * Replace Live Input Stream Changed Email Notification
    * 
    * @param notificationId Id of the email notification (required)
    * @param emailNotificationWithStreamConditions The email notification with the updated values (optional)
    * @return EmailNotificationWithStreamConditions
    * @throws BitmovinException if fails to make API call
    */
    public EmailNotificationWithStreamConditions putNotificationsEmailsEncodingEncodingsLiveInputStreamChangedByInputId(String notificationId, EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException
    {
        return this.apiClient.putNotificationsEmailsEncodingEncodingsLiveInputStreamChangedByInputId(notificationId, emailNotificationWithStreamConditions);
    }
}
