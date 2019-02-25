package com.bitmovin.api.encoding.outputs.gcs;

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
    
    @RequestLine("POST /encoding/outputs/gcs")
    GcsOutput create(GcsOutput gcsOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/gcs/{output_id}")
    GcsOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/gcs/{output_id}")
    GcsOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/gcs")
    List<GcsOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
