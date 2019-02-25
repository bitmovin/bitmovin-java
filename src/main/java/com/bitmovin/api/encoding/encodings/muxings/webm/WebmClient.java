package com.bitmovin.api.encoding.encodings.muxings.webm;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface WebmClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/webm")
    WebmMuxing create(@Param("encoding_id") String encodingId, WebmMuxing webmMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/webm/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/webm/{muxing_id}")
    WebmMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/webm")
    List<WebmMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
