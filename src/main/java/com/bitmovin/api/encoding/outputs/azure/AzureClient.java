package com.bitmovin.api.encoding.outputs.azure;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AzureClient {
    
    @RequestLine("POST /encoding/outputs/azure")
    AzureOutput create(AzureOutput azureOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/azure/{output_id}")
    AzureOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/azure/{output_id}")
    AzureOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/azure")
    List<AzureOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
