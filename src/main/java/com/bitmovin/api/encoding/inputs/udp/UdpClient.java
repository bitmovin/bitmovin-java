package com.bitmovin.api.encoding.inputs.udp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface UdpClient {
    
    @RequestLine("GET /encoding/inputs/udp/{input_id}")
    UdpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/udp")
    List<UdpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
