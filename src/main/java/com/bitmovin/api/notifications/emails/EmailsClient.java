package com.bitmovin.api.notifications.emails;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EmailsClient {
    
    @RequestLine("GET /notifications/emails")
    List<Notification> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
