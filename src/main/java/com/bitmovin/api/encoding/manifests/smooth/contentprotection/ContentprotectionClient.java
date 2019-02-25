package com.bitmovin.api.encoding.manifests.smooth.contentprotection;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ContentprotectionClient {
    
    @RequestLine("POST /encoding/manifests/smooth/{manifest_id}/contentprotection")
    SmoothManifestContentProtection create(@Param("manifest_id") String manifestId, SmoothManifestContentProtection smoothManifestContentProtection) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/manifests/smooth/{manifest_id}/contentprotection/{protection_id}")
    BitmovinResponse delete(@Param("manifest_id") String manifestId, @Param("protection_id") String protectionId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/contentprotection/{protection_id}")
    SmoothManifestContentProtection get(@Param("manifest_id") String manifestId, @Param("protection_id") String protectionId) throws BitmovinException;
    
    @RequestLine("GET /encoding/manifests/smooth/{manifest_id}/contentprotection")
    List<SmoothManifestContentProtection> list(@Param("manifest_id") String manifestId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
