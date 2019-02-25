package com.bitmovin.api.encoding.encodings.muxings.broadcastTs;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface BroadcastTsClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/broadcast-ts")
    BroadcastTsMuxing create(@Param("encoding_id") String encodingId, BroadcastTsMuxing broadcastTsMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/broadcast-ts/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/broadcast-ts/{muxing_id}")
    BroadcastTsMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/broadcast-ts")
    List<BroadcastTsMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
