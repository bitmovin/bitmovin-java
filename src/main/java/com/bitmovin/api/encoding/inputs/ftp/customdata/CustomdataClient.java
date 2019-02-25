package com.bitmovin.api.encoding.inputs.ftp.customdata;

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
    
    @RequestLine("GET /encoding/inputs/ftp/{input_id}/customData")
    CustomData getCustomData(@Param("input_id") String inputId) throws BitmovinException;
}
