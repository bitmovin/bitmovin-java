package com.bitmovin.api.encoding.inputs.aspera;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AsperaClient {
    
    @RequestLine("POST /encoding/inputs/aspera")
    AsperaInput create(AsperaInput asperaInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/aspera/{input_id}")
    AsperaInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/aspera/{input_id}")
    AsperaInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/aspera")
    List<AsperaInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
