package com.bitmovin.api.encoding.infrastructure.kubernetes.status;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface StatusClient {
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}/status")
    Object get(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
}
