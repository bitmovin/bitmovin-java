package com.bitmovin.api.encoding.inputs.http;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface HttpClient {
    
    @RequestLine("POST /encoding/inputs/http")
    HttpInput create(HttpInput httpInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/http/{input_id}")
    HttpInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/http/{input_id}")
    HttpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/http")
    List<HttpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
