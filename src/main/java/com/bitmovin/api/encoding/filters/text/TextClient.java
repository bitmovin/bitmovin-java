package com.bitmovin.api.encoding.filters.text;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TextClient {
    
    @RequestLine("POST /encoding/filters/text")
    TextFilter create(TextFilter textFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/text/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/text/{filter_id}")
    TextFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/text")
    List<TextFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
