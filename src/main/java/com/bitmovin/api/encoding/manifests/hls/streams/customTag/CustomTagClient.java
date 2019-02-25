package com.bitmovin.api.encoding.manifests.hls.streams.customTag;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomTagClient {
    
    @RequestLine("POST /encoding/manifests/hls/{manifest_id}/streams/{stream_id}/custom-tag")
    CustomTag create(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId, CustomTag customTag) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/hls/{manifest_id}/streams/{stream_id}/custom-tag/{custom_tag_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId, @Param("custom_tag_id") String customTagId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/streams/{stream_id}/custom-tag/{custom_tag_id}")
    CustomTag get(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId, @Param("custom_tag_id") String customTagId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/hls/{manifest_id}/streams/{stream_id}/custom-tag")
    List<CustomTag> list(@Param("manifest_id") String manifestId, @Param("stream_id") String streamId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
