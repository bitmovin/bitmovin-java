package com.bitmovin.api.notifications;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface NotificationsClient {
    
    @RequestLine("DELETE /notifications/{notification_id}")
    BitmovinResponse delete(@Param("notification_id") String notificationId) throws BitmovinException;
    
    @RequestLine("GET /notifications/{notification_id}")
    Notification get(@Param("notification_id") String notificationId) throws BitmovinException;
    
    @RequestLine("GET /notifications")
    List<Notification> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("GET /notifications/{notification_id}/state")
    List<NotificationStateEntry> listByNotificationId(@Param("notification_id") String notificationId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /notifications/{notification_id}/mute")
    BitmovinResponse mute(@Param("notification_id") String notificationId) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /notifications/{notification_id}/unmute")
    BitmovinResponse unmute(@Param("notification_id") String notificationId) throws BitmovinException;
}
