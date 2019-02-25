package com.bitmovin.api.encoding.inputs.azure;

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
    
    @RequestLine("POST /encoding/inputs/azure")
    AzureInput create(AzureInput azureInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/azure/{input_id}")
    AzureInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/azure/{input_id}")
    AzureInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/azure")
    List<AzureInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
