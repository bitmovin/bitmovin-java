package com.bitmovin.api.encoding.filters.rotate;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface RotateClient {
    
    @RequestLine("POST /encoding/filters/rotate")
    RotateFilter create(RotateFilter rotateFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/rotate/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/rotate/{filter_id}")
    RotateFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/rotate")
    List<RotateFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
