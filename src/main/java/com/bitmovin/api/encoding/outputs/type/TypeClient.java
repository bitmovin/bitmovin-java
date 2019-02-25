package com.bitmovin.api.encoding.outputs.type;

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
    
    @RequestLine("GET /encoding/outputs/{output_id}/type")
    OutputTypeResponse get(@Param("output_id") String outputId) throws BitmovinException;
}
