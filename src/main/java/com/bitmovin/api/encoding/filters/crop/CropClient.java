package com.bitmovin.api.encoding.filters.crop;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CropClient {
    
    @RequestLine("POST /encoding/filters/crop")
    CropFilter create(CropFilter cropFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/crop/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/crop/{filter_id}")
    CropFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/crop")
    List<CropFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
