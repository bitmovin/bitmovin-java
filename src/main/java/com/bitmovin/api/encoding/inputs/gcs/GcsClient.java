package com.bitmovin.api.encoding.inputs.gcs;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface GcsClient {
    
    @RequestLine("POST /encoding/inputs/gcs")
    GcsInput create(GcsInput gcsInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/gcs/{input_id}")
    GcsInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/gcs/{input_id}")
    GcsInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/gcs")
    List<GcsInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
