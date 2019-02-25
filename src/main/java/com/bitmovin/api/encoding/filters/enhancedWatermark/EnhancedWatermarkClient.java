package com.bitmovin.api.encoding.filters.enhancedWatermark;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface EnhancedWatermarkClient {
    
    @RequestLine("POST /encoding/filters/enhanced-watermark")
    EnhancedWatermarkFilter create(EnhancedWatermarkFilter enhancedWatermarkFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/enhanced-watermark/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/enhanced-watermark/{filter_id}")
    EnhancedWatermarkFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/enhanced-watermark")
    List<EnhancedWatermarkFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
