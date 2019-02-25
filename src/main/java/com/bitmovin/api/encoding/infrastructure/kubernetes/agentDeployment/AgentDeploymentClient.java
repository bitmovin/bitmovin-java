package com.bitmovin.api.encoding.infrastructure.kubernetes.agentDeployment;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface AgentDeploymentClient {
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}/agent-deployment")
    Object get(@Param("infrastructure_id") String infrastructureId) throws BitmovinException;
}
