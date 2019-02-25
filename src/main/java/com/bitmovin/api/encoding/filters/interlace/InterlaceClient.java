package com.bitmovin.api.encoding.filters.interlace;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface InterlaceClient {
    
    @RequestLine("POST /encoding/filters/interlace")
    InterlaceFilter create(InterlaceFilter interlaceFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/interlace/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/interlace/{filter_id}")
    InterlaceFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/interlace")
    List<InterlaceFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
