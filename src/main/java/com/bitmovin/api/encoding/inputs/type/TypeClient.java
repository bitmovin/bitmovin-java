package com.bitmovin.api.encoding.inputs.type;

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
    
    @RequestLine("GET /encoding/inputs/{input_id}/type")
    InputTypeResponse get(@Param("input_id") String inputId) throws BitmovinException;
}
