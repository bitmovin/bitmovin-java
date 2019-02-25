package com.bitmovin.api.encoding.inputs.https;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface HttpsClient {
    
    @RequestLine("POST /encoding/inputs/https")
    HttpsInput create(HttpsInput httpsInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/https/{input_id}")
    HttpsInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/https/{input_id}")
    HttpsInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/https")
    List<HttpsInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
