package com.bitmovin.api.encoding.manifests.hls.streams;

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
    
    @RequestLine("POST /encoding/manifests/hls/{manifest_id}/streams")
    StreamInfo create(@Param("manifest_id") String manifestId, StreamInfo streamInfo) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/hls/{manifest_id}/streams/{stream_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/streams/{stream_id}")
    StreamInfo get(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/streams")
    List<StreamInfo> list(@Param("manifest_id") String manifestId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
