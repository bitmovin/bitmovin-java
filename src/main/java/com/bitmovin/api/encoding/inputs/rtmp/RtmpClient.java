package com.bitmovin.api.encoding.inputs.rtmp;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface RtmpClient {
    
    @RequestLine("GET /encoding/inputs/rtmp/{input_id}")
    RtmpInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/rtmp")
    List<RtmpInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
