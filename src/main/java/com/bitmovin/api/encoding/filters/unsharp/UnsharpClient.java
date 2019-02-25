package com.bitmovin.api.encoding.filters.unsharp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface UnsharpClient {
    
    @RequestLine("POST /encoding/filters/unsharp")
    UnsharpFilter create(UnsharpFilter unsharpFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/unsharp/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/unsharp/{filter_id}")
    UnsharpFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/unsharp")
    List<UnsharpFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
