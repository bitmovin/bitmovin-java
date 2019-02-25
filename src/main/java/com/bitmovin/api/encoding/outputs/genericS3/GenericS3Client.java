package com.bitmovin.api.encoding.outputs.genericS3;

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
    
    @RequestLine("POST /encoding/outputs/generic-s3")
    GenericS3Output create(GenericS3Output genericS3Output) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/generic-s3/{output_id}")
    GenericS3Output delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/generic-s3/{output_id}")
    GenericS3Output get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/generic-s3")
    List<GenericS3Output> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
