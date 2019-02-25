package com.bitmovin.api.encoding.encodings.muxings.progressiveTs;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ProgressiveTsClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/muxings/progressive-ts")
    ProgressiveTsMuxing create(@Param("encoding_id") String encodingId, ProgressiveTsMuxing progressiveTsMuxing) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-ts/{muxing_id}")
    ProgressiveTsMuxing get(@Param("encoding_id") String encodingId, @Param("muxing_id") String muxingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/muxings/progressive-ts")
    List<ProgressiveTsMuxing> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
