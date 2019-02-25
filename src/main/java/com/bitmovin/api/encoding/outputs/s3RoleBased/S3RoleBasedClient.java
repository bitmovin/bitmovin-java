package com.bitmovin.api.encoding.outputs.s3RoleBased;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface S3RoleBasedClient {
    
    @RequestLine("POST /encoding/outputs/s3-role-based")
    S3RoleBasedOutput create(S3RoleBasedOutput s3RoleBasedOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/s3-role-based/{output_id}")
    S3RoleBasedOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/s3-role-based/{output_id}")
    S3RoleBasedOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/s3-role-based")
    List<S3RoleBasedOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
