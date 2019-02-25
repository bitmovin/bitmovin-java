package com.bitmovin.api.encoding.inputs.tcp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TcpClient {
    
    @RequestLine("GET /encoding/inputs/tcp/{input_id}")
    TcpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/tcp")
    List<TcpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
