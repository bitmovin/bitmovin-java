package com.bitmovin.api.encoding.manifests.type;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TypeClient {
    
    @RequestLine("GET /encoding/manifests/{manifest_id}/type")
    ManifestTypeResponse get(@Param("manifest_id") String manifestId) throws BitmovinException;
}
