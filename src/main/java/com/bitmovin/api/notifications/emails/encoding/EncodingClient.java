package com.bitmovin.api.notifications.emails.encoding;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EncodingClient {
    
    @RequestLine("GET /notifications/emails/encoding")
    List<EmailNotification> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
