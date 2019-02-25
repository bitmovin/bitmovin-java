package com.bitmovin.api.encoding.outputs.akamaiNetstorage;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AkamaiNetstorageClient {
    
    @RequestLine("POST /encoding/outputs/akamai-netstorage")
    AkamaiNetStorageOutput create(AkamaiNetStorageOutput akamaiNetStorageOutput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/outputs/akamai-netstorage/{output_id}")
    AkamaiNetStorageOutput delete(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/akamai-netstorage/{output_id}")
    AkamaiNetStorageOutput get(@Param("output_id") String outputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/outputs/akamai-netstorage")
    List<AkamaiNetStorageOutput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
