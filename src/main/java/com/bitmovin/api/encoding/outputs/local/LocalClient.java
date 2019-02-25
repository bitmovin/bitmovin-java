package com.bitmovin.api.encoding.outputs.local;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface LocalClient {
    
    @RequestLine("POST /encoding/outputs/local")
    LocalOutput create(LocalOutput localOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/local/{output_id}")
    LocalOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/local/{output_id}")
    LocalOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/local")
    List<LocalOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
