package com.bitmovin.api.notifications.emails.encoding.encodings.liveInputStreamChanged;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LiveInputStreamChangedClient {
    
    @RequestLine("POST /notifications/emails/encoding/encodings/live-input-stream-changed")
    EmailNotificationWithStreamConditions create(EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException;
    
    @RequestLine("POST /notifications/emails/encoding/encodings/{encoding_id}/live-input-stream-changed")
    EmailNotificationWithStreamConditions createByEncodingId(@Param("encoding_id") String encodingId, EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException;
    
    @RequestLine("PUT /notifications/emails/encoding/encodings/live-input-stream-changed/{notification_id}")
    EmailNotificationWithStreamConditions putNotificationsEmailsEncodingEncodingsLiveInputStreamChangedByInputId(@Param("notification_id") String notificationId, EmailNotificationWithStreamConditions emailNotificationWithStreamConditions) throws BitmovinException;
}
