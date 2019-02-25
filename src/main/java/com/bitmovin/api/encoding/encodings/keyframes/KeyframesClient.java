package com.bitmovin.api.encoding.encodings.keyframes;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface KeyframesClient {
    
    @RequestLine("POST /encoding/encodings/{encoding_id}/keyframes")
    Keyframe create(@Param("encoding_id") String encodingId, Keyframe keyframe) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/encodings/{encoding_id}/keyframes/{keyframe_id}")
    BitmovinResponse delete(@Param("encoding_id") String encodingId, @Param("keyframe_id") String keyframeId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/keyframes/{keyframe_id}")
    Keyframe get(@Param("encoding_id") String encodingId, @Param("keyframe_id") String keyframeId) throws BitmovinException;
    
    @RequestLine("GET /encoding/encodings/{encoding_id}/keyframes")
    List<Keyframe> list(@Param("encoding_id") String encodingId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
