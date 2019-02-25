package com.bitmovin.api.encoding.infrastructure.kubernetes.prewarmedDeployment;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface PrewarmedDeploymentClient {
    
    @RequestLine("POST /encoding/infrastructure/kubernetes/{infrastructure_id}/prewarmed-deployment")
    PrewarmEncoderSettings create(@Param("infrastructure_id") String infrastructureId, PrewarmEncoderSettings prewarmEncoderSettings) throws BitmovinException;
    
    @RequestLine("DELETE /encoding/infrastructure/kubernetes/{infrastructure_id}/prewarmed-deployment/{deployment_id}")
    BitmovinResponse delete(@Param("infrastructure_id") String infrastructureId, @Param("deployment_id") String deploymentId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}/prewarmed-deployment/{deployment_id}")
    PrewarmEncoderSettings get(@Param("infrastructure_id") String infrastructureId, @Param("deployment_id") String deploymentId) throws BitmovinException;
    
    @RequestLine("GET /encoding/infrastructure/kubernetes/{infrastructure_id}/prewarmed-deployment")
    List<PrewarmEncoderSettings> list(@Param("infrastructure_id") String infrastructureId, @QueryMap Map<String, Object> queryParams) throws BitmovinException;
}
