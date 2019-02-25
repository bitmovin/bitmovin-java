package com.bitmovin.api.encoding.inputs.genericS3;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface GenericS3Client {
    
    @RequestLine("POST /encoding/inputs/generic-s3")
    GenericS3Input create(GenericS3Input genericS3Input) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/generic-s3/{input_id}")
    GenericS3Input delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/generic-s3/{input_id}")
    GenericS3Input get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/generic-s3")
    List<GenericS3Input> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
