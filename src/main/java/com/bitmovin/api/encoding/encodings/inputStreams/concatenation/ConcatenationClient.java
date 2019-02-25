package com.bitmovin.api.encoding.encodings.inputStreams.concatenation;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ConcatenationClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/input-streams/concatenation")
    ConcatenationInputStream create(@Param("encoding_id") String encodingId, ConcatenationInputStream concatenationInputStream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/input-streams/concatenation/{input_stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/concatenation/{input_stream_id}")
    ConcatenationInputStream get(@Param("encoding_id") String encodingId, @Param("input_stream_id") String inputStreamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/input-streams/concatenation")
    List<ConcatenationInputStream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
