package com.bitmovin.api.encoding.filters.watermark;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface WatermarkClient {
    
    @RequestLine("POST /encoding/filters/watermark")
    WatermarkFilter create(WatermarkFilter watermarkFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/watermark/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/watermark/{filter_id}")
    WatermarkFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/watermark")
    List<WatermarkFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
