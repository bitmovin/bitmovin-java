package com.bitmovin.api.notifications.emails.encoding.encodings;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EncodingsClient {
    
    @RequestLine("GET /notifications/emails/encoding/encodings/{encoding_id}")
    List<EmailNotificationWithStreamConditions> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
