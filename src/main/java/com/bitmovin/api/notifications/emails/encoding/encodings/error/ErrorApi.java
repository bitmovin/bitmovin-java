package com.bitmovin.api.notifications.emails.encoding.encodings.error;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;


import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorApi
{
    private final ErrorClient apiClient;

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

    }


    /**
    * Add Encoding Error Email Notification (All Encodings)
    * 
    * @param encodingErrorEmailNotification Add a new email notification if an encoding received an error (optional)
    * @return List&lt;EncodingErrorEmailNotification&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<EncodingErrorEmailNotification> create(EncodingErrorEmailNotification encodingErrorEmailNotification) throws BitmovinException
    {
        return this.apiClient.create(encodingErrorEmailNotification);
    }

    /**
    * Add Encoding Error Email Notification (Specific Encoding)
    * 
    * @param encodingId Id of the encoding resource (required)
    * @param emailNotification The email notifications object (optional)
    * @return EmailNotification
    * @throws BitmovinException if fails to make API call
    */
    public EmailNotification createByEncodingId(String encodingId, EmailNotification emailNotification) throws BitmovinException
    {
        return this.apiClient.createByEncodingId(encodingId, emailNotification);
    }

    /**
    * Replace Encoding Error Email Notification
    * 
    * @param notificationId Id of the email notification (required)
    * @param emailNotification The email notification with the updated values (optional)
    * @return EmailNotification
    * @throws BitmovinException if fails to make API call
    */
    public EmailNotification putNotificationsEmailsEncodingEncodingsErrorByNotificationId(String notificationId, EmailNotification emailNotification) throws BitmovinException
    {
        return this.apiClient.putNotificationsEmailsEncodingEncodingsErrorByNotificationId(notificationId, emailNotification);
    }
}
