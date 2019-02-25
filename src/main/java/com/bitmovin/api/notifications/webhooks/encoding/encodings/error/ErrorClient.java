package com.bitmovin.api.notifications.webhooks.encoding.encodings.error;

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
    
    @RequestLine("POST /notifications/webhooks/encoding/encodings/error")
    Webhook create(Webhook webhook) throws BitmovinException;
    
    @RequestLine("POST /notifications/webhooks/encoding/encodings/{encoding_id}/error")
    Webhook createbyEncodingId(@Param("encoding_id") String encodingId, Webhook webhook) throws BitmovinException;
    
    @RequestLine("DELETE /notifications/webhooks/encoding/encodings/{encoding_id}/error/{webhook_id}")
    BitmovinResponse deleteByEncodingIdAndWebhookId(@Param("encoding_id") String encodingId, @Param("webhook_id") String webhookId) throws BitmovinException;
    
    @RequestLine("DELETE /notifications/webhooks/encoding/encodings/error/{webhook_id}")
    BitmovinResponse deleteByWebhookId(@Param("webhook_id") String webhookId) throws BitmovinException;
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/{encoding_id}/error/{webhook_id}")
    Webhook getByEncodingIdAndWebhookId(@Param("encoding_id") String encodingId, @Param("webhook_id") String webhookId) throws BitmovinException;
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/error/{webhook_id}")
    Webhook getByWebhookId(@Param("webhook_id") String webhookId) throws BitmovinException;
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/error")
    List<Webhook> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("GET /notifications/webhooks/encoding/encodings/{encoding_id}/error")
    List<Webhook> listByEncodingId(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
