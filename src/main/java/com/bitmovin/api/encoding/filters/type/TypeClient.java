package com.bitmovin.api.encoding.filters.type;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TypeClient {
    
    @RequestLine("GET /encoding/filters/{filter_id}/type")
    FilterTypeResponse get(@Param("filter_id") String filterId) throws BitmovinException;
}
