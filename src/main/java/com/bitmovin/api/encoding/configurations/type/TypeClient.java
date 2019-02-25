package com.bitmovin.api.encoding.configurations.type;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface TypeClient {
    
    @RequestLine("GET /encoding/configurations/{configuration_id}/type")
    CodecConfigTypeResponse get(@Param("configuration_id") String configurationId) throws BitmovinException;
}
