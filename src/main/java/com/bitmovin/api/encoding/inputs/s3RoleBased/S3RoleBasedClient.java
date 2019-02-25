package com.bitmovin.api.encoding.inputs.s3RoleBased;

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
    
    @RequestLine("POST /encoding/inputs/s3-role-based")
    S3RoleBasedInput create(S3RoleBasedInput s3RoleBasedInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/s3-role-based/{input_id}")
    S3RoleBasedInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/s3-role-based/{input_id}")
    S3RoleBasedInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/s3-role-based")
    List<S3RoleBasedInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
