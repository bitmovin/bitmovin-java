package com.bitmovin.api.encoding.inputs.s3.customdata;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface CustomdataClient {
    
    @RequestLine("GET /encoding/inputs/s3/{input_id}/customData")
    CustomData getCustomData(@Param("input_id") String inputId) throws BitmovinException;
}
