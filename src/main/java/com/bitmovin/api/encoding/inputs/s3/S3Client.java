package com.bitmovin.api.encoding.inputs.s3;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface S3Client {
    
    @RequestLine("POST /encoding/inputs/s3")
    S3Input create(S3Input s3Input) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/s3/{input_id}")
    BitmovinResponse delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/s3/{input_id}")
    S3Input get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/s3")
    List<S3Input> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
