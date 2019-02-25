package com.bitmovin.api.encoding.inputs.akamaiNetstorage;

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
    
    @RequestLine("POST /encoding/inputs/akamai-netstorage")
    AkamaiNetStorageInput create(AkamaiNetStorageInput akamaiNetStorageInput) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/inputs/akamai-netstorage/{input_id}")
    AkamaiNetStorageInput delete(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/akamai-netstorage/{input_id}")
    AkamaiNetStorageInput get(@Param("input_id") String inputId) throws BitmovinException;
    
    @RequestLine("GET /encoding/inputs/akamai-netstorage")
    List<AkamaiNetStorageInput> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
