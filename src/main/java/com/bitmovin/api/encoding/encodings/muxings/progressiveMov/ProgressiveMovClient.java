package com.bitmovin.api.encoding.encodings.muxings.progressiveMov;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ProgressiveMovClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/progressive-mov")
    ProgressiveMovMuxing create(@Param("encoding_id") String encodingId, ProgressiveMovMuxing progressiveMovMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/progressive-mov/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-mov/{muxing_id}")
    ProgressiveMovMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-mov")
    List<ProgressiveMovMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
