package com.bitmovin.api.encoding.encodings.streams;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StreamsClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/streams")
    Stream create(@Param("encoding_id") String encodingId, Stream stream) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/streams/{stream_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams/{stream_id}")
    Stream get(@Param("encoding_id") String encodingId, @Param("stream_id") String streamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/streams")
    List<Stream> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
