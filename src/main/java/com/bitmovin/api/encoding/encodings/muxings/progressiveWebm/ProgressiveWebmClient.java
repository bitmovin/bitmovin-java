package com.bitmovin.api.encoding.encodings.muxings.progressiveWebm;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ProgressiveWebmClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/progressive-webm")
    ProgressiveWebmMuxing create(@Param("encoding_id") String encodingId, ProgressiveWebmMuxing progressiveWebmMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/progressive-webm/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-webm/{muxing_id}")
    ProgressiveWebmMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-webm")
    List<ProgressiveWebmMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
