package com.bitmovin.api.encoding.manifests.smooth.representations.mp4;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface Mp4Client {
    
    @RequestLine("POST /encoding/manifests/smooth/{manifest_id}/representations/mp4")
    SmoothStreamingRepresentation create(@Param("manifest_id") String manifestId, SmoothStreamingRepresentation smoothStreamingRepresentation) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/smooth/{manifest_id}/representations/mp4/{representation_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/representations/mp4/{representation_id}")
    SmoothStreamingRepresentation get(@Param("manifest_id") String manifestId, @Param("representation_id") String representationId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/representations/mp4")
    List<SmoothStreamingRepresentation> list(@Param("manifest_id") String manifestId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
