package com.bitmovin.api.encoding.inputs.local;

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
    
    @RequestLine("POST /encoding/inputs/local")
    LocalInput create(LocalInput localInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/local/{input_id}")
    LocalInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/local/{input_id}")
    LocalInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/local")
    List<LocalInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
