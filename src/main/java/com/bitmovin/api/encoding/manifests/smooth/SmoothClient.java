package com.bitmovin.api.encoding.manifests.smooth;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface SmoothClient {
    
    @RequestLine("POST /encoding/manifests/smooth")
    SmoothStreamingManifest create(SmoothStreamingManifest smoothStreamingManifest) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/smooth/{manifest_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}")
    SmoothStreamingManifest get(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth")
    List<SmoothStreamingManifest> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/manifests/smooth/{manifest_id}/start")
    BitmovinResponse start(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/status")
    Task status(@Param("manifest_id") String manifestId) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/manifests/smooth/{manifest_id}/stop")
    BitmovinResponse stop(@Param("manifest_id") String manifestId) throws BitmovinException;
}
