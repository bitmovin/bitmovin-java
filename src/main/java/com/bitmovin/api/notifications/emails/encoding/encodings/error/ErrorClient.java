package com.bitmovin.api.notifications.emails.encoding.encodings.error;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ErrorClient {
    
    @RequestLine("POST /notifications/emails/encoding/encodings/error")
    List<EncodingErrorEmailNotification> create(EncodingErrorEmailNotification encodingErrorEmailNotification) throws BitmovinException;
    
    @RequestLine("POST /notifications/emails/encoding/encodings/{encoding_id}/error")
    EmailNotification createByEncodingId(@Param("encoding_id") String encodingId, EmailNotification emailNotification) throws BitmovinException;
    
    @RequestLine("PUT /notifications/emails/encoding/encodings/error/{notification_id}")
    EmailNotification putNotificationsEmailsEncodingEncodingsErrorByNotificationId(@Param("notification_id") String notificationId, EmailNotification emailNotification) throws BitmovinException;
}
