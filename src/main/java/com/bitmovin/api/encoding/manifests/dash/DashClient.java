package com.bitmovin.api.encoding.manifests.dash;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DashClient {
    
    @RequestLine("POST /encoding/manifests/dash")
    DashManifest create(DashManifest dashManifest) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/dash/{manifest_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}")
    DashManifest get(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash")
    List<DashManifest> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/start")
    BitmovinResponse start(@Param("manifest_id") String manifestId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/dash/{manifest_id}/status")
    Task status(@Param("manifest_id") String manifestId) throws BitmovinException;
    @Headers("Content-Type: text/plain")
    @Body(" ")
    
    @RequestLine("POST /encoding/manifests/dash/{manifest_id}/stop")
    BitmovinResponse stop(@Param("manifest_id") String manifestId) throws BitmovinException;
}
