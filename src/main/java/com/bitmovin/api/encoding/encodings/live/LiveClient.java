package com.bitmovin.api.encoding.encodings.live;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LiveClient {
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/live")
    LiveEncoding get(@Param("encoding_id") String encodingId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/live/start")
    StartLiveEncodingRequest getStartRequest(@Param("encoding_id") String encodingId) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/live/restart")
    BitmovinResponse restart(@Param("encoding_id") String encodingId) throws BitmovinException;
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/live/start")
    BitmovinResponse start(@Param("encoding_id") String encodingId, StartLiveEncodingRequest startLiveEncodingRequest) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/live/stop")
    BitmovinResponse stop(@Param("encoding_id") String encodingId) throws BitmovinException;
}
