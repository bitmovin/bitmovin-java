package com.bitmovin.api.encoding.manifests;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ManifestsClient {
    
    @RequestLine("GET /encoding/manifests")
    List<Manifest> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
