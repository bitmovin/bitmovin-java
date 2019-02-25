package com.bitmovin.api.encoding.encodings;

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
    
    @RequestLine("POST /encoding/encodings")
    Encoding create(Encoding encoding) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}")
    Encoding get(@Param("encoding_id") String encodingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/start")
    StartEncodingRequest getStartRequest(@Param("encoding_id") String encodingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings")
    List<Encoding> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/reprioritize")
    BitmovinResponse reprioritize(@Param("encoding_id") String encodingId, ReprioritizeEncodingRequest reprioritizeEncodingRequest) throws BitmovinException;
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/reschedule")
    BitmovinResponse reschedule(@Param("encoding_id") String encodingId, RescheduleEncodingRequest rescheduleEncodingRequest) throws BitmovinException;
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/start")
    StartEncodingRequest start(@Param("encoding_id") String encodingId, StartEncodingRequest startEncodingRequest) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/status")
    Task status(@Param("encoding_id") String encodingId) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/stop")
    BitmovinResponse stop(@Param("encoding_id") String encodingId) throws BitmovinException;
}
