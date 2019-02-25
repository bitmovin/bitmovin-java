package com.bitmovin.api.encoding.outputs.s3;

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
    
    @RequestLine("POST /encoding/outputs/s3")
    S3Output create(S3Output s3Output) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/s3/{output_id}")
    S3Output delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/s3/{output_id}")
    S3Output get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/s3")
    List<S3Output> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
