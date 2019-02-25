package com.bitmovin.api.encoding.filters.deinterlace;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DeinterlaceClient {
    
    @RequestLine("POST /encoding/filters/deinterlace")
    DeinterlaceFilter create(DeinterlaceFilter deinterlaceFilter) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/filters/deinterlace/{filter_id}")
    BitmovinResponse delete(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/deinterlace/{filter_id}")
    DeinterlaceFilter get(@Param("filter_id") String filterId) throws BitmovinException;
    
    @RequestLine("GET /encoding/filters/deinterlace")
    List<DeinterlaceFilter> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
