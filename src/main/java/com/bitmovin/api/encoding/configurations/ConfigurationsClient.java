package com.bitmovin.api.encoding.configurations;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface ConfigurationsClient {
    
    @RequestLine("GET /encoding/configurations")
    List<CodecConfiguration> list(@QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
