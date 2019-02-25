package com.bitmovin.api.notifications.webhooks.encoding.encodings.error.customdata;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomdataClient {
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/{encoding_id}/error/{webhook_id}/customData")
    CustomData getCustomDataByEncodingIdAndWebhookId(@Param("encoding_id") String encodingId, @Param("webhook_id") String webhookId) throws BitmovinException;
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/error/{webhook_id}/customData")
    CustomData getCustomDataByWebhookId(@Param("webhook_id") String webhookId) throws BitmovinException;
}
