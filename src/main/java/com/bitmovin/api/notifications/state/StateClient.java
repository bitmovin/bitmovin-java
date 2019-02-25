package com.bitmovin.api.notifications.state;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StateClient {
    
    @RequestLine("GET /notifications/{notification_id}/state/{resource_id}")
    List<NotificationStateEntry> list(@Param("notification_id") String notificationId, @Param("resource_id") String resourceId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
