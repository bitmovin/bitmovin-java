package com.bitmovin.api.encoding.filters.scale;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ScaleClient {
    
    @RequestLine("POST /encoding/filters/scale")
    ScaleFilter create(ScaleFilter scaleFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/scale/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/scale/{filter_id}")
    ScaleFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/scale")
    List<ScaleFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
